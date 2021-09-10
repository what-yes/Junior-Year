package a;

import java.io.*;
import java.net.*;
import java.util.*;
import java.text.*;

public class Server {

	public static void main(String[] args) {
		try {

			ServerSocket ss = new ServerSocket(8081);
			Socket s = ss.accept();
			InputStream in = s.getInputStream();
			OutputStream out = s.getOutputStream();

			BufferedReader br = new BufferedReader(new InputStreamReader(in, "ISO-8859-1"));
			String str = "";
			while (true) {
				str = br.readLine();
				if (str.length() == 0) {
					System.out.println();

					PrintWriter pw = new PrintWriter(new OutputStreamWriter(out, "ISO-8859-1"));
					pw.print("HTTP/1.1 200 OK\r\n");  //HTTP/1.1 200
					pw.print("Content-Type: text/html;charset=ISO-8859-1\r\n");
					pw.print("Content-Length: 14\r\n");

					Calendar cd = Calendar.getInstance();
					SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
					sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
					String s_date = sdf.format(cd.getTime());

					pw.print("Date: " + s_date + "\r\n");

					pw.print("\r\n");
					pw.print("<h1>hello</h1>");
					pw.flush();
					pw.close();
					
					break;

				} else {
					System.out.println(str);
				}
			}
			System.out.println("response finished.");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
