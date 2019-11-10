import java.util.List;

public class Search {

    public String linearSearch(List<String> findList, List<String> fileList) {
        int found = 0;
        int numberOfLines = findList.size();
        for (String s: findList) {
            for(String line: fileList) {
                line = line.substring(line.indexOf(' ')+1);
                if(s.equals(line)) {
                    found++;
                    break;
                }
            }
        }
        return "Found " + found + "/" + numberOfLines + " entries.";
    }

    public int jumpSearch(List<String> directory, String element) {
        int previousStep = 0;
        int jumpStep = (int) Math.sqrt(directory.size());
        while(directory.get(Math.min(jumpStep, directory.size()) - 1).compareTo(element) < 0) {
            previousStep = jumpStep;
            jumpStep += (int)(Math.sqrt(directory.size()));
            if(previousStep >= directory.size()) {
                return -1;
            }
        }
        while(directory.get(previousStep).compareTo(element) < 0) {
            previousStep++;
            if(previousStep == Math.min(jumpStep, directory.size())){
                return -1;
            }
        }
        if(directory.get(previousStep).compareTo(element) == 0) {
            return previousStep;
        }
        return -1;
    }

    public String jumpSearchFile(List<String> directory, List<String> findList) {
        int found = 0;
        int numberOfLines = 0;
        for(String s: findList) {
            int val = jumpSearch(directory, s);
            if(val > -1) {
                found++;
            }
            numberOfLines++;
        }
        return "Found " + found + "/" + numberOfLines + " entries";
    }
}
