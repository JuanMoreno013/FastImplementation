package research2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.*;

class ByteArrayTest {
    private static final byte[] byteArrTest = {1, 0, 2};
    private static final byte[] byteArrTest2 = {11, 0, 9};
    private static final byte[] arrayByte1 = {1, 0, 1};
    private static final byte[] arrayByte2 = {0, 1};
    private static final byte[] arrayByte3 = {1, 0, 1};
    private static final byte[] arrayByte4 = {0, 1, 1};

    @Test
    @DisplayName("Compare Elements, shows the current time of execution, when you implement this method with 3 elements")
    void compareElements() {

        long startTime = System.currentTimeMillis();
        System.out.println("Initial time: " + startTime);

        ByteArray.compareElements(arrayByte3, arrayByte4);

        long finalTime = System.currentTimeMillis();
        System.out.println("Final time: " + finalTime);
        System.out.println("Time passed: " + (finalTime - startTime) / 1000d + "s");

    }

    @Test
    @DisplayName("Equals, shows the current time of execution, when you implement this method with 3 elements")
    void equalsTest() {

        long startTime = System.currentTimeMillis();
        System.out.println("Initial time: " + startTime);

        ByteArray.equals(byteArrTest, byteArrTest2);

        long finalTime = System.currentTimeMillis();
        System.out.println("Final time: " + finalTime);
        System.out.println("Time passed: " + (finalTime - startTime) / 1000d + "s");

    }

    @Test
    @DisplayName("Compare Elements, shows the current time of execution, when you implement this method with 100 000 000 elements")
    void compareElementsTest() {

        byte[] bigByte = new byte[100000000];
        ThreadLocalRandom.current().nextBytes(bigByte);

        byte[] bigByte2 = new byte[100000000];
        ThreadLocalRandom.current().nextBytes(bigByte2);


        long startTime = System.currentTimeMillis();
        System.out.println("Initial time: " + startTime);

        ByteArray.compareElements(bigByte, bigByte2);

        long finalTime = System.currentTimeMillis();
        System.out.println("Final time: " + finalTime);
        System.out.println("Time passed: " + (finalTime - startTime) / 1000d + "s");

    }

    @Test
    @DisplayName("Equals, shows the current time of execution, when you implement this method with 100 000 000 elements")
    void equalsTest2() {

        byte[] bigByte = new byte[100_000_000];
        new Random().nextBytes(bigByte);

        byte[] bigByte2 = new byte[100_000_000];

        long startTime = System.currentTimeMillis();
        System.out.println("Initial time: " + startTime);

        ByteArray.equals(bigByte, bigByte2);

        long finalTime = System.currentTimeMillis();
        System.out.println("Final time: " + finalTime);
        System.out.println("Time passed: " + (finalTime - startTime) / 1000d + "s");

    }


    @Test
    @DisplayName("Array Byte, show a result true, when the arrays are equals")
    void ArrayByteTest() {
        byte[] arrayOne = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        byte[] arrayTwo = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};


        boolean compareEquals = ByteArray.equals(arrayOne, arrayTwo);
        boolean compareArr = ByteArray.compareElements(arrayByte1, arrayByte3);

        assertTrue(compareArr);
        assertTrue(compareEquals);

    }

    @Test
    @DisplayName(" Array byte[] , show a result false, when the arrays it is not the same length ")
    void TryEquals() {

        boolean compareArr = ByteArray.compareElements(arrayByte1, arrayByte2);

        assertFalse(compareArr);
    }


}