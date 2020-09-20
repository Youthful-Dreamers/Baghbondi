package codes;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class GetIP {

    private String IP;

    protected GetIP() {
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            IP = localHost.getHostAddress().trim();
        } catch (UnknownHostException e) {
            System.out.println("Exception in getting the localHost: " + e);
        }
    }

    protected String getIP() {
        return IP;
    }
}

