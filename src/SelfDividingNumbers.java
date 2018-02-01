import java.util.ArrayList;
import java.util.List;

/**
 * A self-dividing number is a number that is divisible by every digit it contains.
 * For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
 * Also, a self-dividing number is not allowed to contain the digit zero.
 * Given a lower and upper number bound, output a list of every possible self dividing number,
 * including the bounds if possible.
 */
public class SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        return solution3(left, right);
    }

    public List<Integer> solution1(int left, int right) {
        List<Integer> results = new ArrayList<>();
        for (int i = left; i < right + 1; i++) {
            if (isSelfDividingNumber1(i)) {
                results.add(i);
            }
        }
        return results;
    }

    public List<Integer> solution2(int left, int right) {
        List<Integer> results = new ArrayList<>();
        for (int i = left; i < right + 1; i++) {
            if (isSelfDividingNumber2(i)) {
                results.add(i);
            }
        }
        return results;
    }

    public List<Integer> solution3(int left, int right) {
        List<Integer> results = new ArrayList<>();
        for (int i = left; i < right + 1; i++) {
            if (isSelfDividingNumber3(i)) {
                results.add(i);
            }
        }
        return results;
    }

    private boolean isSelfDividingNumber1(int number) {
        boolean selfDividingNumber = false;
        int n = number % 10;
        if (n != 0 && number % n == 0) {
            selfDividingNumber = true;
            int count = String.valueOf(number).length();
            for (int j = 1; j < count; j++) {
                n = number / (int) Math.pow(10, j) % 10;
                if (n == 0 || number % n != 0) {
                    selfDividingNumber = false;
                    break;
                }
            }
        }
        return selfDividingNumber;
    }

    private boolean isSelfDividingNumber2(int number) {
        boolean is = false;
        int j = number;
        while(j > 0) {
            int mod = j % 10;
            if (mod == 0 || number % mod != 0) {
                is = false;
                break;
            } else {
                is = true;
                j /= 10;
            }
        }
        return is;
    }

    private boolean isSelfDividingNumber3(int number) {
        boolean is = false;
        int j = number;
        for (;j > 0 ; j /= 10) {
            int mod = j % 10;
            is = mod != 0 && number % mod == 0;
            if (!is) {
                break;
            }
        }
        return is;
    }
}
