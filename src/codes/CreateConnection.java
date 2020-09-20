package codes;

import javafx.application.Platform;

public class CreateConnection {

    private Client clientConnection;
    private Server serverConnection;
    private ChatBox chatBox;
    private String IPAddress;

    protected CreateConnection(Boolean isServer, ChatBox chatBox, String IPAddress) {
        this.chatBox = chatBox;
        this.IPAddress = IPAddress;
        if (isServer) serverConnection = createServer();
        else clientConnection = createClient();
        chatBox.inputEventHandlerServer(clientConnection, serverConnection, isServer);
    }

    private Server createServer() {
        return new Server(data -> Platform.runLater(() -> chatBox.getMessages().appendText(data.toString() + "\n")));
    }

    private Client createClient() {
        return new Client(IPAddress, data -> Platform.runLater(() -> chatBox.getMessages().appendText(data.toString() + "\n")));
    }

    protected Client getClientConnection() {
        return clientConnection;
    }

    protected Server getServerConnection() {
        return serverConnection;
    }
}
