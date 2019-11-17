import java.util.Collections;
import java.util.List;

public class Sort {
    public List<String> bubbleSort(List<String> directory) {
        for (int i = 0; i < directory.size()-1; i++) {
            for (int j = 0; j < directory.size()-i-1; j++) {
                String line = directory.get(j).substring(directory.get(j).indexOf(' ') + 1);
                String nextLine = directory.get(j+1).substring(directory.get(j+1).indexOf(' ') + 1);
                if(line.compareTo(nextLine) > 0) {
                    String temp = directory.get(j);
                    directory.remove(j);
                    directory.add(j+1, temp);
                }
            }
        }
        return directory;
    }

//    use rightmost index as pivot
    public void quickSort(List<String> directory, int left, int right) {
        if(left < right) {
            int partitionInd = partition(directory, left, right);
            quickSort(directory, left, partitionInd - 1);
            quickSort(directory, partitionInd + 1, right);
        }
    }

    private static int partition(List<String> names, int left, int right) {
        String pivot = names.get(right)
                .substring(names.get(right).indexOf(' ') + 1);
        int partitionInd = left;
        for (int i = left; i < right; i++) {
            String name = names.get(i)
                    .substring(names.get(i).indexOf(' ') + 1);
            if(name.compareTo(pivot) < 0) {
                Collections.swap(names, i, partitionInd);
                partitionInd++;
            }
        }
        Collections.swap(names, partitionInd, right);
        return partitionInd;
    }
}
