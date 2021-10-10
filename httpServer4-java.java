import org.rapidoid.buffer.Buf;
import org.rapidoid.http.AbstractHttpServer;
import org.rapidoid.http.HttpStatus;
import org.rapidoid.http.MediaType;
import org.rapidoid.net.abstracts.Channel;
import org.rapidoid.net.impl.RapidoidHelper;


class HttpServerReturns extends AbstractHttpServer
{
 private static final int port = 8080;
 private static final byte HOME[] = "/".getBytes();
 private static final byte HELLO_WORLD[] = "Hello, World!".getBytes();

 @Override
 protected HttpStatus handle(Channel ctx, Buf buf, RapidoidHelper req)
 {
  if (req.isGet.value && matches(buf, req.path, HOME))
  {
   return ok(ctx, req.isKeepAlive.value, HELLO_WORLD, MediaType.TEXT_PLAIN);
  }

  return HttpStatus.NOT_FOUND;
 }

 public static void main(String[] args) throws Exception
 {
  new RapidoidHttpFast().listen(port);
 }
}