package zhaw.swen2;

import org.junit.Test;

import java.util.Arrays;
import java.util.BitSet;

import static org.junit.Assert.*;

public class GeneratePrimesTest {

    @Test
    public void generatePrimes() {

        int[] primeNrBelow100 = new int[]{
                2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};

        assertArrayEquals(primeNrBelow100, GeneratePrimes.generatePrimes(100));
    }
}