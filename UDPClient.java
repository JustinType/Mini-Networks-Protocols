import java.net.*;

public class UDPClient {

	public static void main(String args[]) {
		try {
			if (args.length != 3) {
				System.out.println("Il faut 3 paramètres : l'ip / le port / le message");
			} else {
			
				int port = Integer.parseInt(args[1]);
				InetAddress adresse = InetAddress.getByName(args[0]);
				
				DatagramSocket ds = new DatagramSocket();
			    
				byte[] buff = args[2].getBytes();
				DatagramPacket dp = new DatagramPacket(buff, args[2].length(), adresse, port);
			    
			    ds.send(dp);
			    ds.close();
			    
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
