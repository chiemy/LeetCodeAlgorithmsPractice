import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {

    public static int numJewelsInStones(String J, String S) {
        int count = 0;
        int JLength = J.length();
        String temp = S;
        int index;
        char c;
        for (int i = 0; i < JLength; i++) {
            c = J.charAt(i);
            index = temp.indexOf(c);
            while (index >= 0) {
                count++;
                temp = temp.substring(index + 1);
                index = temp.indexOf(c);
            }
        }
        return count;
    }

    public static int numJewelsInStones2(String J, String S) {
        int count = 0;
        int JLength = J.length();
        int SLength = S.length();
        for (int i = 0; i < JLength; i++) {
            for (int i1 = 0; i1 < SLength; i1++) {
                if (J.charAt(i) == S.charAt(i1)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int numJewelsInStones3(String J, String S) {
        int count = 0;
        Set set = new HashSet();
        for(char c : J.toCharArray()) {
            set.add(c);
        }
        for(char c : S.toCharArray()) {
            if (set.contains(c)) {
                count++;
            }
        }
        return count;
    }
}

