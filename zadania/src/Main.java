import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
//    CommendLineRunner commendLineRunner = new CommendLineRunner(
//            url -> System.out.printf("Downloading file %s\n", url)
//    );
    CommendLineRunner commendLineRunner = new CommendLineRunner(new FileDownloader());

    commendLineRunner.run(System.in);
  }
}
