package golub.internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
   
public class ServerSockedDemo {
	
	public static void main(String[]args) throws IOException{
		//SERVER
		ServerSocket ss = new ServerSocket(52746);
		
		Socket socket = ss.accept();
		
		InputStream in = socket.getInputStream();
		BufferedReader buffer = new BufferedReader(new InputStreamReader(in));
		String response = buffer.readLine();
		System.out.println("RESPONSE ");
		System.out.println(response);
		
		PrintWriter out = new PrintWriter(socket.getOutputStream());
		out.write("HOW ARE YOU?!?!\n");
		out.flush();
		
		ss.close();
	
		
		
		
		
	}

}
