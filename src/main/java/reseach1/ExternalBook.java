package reseach1;

import lombok.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public final class ExternalBook {

    private String bookName;

    private String bookAuthor;

    private Object[] customData;

    private byte[] id;

    private static int newId=1;

    @Override
    public String toString() {
        return "\n" +
                "Book name: '" + bookName + '\n' +
                "Author='" + bookAuthor + '\n' +
                "Data=" + Arrays.toString(customData) + '\n' +
                "id=" + Arrays.toString(id) + '\n' ;
    }

    public ExternalBook(String bookName, String bookAuthor ) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.id = new byte[newId];
        newId++;

//        this.customData = customData;
    }

    public ExternalBook(String bookName, String bookAuthor, int id ) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.id = new byte[id];

//        this.customData = customData;
    }

    public static List<ExternalBook> findDuplicates(Collection<ExternalBook> collOne, Collection<ExternalBook> collTwo) {
    List<ExternalBook> newList = new ArrayList<>();
        if (collOne.size() != collTwo.size()) {
            return List.of();
        }

        for (ExternalBook coll1 : collOne){
            for (ExternalBook coll2: collTwo ){
                if (coll1.equals(coll2)) {
                    newList.add(coll1);
                    break;
                }
            }
        }

        return newList;
    }

    public static <T> Collection<T> removeDuplicates(Collection<T> collection) {

//        Collection<ExternalBook> listWithDuplicates = (List<ExternalBook>) collection;
//
//        Collection<ExternalBook> listWithoutDuplicates= new ArrayList<>(
//                new HashSet<>(listWithDuplicates.stream().distinct().collect(Collectors.toList())));
//
//
//
//        return (Collection<T>) listWithoutDuplicates;
//


//        listWithDuplicates.stream().filter(e-> listWithDuplicates.stream().filter(o -> e.equals(collection))).



//         newList.retainAll(collection);

//         return newList;

//        return collection.stream()
//                .distinct()
//                .collect(Collectors.toList());

//        return new HashSet<>(collection);

//
//        return collection.stream().collect(Collectors.toSet()).stream()
//                .distinct()
//                .collect(Collectors.toList());

//        Collection<ExternalBook> listWithDuplicates = (List<ExternalBook>) collection;
//
//        List<ExternalBook> listRemove = collection.stream().filter(distinctBy(book -> Arrays.asList()))
//        return

        return collection.stream()
                .distinct()
                .collect(Collectors.toList());

    }

    private static <T> Predicate<T> distinctBy(Function<? super T, ?> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
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
        return Objects.hash(bookAuthor,bookName, Arrays.hashCode(id));
    }

    public static void main(String[] args) {

        ExternalBook b1 = new ExternalBook( "Pepito Magics",
                "lois Province",1);

        ExternalBook b2 = new ExternalBook( "Marcel Magics",
                "lois Province",2);

        ExternalBook b3 = new ExternalBook( "Marcel Magics",
                "lois Province",2);

        ExternalBook b4 = new ExternalBook( "Pepito Magics",
                "lois Province",1);

        ExternalBook b5 = new ExternalBook( " Magics",
                "lois Province",2);

        ExternalBook b6 = new ExternalBook( "Marcel Magics",
                "lois Province",2);

        ExternalBook b7 = new ExternalBook( "Lois Magics",
                "lois Province",2);


        Collection<ExternalBook> list = List.of(b1, b2, b5,b6);
        Collection<ExternalBook> list2 = List.of(b3, b4,b7,b6);


        Collection<ExternalBook> newListRemove = List.of(b1, b2, b5,b6, b5, b6,b1,b3,b6,b4,b7,b1,b4);

        Collection<ExternalBook> some = removeDuplicates(newListRemove);
        System.out.println(removeDuplicates(newListRemove));
        System.out.println(removeDuplicates(newListRemove).size());

        Collection<ExternalBook> c = removeDuplicates(List.of(b2, b3));
        boolean f = b2.equals(b3);

        Collection<ExternalBook> finalList = findDuplicates(list,list2);

        System.out.println(finalList.toString());

    }
}
