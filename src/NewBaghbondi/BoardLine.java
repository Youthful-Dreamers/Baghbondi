package NewBaghbondi;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class BoardLine {

    private Line verticalLine1 = new Line();
    private Line verticalLine2 = new Line();
    private Line verticalLine3 = new Line();
    private Line horizontalLine1 = new Line();
    private Line horizontalLine2 = new Line();
    private Line horizontalLine3 = new Line();
    private Line horizontalLine4 = new Line();

    private Group lineGroup = new Group();

    public void setVerticalLine1(Circle circle1,Circle circle2) {
        this.verticalLine1 = makeLine(circle1,circle2);
    }
    public void setVerticalLine2(Circle circle1,Circle circle2) {
        this.verticalLine2 = makeLine(circle1,circle2);
    }
    public void setVerticalLine3(Circle circle1,Circle circle2) {
        this.verticalLine3 = makeLine(circle1,circle2);
    }

    public void setHorizontalLine1(Circle circle1,Circle circle2) {
        this.horizontalLine1 = makeLine(circle1,circle2);
    }
    public void setHorizontalLine2(Circle circle1,Circle circle2) {
        this.horizontalLine2 = makeLine(circle1,circle2);
    }
    public void setHorizontalLine3(Circle circle1,Circle circle2) {
        this.horizontalLine3 = makeLine(circle1,circle2);
    }
    public void setHorizontalLine4(Circle circle1,Circle circle2) {
        this.horizontalLine4 = makeLine(circle1,circle2);
    }

    protected Group createLineGroup(){
        lineGroup.getChildren().add(verticalLine1);
        lineGroup.getChildren().add(verticalLine2);
        lineGroup.getChildren().add(verticalLine3);
        lineGroup.getChildren().add(horizontalLine1);
        lineGroup.getChildren().add(horizontalLine2);
        lineGroup.getChildren().add(horizontalLine3);
        lineGroup.getChildren().add(horizontalLine4);
        return lineGroup;
    }

    private Line makeLine(Circle circle1, Circle circle2) {
        Line line = new Line();
        line.setStartX(circle1.getLayoutX());
        line.setStartY(circle1.getLayoutY());
        line.setEndX(circle2.getLayoutX());
        line.setEndY(circle2.getLayoutY());
        line.setFill(Color.LIGHTGREEN);
        return line;
    }
}
