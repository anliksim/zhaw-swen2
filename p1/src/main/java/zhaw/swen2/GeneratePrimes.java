package zhaw.swen2;

final class GeneratePrimes {

    public static int[] generatePrimes(int maxValue) {

        int count = 0;
        int[] container = new int[maxValue];

        for (int i = 2; i <= maxValue; i++) {
            if (isPrime(i)) {
                container[count++] = i;
            }
        }

        int[] primes = new int[count];
        System.arraycopy(container, 0, primes, 0, count);
        return primes;
    }

    private static boolean isPrime(int value) {

        for (int i = 2; i < value; i++) {

            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }
}
