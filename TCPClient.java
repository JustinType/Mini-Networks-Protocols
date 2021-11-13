import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;


public class TCPClient {

	public static void main(String args[]) {
		try {
			
			if (args.length != 2) {
				System.out.println("Il faut 2 paramètres : l'adresse et le port");
			} else {
				InetAddress adresse = InetAddress.getByName(args[0]);
		        int port = Integer.parseInt(args[1]);
		        Socket s = new Socket(adresse, port);
		        
		        PrintWriter p = new PrintWriter(s.getOutputStream());
		        BufferedReader b = new BufferedReader(new InputStreamReader(s.getInputStream()));
		        BufferedReader b2 = new BufferedReader(new InputStreamReader(System.in));
		        String message, recu;
		        
		        while (true) {
		        	recu = b.readLine();
		            System.out.println("Message reçu du serveur : " + recu); 
		            if (recu.equals("STOP")) {
		            	s.close();
		                break;
		            } else {
		                System.out.println("Message à envoyer au serveur : ");
		                message = b2.readLine();
		                p.println(message);
		                p.flush();
		                if (message.equals("STOP")) {
		                    break;
		                }
		            }
		        }
		        s.close();
				
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}

