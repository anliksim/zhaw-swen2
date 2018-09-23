package zhaw.swen2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * This class Generates prime numbers up to a user specified maximum.
 * the algorithm used is the Sieve of Eratosthenes.
 * <p>
 * Eratosthenes of Cyrene, b. c. 276 BC, Cyrene, Libya
 * --
 * d. c. 194, Alexandria.  The first man to calculate the circumferen
 * ce
 * of the Earth.  Also known for working on calendars with leap
 * years and ran the library at Alexandria.
 * <p>
 * The algorithm is quite simple.  Given an array of integers starting
 * at 2.  Cross out all multiples of 2.  Find the next uncrossed
 * <p>
 * integer, and cross out all of its multiples.  Repeat until
 * you have passed the square root of the maximum value.
 *
 * @author Simon Anliker
 * @version 1.0
 */
public class SieveOfEratosthenes {

    private static final int FIRST_PRIME = 2;

    public static int[] generatePrimes(int maxValue) {

        Boolean[] primes = initPotentialPrimes(maxValue);

        for (int i = 2; i <= Math.sqrt(maxValue); i++) {
            if (primes[i]) {

                for (int j = i * 2; j < maxValue; j += i) {
                    primes[j] = false;
                }
            }
        }
        return IntStream.range(FIRST_PRIME, primes.length)
                .filter(i -> primes[i])
                .map(IntUnaryOperator.identity())
                .toArray();
    }

    private static Boolean[] initPotentialPrimes(int maxValue) {
        return IntStream.rangeClosed(FIRST_PRIME, maxValue)
                .mapToObj(v -> Boolean.TRUE)
                .collect(Collectors.toList())
                .toArray(new Boolean[maxValue]);
    }
}
