package golub.internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketHttpRequestDemo {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Socket socket = new Socket("www.google.com",80);
		String httpRequestString = "GET /index.html\n\n";
		
		PrintWriter out = new PrintWriter(socket.getOutputStream());
		out.write(httpRequestString);
		out.flush();
		
		InputStream in = socket.getInputStream();
		BufferedReader buffer = new BufferedReader(new InputStreamReader(in));
		String output = buffer.readLine();
		
		while ((output = buffer.readLine()) != null){
			System.out.println(output);
		}
		
		socket.close();
		buffer.close();
		
		

	}

}
