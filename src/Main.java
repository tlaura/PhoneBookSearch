import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/tundelaura/Desktop/java/directory.txt");
        File find = new File("/Users/tundelaura/Desktop/java/find.txt");
        Stats stat = new Stats(file, find);
        stat.linearSearch();
        System.out.println();
        stat.bubbleAndJump();

    }
}
