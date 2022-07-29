package research2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reseach1.ExternalBook;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ByteArrayTest {

    Byte[] indicator = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    Byte[] indicator23 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 23, 48, 16};
    Byte[] current = new Byte[10];
    byte[] indicator2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 12, 11, 10};

    private static final byte[] byteArrTest = {1, 0, 2};
    private static final byte[] byteArrTest2 = {11, 0, 9};
    private static final Byte[] arrayByte1 = {1, 0, 1};
    private static final Byte[] arrayByte2 = {0, 1};
    private static final Byte[] arrayByte3 = {1, 0, 1};
    private static final Byte[] arrayByte4 = {0, 1, 1};

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
    @DisplayName("Array Byte, show a result true, when the arrays are equals")
    void ArrayByteTest() {
        byte[] arrayOne = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        byte[] arrayTwo = {1, 2, 3, 4, 5, 6, 7, 8, 9};


//        boolean compareEquals=  ByteArray.equals(arrayOne, arrayTwo);
        boolean compareArr = ByteArray.compareElements(arrayByte1, arrayByte3);

        assertTrue(compareArr);
//        assertTrue(compareEquals);

    }

    @Test
    @DisplayName(" Array byte[] , show a result false, when the arrays it is not the same length ")
    void TryEquals() {

        boolean compareArr = ByteArray.compareElements(arrayByte1, arrayByte2);

        assertFalse(compareArr);
    }


}