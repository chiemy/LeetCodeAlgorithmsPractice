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
}
