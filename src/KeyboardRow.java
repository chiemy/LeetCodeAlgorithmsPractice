import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KeyboardRow {
    public String[] findWords(String[] words) {
        List<String> list = new ArrayList<>();
        for (String s : words) {
            if (isAllInRow(s.toLowerCase())) {
                list.add(s);
            }
        }
        return list.toArray(new String[list.size()]);
    }

    private boolean isAllInRow(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!isInRow(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean isInRow(char c) {
        switch (c){
            case 'a':
            case 's':
            case 'd':
            case 'f':
            case 'g':
            case 'h':
            case 'j':
            case 'k':
            case 'l':
                return true;
        }
        return false;
    }
}
