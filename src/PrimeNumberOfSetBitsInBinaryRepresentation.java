
public class PrimeNumberOfSetBitsInBinaryRepresentation {
    public int countPrimeSetBits(int L, int R) {
        int count = 0;
        for (int i = L; i < R + 1; i++) {
            if (isPrime(Integer.bitCount(i))) {
                count++;
            }
        }
        return count;
    }

    private boolean isPrime(int number) {
        return (number == 2 || number == 3 || number == 5 || number == 7)
                || (number % 2 != 0 && number % 3 != 0 && number % 5 != 0 && number % 7 != 0);
    }
}
