import org.takes.http.Exit;
import org.takes.http.FtBasic;
import org.takes.facets.fork.FkRegex;
import org.takes.facets.fork.TkFork;


public final class TheRiseOfHttpServer
{

 public static void main(final String... args) throws Exception
 {
  new FtBasic(
   new TkFork(new FkRegex("/", "Yoooooooooooooo!")), 8080
  ).start(Exit.NEVER);
 }
}