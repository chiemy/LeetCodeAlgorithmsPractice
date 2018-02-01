public class ReverseString {
    public String reverseString(String s) {
        char[] charArr = s.toCharArray();
        int start = 0;
        int end = charArr.length - 1;
        for (;start < end; start++, end--) {
            char temp = charArr[start];
            charArr[start] = charArr[end];
            charArr[end] = temp;
        }
        return new String(charArr);
    }
}
