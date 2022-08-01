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

    public static boolean compareElements(final byte[] data, final byte[] data2) {
        if (data2.length != data.length)
            return false;

        List<byte[]> hasList = List.of(data2);

        return hasList.stream().allMatch(i -> Arrays.equals(data, data2));
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
