import java.net.*;

public class UDPServer {

	public static void main(String args[]) {
		try {
			if (args.length != 1) {
				System.out.println("Il faut 1 paramètre : le port");
			} else {
			
				int port = Integer.parseInt(args[0]);
				DatagramSocket ds = new DatagramSocket(port);
				System.out.println("En attente d'un message");
				while (true) {
					
					byte [] buff = new byte[50];
					DatagramPacket dp = new DatagramPacket(buff, buff.length);
					ds.receive(dp);
					buff = dp.getData();
					String message = new String(buff);
					System.out.println("Message trouvé : "+message);
					ds.close();
				}
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
