public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        char[] tArr = t.toCharArray();
        char difference = ' ';
        for (int i = 0; i < tArr.length; i++) {
            if (s.indexOf(tArr[i]) == -1) {
                difference = tArr[i];
                break;
            }
        }
        return difference;
    }

    public char findTheDifference2(String s, String t) {
        char c = 0;
        for (int i = 0; i < s.length(); ++i) {
            c ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); ++i) {
            c ^= t.charAt(i);
        }
        return c;
    }
}
