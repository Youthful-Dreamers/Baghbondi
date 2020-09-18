package code;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class GetIP {

    private String IP;

    protected GetIP() throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        IP = localHost.getHostAddress().trim();
    }

    protected String getIP(){
        return IP;
    }
}

