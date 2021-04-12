import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class WebClient {

	public static void main(String[] args) throws IOException {
		String host = "example.com";
		String resource = "/";

		final int HTTP_PORT = 80;
		Socket s = new Socket(host, HTTP_PORT);

		InputStream instream = s.getInputStream();
		OutputStream outstream = s.getOutputStream();

		Scanner in = new Scanner(instream);
		PrintWriter out = new PrintWriter(outstream);

		String command = "GET " + resource + " HTTP/1.0\n\n";
		out.print(command);
		out.flush();

		while (in.hasNextLine()) {
			String input = in.nextLine();
			System.out.println(input);
		}

		s.close();
	}

}
