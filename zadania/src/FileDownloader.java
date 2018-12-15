import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class FileDownloader implements UrlDownloader {
  @Override
  public void download(String url) {
    try {
      URL urlObject = new URL(url);
      System.out.println(String.format("Downloading file %s",url));
      Path file = Paths.get("" + filename(url)+".png");
      InputStream stream = urlObject.openConnection().getInputStream();

      Files.copy(stream, file);
      System.out.println(String.format("Saved utl %s to file %s",url,file));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private String filename(String s) {
    return String.format("file-%s", new Random().nextInt(1000));
  }
}
