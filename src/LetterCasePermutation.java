import java.util.ArrayList;
import java.util.List;

/**
 * Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.

 Examples:
 Input: S = "a1b2"
 Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
 */
public class LetterCasePermutation {

    public List<String> letterCasePermutation(String S) {
        return solution2(S);
    }

    public List<String> solution1(String S) {
        List<String> list = new ArrayList<>();
        char[] charArr = S.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            char c = charArr[i];
            boolean isLetter = false;
            if (c >= 'A' && c <= 'Z') {
                isLetter = true;
                charArr[i] += 32;
                list.add(String.valueOf(charArr));
            }
            if (c >= 'a' && c <= 'z') {
                isLetter = true;
                charArr[i] -= 32;
                list.add(String.valueOf(charArr));
            }

            if (isLetter) {
                charArr[i] = c;
                list.add(String.valueOf(charArr));
            }
        }
        return list;
    }

    public List<String> solution2(String S) {
        List<String> list = new ArrayList<>();
        char[] charArr = S.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            char c = charArr[i];
            if (Character.isDigit(c)) {
                continue;
            }
            charArr[i] = Character.toLowerCase(c);
            list.add(String.valueOf(charArr));
            charArr[i] = Character.toUpperCase(c);
            list.add(String.valueOf(charArr));
        }
        return list;
    }
}
