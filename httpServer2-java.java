import com.sun.net.httpserver.HttpServer;

import java.io.OutputStream;
import java.net.InetSocketAddress;


class AnotherHttpServer
{
 static final int port=8080;

 public static void main(String args[])
 {
  try
  {
   HttpServer server=HttpServer.create(new InetSocketAddress(port), 0);

   server.createContext("/", httpExchange ->
   {
    byte response[]="Hello, World!".getBytes("UTF-8");

    httpExchange.getResponseHeaders().add("Content-Type", "text/plain; charset=UTF-8");
    httpExchange.sendResponseHeaders(200, response.length);

    OutputStream out=httpExchange.getResponseBody();
    out.write(response);
    out.close();
   });

   server.start();
  }
  catch (Throwable tr)
  {
   tr.printStackTrace();
  }
 }

}