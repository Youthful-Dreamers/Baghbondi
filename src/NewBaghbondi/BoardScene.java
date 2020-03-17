package NewBaghbondi;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BoardScene{

    static final int positionSize = 50;
    private Group positionGroup = new Group();
    private Group pieceGroup = new Group();
    private BoardLines lineGroup = new BoardLines();
    private Position[][] board = new Position[5][5];
    private int verticalLine = 5;
    private int horizontalLine = 5;
    private int turn = 0;
    BoardListener listener = new BoardListener(board,pieceGroup);

    Stage boardStage = new Stage();
    Button button = new Button();
    Button button0 = new Button();
    Button button1 = new Button();
    Button button2 = new Button();

    private Parent createContent()
    {
        Pane root = new Pane();
        root.setPrefSize(800, 600);
        drawBoard();
        drawLine();
        root.getChildren().addAll(positionGroup, pieceGroup,lineGroup.getLineGroup());
        return root;
    }

    public void boardSceneView()
    {
        boardStage.setScene(createMain());
        boardStage.setTitle("BaghBondi");
        boardStage.show();
    }

    private void drawBoard()
    {
        System.out.println("****************Called drawBoard()****************");
        int skip, skipCounter;
        int i, j;
        for (i = -verticalLine / 2, skip = -horizontalLine / 2; i < verticalLine / 2 + 1; i++, skip++) {
            for (skipCounter = 2, j = -Math.abs(i); j < Math.abs(i) + 1; j++) {
                if (skipCounter < Math.abs(skip) - 1) {
                    skipCounter++;
                    continue;
                } else skipCounter = 0;
                Position position = createPosition(i, j);
                Piece piece = null;
                if (i >= 0) {
                    piece = makePiece(PieceTypeEnum.GOAT, i + verticalLine / 2, j + horizontalLine / 2);
                    System.out.println("Making piece type :: goat: "+position.getLayoutX()+","+position.getLayoutY());

                } else if (i == -1 && j == 0) {
                    piece = makePiece(PieceTypeEnum.TIGER, i + verticalLine / 2, j + horizontalLine / 2);
                }
                if (piece != null) {

                    position.setPiece(piece);
                    pieceGroup.getChildren().add(piece);
                }
            }
        }
    }

    private Position createPosition(int vertical, int horizontal)
    {
        System.out.println("****************Called createPosition()****************");
        Position position = new Position(vertical + verticalLine / 2, horizontal + horizontalLine / 2);
        System.out.println("On board " + (horizontal + horizontalLine / 2) + " " + (vertical + verticalLine / 2));
        board[horizontal + horizontalLine / 2][vertical + verticalLine / 2] = position;
        positionGroup.getChildren().add(position);
        return position;
    }

    private Piece makePiece(PieceTypeEnum pieceTypeEnum, int vertical, int horizontal)
    {
        System.out.println("-----Called makePiece()-----");
        Piece piece;
        if(pieceTypeEnum==PieceTypeEnum.TIGER)
         piece = new Tiger(vertical, horizontal);
        else
            piece = new Goat(vertical,horizontal);
        listener.addMouseReleaseOptions(piece);
        return piece;

    }


    private void drawLine()
    {
        lineGroup.setHorizontalLine1(board[0][0],board[4][0]);
        lineGroup.setHorizontalLine2(board[1][1],board[3][1]);
        lineGroup.setHorizontalLine3(board[1][3],board[3][3]);
        lineGroup.setHorizontalLine4(board[0][4],board[4][4]);
        lineGroup.setVerticalLine1(board[0][0],board[4][4]);
        lineGroup.setVerticalLine2(board[2][0],board[2][4]);
        lineGroup.setVerticalLine3(board[4][0],board[0][4]);
    }


    private Scene createLanguageOption()
    {
        Label label= new Label("Please select a language:");

        button1.setText("Bengali");
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boardStage.setScene(new Scene(createContent()));
            }
        });

        button2.setText("English");
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boardStage.setScene(new Scene(createContent()));
            }
        });

        VBox vBox= new VBox(5);

        vBox.setAlignment(Pos.CENTER);

        vBox.getChildren().addAll(label,button1,button2);


        Scene scene = new Scene(vBox,800,600);

        return scene;
    }

    private Scene createMain()
    {
        Label label= new Label("           Welcome!\nPlease select an option:");
        button.setText("Start Default Game");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boardStage.setScene(new Scene(createContent()));
            }
        });

        button0.setText("Language Options");
        button0.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boardStage.setScene(createLanguageOption());
            }
        });

        VBox layout = new VBox(5);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(label,button,button0);

        Scene scene = new Scene(layout, 800,600);

        return scene;
    }

}
