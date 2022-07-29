package reseach1;

import lombok.*;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public final class ExternalBook {

    private String bookName;
    private String bookAuthor;
    private Object[] customData;
    private byte[] id;
    private static int newId = 1;

    @Override
    public String toString() {
        return "\n" +
                "Book name: '" + bookName + '\n' +
                "Author='" + bookAuthor + '\n' +
                "Data=" + Arrays.toString(customData) + '\n' +
                "id=" + Arrays.toString(id) + '\n';
    }

    public ExternalBook(String bookName, String bookAuthor) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.id = new byte[newId];
        newId++;
    }

    public ExternalBook(String bookName, String bookAuthor, int id) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.id = new byte[id];
    }

    public ExternalBook(String bookName, String bookAuthor, int id, Object[] customData) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.id = new byte[id];
        this.customData = customData;
    }
    public static List<ExternalBook> findDuplicates(Collection<ExternalBook> collOne, Collection<ExternalBook> collTwo) {

        Set<ExternalBook> items = new HashSet<>(collOne);
        items.retainAll(collTwo);

        return new ArrayList<>(items);

    }

    public static <T> Collection<T> removeDuplicates(Collection<T> collection) {
        return collection.stream()
                .distinct()
                .collect(Collectors.toList());

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof ExternalBook))
            return false;

        ExternalBook book = (ExternalBook) obj;

        return Objects.equals(book.getBookName(), this.bookName) &&
                Objects.equals(book.getBookAuthor(), this.bookAuthor)
                && Arrays.equals(book.getId(), this.id) &&
                Arrays.equals(book.getCustomData(), this.customData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookAuthor, bookName, Arrays.hashCode(id), Arrays.hashCode(customData));
    }

}
