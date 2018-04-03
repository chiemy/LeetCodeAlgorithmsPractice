import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        if (S == null) {
            return new LinkedList<>();
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(S);

        for (int i = 0; i < S.length(); i++) {
            if (Character.isDigit(S.charAt(i))) continue;
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String cur = queue.poll();
                char[] chs = cur.toCharArray();

                chs[i] = Character.toUpperCase(chs[i]);
                queue.offer(String.valueOf(chs));

                chs[i] = Character.toLowerCase(chs[i]);
                queue.offer(String.valueOf(chs));
            }
        }

        return new LinkedList<>(queue);

    }
}
