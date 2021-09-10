package a;

import java.io.*;
import java.net.*;
import java.util.*;

public class Client {

	public static void main(String[] args) {
		try {
			Socket s = new Socket("localhost", 8080);
			InputStream in = s.getInputStream();
			OutputStream out = s.getOutputStream();

			PrintWriter pw = new PrintWriter(new OutputStreamWriter(out, "ISO-8859-1"));

			BufferedReader br = new BufferedReader(new InputStreamReader(in, "ISO-8859-1"));

			// pw.print("GET / HTTP/1.1\r\n");
			//pw.print("GET /http/a HTTP/1.1\r\n");
			pw.print("GET /http/a.jpg HTTP/1.1\r\n");
			pw.print("Host: localhost:8080\r\n");

			pw.print("Connection: keep-alive\r\n");

			pw.print("Upgrade-Insecure-Requests: 1\r\n");
			pw.print(
					"User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36\r\n");

			pw.print(
					"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8\r\n");
			pw.print("Accept-Encoding: gzip, deflate, br\r\n");
			pw.print("Accept-Language: zh-CN,zh;q=0.9,en;q=0.8\r\n");

			pw.print("\r\n");

			pw.flush();
			long length = 0;
			while (true) {

				String r = br.readLine();
				System.out.println(r);

				if (r.startsWith("Content-Length")) {
					length = Long.parseLong(r.substring(16));
					
				}

				if (r.length() == 0) {
					// begin to read content-length bytes!
					while (length > 0) {

						System.out.print((char) br.read());
						length--;
					}
					break;
				}
			}

			System.out.println();
			System.out.println();

			System.out.println("over");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
