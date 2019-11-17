import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> list =  new ArrayList<>();
        File file = new File("/Users/tundelaura/Desktop/java/directory.txt");
        File find = new File("/Users/tundelaura/Desktop/java/find.txt");
        Stats stat = new Stats(file, find);
        stat.linearSearch();
        System.out.println();
//        stat.bubbleAndJump();
        stat.quickSortAndBinarySearch();

//        Scanner scanner = new Scanner(System.in);
//        list.add("Lyndel Raymond");
//        list.add("Meta Joappa");
//        list.add("Kynthia Nadbus");
//        list.add("Ethelind Skeie");
//        list.add("Shoshana Utica");
//        list.add("Marisa Firman");
//        list.add("Gwenette Anagnos");
//
//        Sort sort = new Sort();
//        sort.quickSort(list, 0, list.size()-1);
//
//        for (String s: list) {
//            System.out.println(s);
//        }
    }
}
