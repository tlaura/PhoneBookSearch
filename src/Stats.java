import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Stats {
    private Search search;
    private Sort sort;
    File file;
    File find;
    private final List<String> findList = new ArrayList<>();
    private final List<String> fileList = new ArrayList<>();

    public Stats(File file, File find) throws FileNotFoundException {
        this.search = new Search();
        this.sort = new Sort();
        this.file = file;
        this.find = find;
        setDirectoryList();
        setList();
    }

    private void setList() throws FileNotFoundException {
        Scanner findScan = new Scanner(find);
        while (findScan.hasNextLine()) {
            findList.add(findScan.nextLine());
        }
    }

    private void setDirectoryList() throws FileNotFoundException {
        Scanner fileScan = new Scanner(file);
        while(fileScan.hasNextLine()) {
            fileList.add(fileScan.nextLine());
        }
    }

    public void quickSortAndBinarySearch() {
        System.out.println("Start searching (quick sort + binary search)...");

        long sortStart = System.currentTimeMillis();
        sort.quickSort(fileList, 0, fileList.size()-1);
        long sortEnd = System.currentTimeMillis();
        long msSort = sortEnd - sortStart;
        System.out.println("Sorting time: " + getDurationBreakdown(msSort));

        long searchStart = System.currentTimeMillis();
        long searchEnd = System.currentTimeMillis();
        long msSearch = searchEnd - searchStart;
//        System.out.println(found + "Searching time: " + getDurationBreakdown(msSearch));

    }

    public void linearSearch() {
        System.out.println("Start searching (linear search)...");
        long start = System.currentTimeMillis();
        String res = search.linearSearch(findList, fileList);
        long end = System.currentTimeMillis();
        long milliseconds = end-start;
        System.out.println(res + " Time taken: " + getDurationBreakdown(milliseconds));
    }

    public void bubbleAndJump() {
        System.out.println("Start searching (bubble sort + jump search)...");

        long sortStart = System.currentTimeMillis();
        List<String> sortedDir = sort.bubbleSort(fileList);
        long sortEnd = System.currentTimeMillis();
        long msSort = sortEnd - sortStart;
        System.out.println("Sorting time: " + getDurationBreakdown(msSort));

        long searchStart = System.currentTimeMillis();
        String found = search.jumpSearchFile(sortedDir, findList);
        long searchEnd = System.currentTimeMillis();
        long msSearch = searchEnd - searchStart;
        System.out.println(found + "Searching time: " + getDurationBreakdown(msSearch));
    }

    public static String getDurationBreakdown(long milliseconds) {
        long minutes = TimeUnit.MILLISECONDS.toMinutes(milliseconds);
        milliseconds -= TimeUnit.MINUTES.toMillis(minutes);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(milliseconds);
        milliseconds -= TimeUnit.SECONDS.toMillis(seconds);

        StringBuilder sb = new StringBuilder();

        sb.append(minutes);
        sb.append(" min. ");
        sb.append(seconds);
        sb.append(" sec. ");
        sb.append(milliseconds);
        sb.append(" ms.");

        return sb.toString();
    }

}
