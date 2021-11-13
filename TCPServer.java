import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class TCPServer {

	public static void main(String args[]) {
		try {
			
			if (args.length != 1) {
				System.out.println("Il faut 1 paramètre : le port");
			} else {
				int port = Integer.parseInt(args[0]);
		        ServerSocket serversoc = new ServerSocket(port);
		        Socket s = serversoc.accept();
		        
		        PrintWriter p = new PrintWriter(s.getOutputStream());
		        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		        BufferedReader b2 = new BufferedReader(new InputStreamReader(s.getInputStream()));
		        String message, recu;
		        
		        while (true) {
		        	System.out.println("Message à envoyer au client : ");
		        	message = b.readLine();
		            p.println(message);
		            p.flush();

		            if (message.equals("STOP")) {
		                break;
		            } else {
		            	recu = b2.readLine();
		                System.out.println("Message reçu du client : " + recu);
		                if (recu.equals("STOP")) {
		                    break;
		                }
		            }
		        }
		        serversoc.close();
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}

