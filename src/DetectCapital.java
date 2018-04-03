public class DetectCapital {

    public boolean detectCapitalUse(String word) {
        return solution1(word);
    }

    private boolean solution1(String word) {
        if (word.length() < 2) {
            return true;
        }
        if (word.toUpperCase().equals(word)) {
            return true;
        }
        if (word.substring(1).toLowerCase().equals(word.substring(1))) {
            return true;
        }
        return false;
    }
}
