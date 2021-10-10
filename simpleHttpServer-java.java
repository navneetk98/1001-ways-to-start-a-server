import java.net.*;
import java.io.*;
import java.util.*;


class javaSimpleHTTPServer
{
 public static void main(String[] args)
 {
  ServerSocket socket = null;
  Socket connection = null;
  try {
   ServerSocket socket = new ServerSocket(8080);

   while (true) {
    Socket connection = socket.accept();

    try {
     BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
     OutputStream out = new BufferedOutputStream(connection.getOutputStream());
     PrintStream pout = new PrintStream(out);

     String request=in.readLine();
     if (request==null) continue;

     while (true) {
      String ignore=in.readLine();
      if (ignore==null || ignore.length()==0) break;
     }

     if (!request.startsWith("GET ") || !(request.endsWith(" HTTP/1.0") || request.endsWith(" HTTP/1.1"))) {
      pout.print("HTTP/1.0 400 Bad Request"+"\r\n\r\n");
     }
     else {
      String response="Hello, World!";

      pout.print(
       "HTTP/1.0 200 OK"+"\r\n"+
       "Content-Type: text/plain"+"\r\n"+
       "Date: "+new Date()+"\r\n"+
       "Content-length: "+response.length()+"\r\n\r\n"+
       response
      );
     }
     pout.close();
    }
    catch (Throwable ignored) { }
   }
  }
  catch (Throwable ignored) { }
 }
}