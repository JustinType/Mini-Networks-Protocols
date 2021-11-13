import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
	
	public static void main(String args[]) {
		try {
			if (args.length != 1) {
				System.out.println("Il faut 1 paramètre : le port");
			} else {
				byte[] crlf = new byte[2];
				crlf[0] = 0x0D;
				crlf[1] = 0x0A;
				int port = Integer.parseInt(args[0]);
		        ServerSocket serversoc = new ServerSocket(port);
		        
		        while (true) {
		        	Socket s = serversoc.accept();
		        	BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		        	DataOutputStream data = new DataOutputStream(s.getOutputStream());
		        	String recu = br.readLine();
		        	String docroot = "/home/untype/www";
		        	
		        	while (true) {
		        		if (br.readLine() == null) {
		        			break;
		        		}
		        	}
		        	
		        	
		        	String[] requete = new String[3];
		        	requete = recu.split(" ");
		        	String verbe = requete[0];
		        	String ressource = requete[1];
		        	
		        	if (verbe.equals("GET")) {
		        		
		        		if (ressource.equals("/")) {
		        			ressource = "/index.html";
		        		}
		        		
		        		// Lecture fichier
						if (new File(docroot + ressource).isFile()) {
						    FileInputStream fis = new FileInputStream(docroot + ressource);
						    int size = fis.available();
						    byte[] fichier = new byte[size];
						    fis.read(fichier);
						    data.write("HTTP/1.1 200 OK".getBytes());
						    data.write(crlf);
						    data.write(crlf);
						    data.write(fichier); 
						    fis.close();
						} else {
							data.write("HTTP/1.1 404 Error : File Not Found".getBytes());
						    data.write(crlf);
						    data.write(crlf);
						}
		        		
		        	} else {
		        		data.write("HTTP/1.1 501 Error : Not Implemend".getBytes());
					    data.write(crlf);
					    data.write(crlf);
		        	}
		        	
		        	br.close();
		        	data.close();
		        	s.close();
		        	serversoc.close();
		        	
		        }
				
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
