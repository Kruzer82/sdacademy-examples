import com.sun.tools.internal.ws.wsdl.document.Input;

import java.io.InputStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CommendLineRunner {
  private UrlDownloader downloader;

  public CommendLineRunner(UrlDownloader downloader) {
    this.downloader = downloader;
  }

  void run(InputStream inputStream) {
    Scanner scanner = new Scanner(inputStream);
    scanner.useDelimiter("\n");
    String regex = "\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

    while (scanner.hasNext()) {
      String command = scanner.next();
      if(IsMatch(command,regex)){
        downloadURL(command);
      }
      else if("exit".equals(command)){
        return;
      }
      else{
        downloadURL(command);
      }

    }

  }

  private void downloadURL(String command) {
    Thread thread = new Thread(() -> downloader.download(command));
    thread.start();
  }


  private static boolean IsMatch(String s, String pattern) {
    try {
      Pattern patt = Pattern.compile(pattern);
      Matcher matcher = patt.matcher(s);
      return matcher.matches();
    } catch (RuntimeException e) {
      return false;
    }
  }
}

