import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/tundelaura/Desktop/java/phoneBook/directory.txt");
        File find = new File("/Users/tundelaura/Desktop/java/phoneBook/find.txt");
        Stats stat = new Stats(file, find);
        stat.linearSearch();
        System.out.println();
        stat.hashMapSearch();
        System.out.println();
        stat.quickSortAndBinarySearch();
//        stat.bubbleAndJump();
    }
}
