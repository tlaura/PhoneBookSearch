import java.util.List;

public class Sort {

    public List<String> bubbleSort(List<String> directory) {
        boolean flag = false;
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
        return flag ? null : directory;
    }
}
