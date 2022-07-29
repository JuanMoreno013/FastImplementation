package research2;

import lombok.Getter;

import java.util.*;

@Getter
public class ByteArray {

    private final byte[] data;
    private final byte[] data2;

    public ByteArray(byte[] data, byte[] data2) {
        this.data = data;
        this.data2 = data2;
    }

    public static <T> boolean compareElements(T[] data, T[] data2) {
        if (data2.length != data.length)
            return false;

        List<T> byteSet = List.of(data2);
//        Set<T> byteSet = new HashSet<>(Arrays.asList(data2));

        for (T byteCompare : data) {
            if (byteSet.equals(byteCompare)) {
                return true;
            }
        }
        return false;
    }


    public static boolean equals(byte[] data1, byte[] data2) {
        if (data1 == data2)
            return true;

        if (data1 == null || data2 == null)
            return false;

        int length = data1.length;
        if (data2.length != length)
            return false;

        for (int i = 0; i < length; i++)
            if (data1[i] != data2[i])
                return false;

        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        ByteArray byteArray = (ByteArray) o;
        return Arrays.equals(data, byteArray.data) && Arrays.equals(data2, byteArray.data2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(data), Arrays.hashCode(data2));
    }
}
