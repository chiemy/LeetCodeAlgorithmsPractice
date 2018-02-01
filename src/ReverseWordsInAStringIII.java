/**
 * Given a string, you need to reverse the order of characters in each word within a sentence
 * while still preserving whitespace and initial word order.
 * <p>
 * Example 1:<br>
 * Input: "Let's take LeetCode contest"<br>
 * Output: "s'teL ekat edoCteeL tsetnoc"<br>
 * </p>
 * <b>Note: </b>In the string, each word is separated by single space and there will not be any extra space in the string.
 */
public class ReverseWordsInAStringIII {
    public String reverseWords(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] arr = s.split(" ");
        for (String word : arr) {
            int length = word.length();
            for (int i = length - 1; i >= 0; i--) {
                stringBuilder.append(word.charAt(i));
            }
            stringBuilder.append(" ");
        }
        stringBuilder.setLength(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }
}
