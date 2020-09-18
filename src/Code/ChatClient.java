package code;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.net.Socket;
import java.net.InetAddress;


public class ChatClient {
    public static void main(String[] args) {
        String destIP = "127.0.0.1"; 
        int destPort = 8000; 


        for(int i=0; i<args.length; i+=2) {
            if(args[i].equals("--port")) {
                destPort = Integer.parseInt(args[i+1]);
            } else if(args[i].equals("--server")) {
                destIP = args[i+1];
            } else {
                return;
            }
        }



        Scanner sc = new Scanner(System.in);
        PrintStream out = System.out;
        Socket socket = null;

        try {
            InetAddress destAddr = InetAddress.getByName(destIP);
            String localHost = "127.0.0.1";
            int localPort = 0; 
            InetAddress localAddr = InetAddress.getByName(localHost);

            out.println("creating client socket...");
            
            socket = new Socket(destAddr, destPort);
            out.println("client socket is created...");
            out.println("");

            out.println("dest addr: " + socket.getInetAddress());
            out.println("dest port: " + socket.getPort());
            out.println("local addr: " + socket.getLocalAddress());
            out.println("local port: " + socket.getLocalPort());
            out.println("");

            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);
            PrintWriter pw = new PrintWriter(bw);

            out.print("me :: ");
            String reply = sc.nextLine();
            pw.println(reply);
            pw.flush();
            while(!reply.equals("exit") && !reply.equals("quit")) {
                out.print("friend :: ");
                String message = br.readLine();
                out.println(message);
                if(message.equals("exit") || message.equals("quit")) {
                    Thread.sleep(1000);
                    break;
                }

                out.print("me :: ");
                reply = sc.nextLine();
                pw.println(reply);
                pw.flush();
            }
            out.println("");
            
            br.close();
            pw.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            try {
                out.println("closing socket...");
                socket.close();
                out.println("socket closed...");
            }
            catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}
