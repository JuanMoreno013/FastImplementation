package reseach1;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class BookDecorator implements Library {

    private final ExternalBook externalBook;

    public BookDecorator(ExternalBook externalBook){
        this.externalBook = externalBook;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof BookDecorator))
            return false;

        BookDecorator book = (BookDecorator) obj;

        return Objects.equals(book.externalBook.getBookName(),externalBook.getBookName()) &&
                Objects.equals(book.externalBook.getBookAuthor(), externalBook.getBookAuthor())
                && Arrays.equals(book.externalBook.getId(), externalBook.getId());
    }
    @Override
    public int hashCode() {
        return Objects.hash(externalBook.getBookAuthor(), externalBook.getBookName(), Arrays.hashCode(externalBook.getId()));
    }

    public static List<ExternalBook> findDuplicates(Collection<ExternalBook> collOne, Collection<ExternalBook> collTwo) {
         return ExternalBook.findDuplicates(collOne, collTwo);
    }

    public static <T> Collection<T> removeDuplicates(Collection<T> collection) {
        return ExternalBook.removeDuplicates(collection);
    }
}
