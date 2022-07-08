package reseach1;

import lombok.*;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public final class ExternalBook {

    private String bookName;

    private String bookAuthor;

    private Object[] customData;

    private byte[] id;

    private static int newId=1;


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
//                if (coll1.equals(coll2))
                if (coll1.equals(coll2)) {
                    newList.add(coll1);
                    break;
                }
            }
        }

        return newList;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof ExternalBook))
            return false;

        ExternalBook book = (ExternalBook) obj;

        boolean conditional = book.getBookName().equals(this.getBookName())
                && book.getBookAuthor().equals(this.getBookAuthor())
                && Arrays.equals(book.getId(), this.getId())
                && Arrays.equals(book.getCustomData(), this.getCustomData());


        return conditional;
    }


//        collOne.retainAll(collTwo);
//        List<ExternalBook> list1 = (List<ExternalBook>) collOne;
//        List<ExternalBook> list2 = (List<ExternalBook>) collTwo;
////
////        list1.retainAll(list2);
//
//        System.out.println("similar " + list1);
//
//
//
//        return (List<ExternalBook>) collOne;
//
//        Collection<?> popo;
//        popo.stream().allMatch( e-> collOne.equals(ExternalBook))


//        Set<ExternalBook> items = new HashSet<>();

//        Stream.of(collOne,collTwo).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
//                .entrySet().stream().filter(m -> m.getKey() >1).map(Map.Entry::getKey).collect(Collectors.toSet());

//        items.stream().collect(Collectors.groupingBy(Function.identity()))

//    }


    public static <T> Collection<T> removeDuplicates(Collection<T> collection) {
        return null;
    }



    public static void main(String[] args) {

        ExternalBook b1 = new ExternalBook( "Pepito Magics",
                "lois Province");

        ExternalBook b2 = new ExternalBook( "Marcel Magics",
                "lois Province");

        ExternalBook b3 = new ExternalBook( "Marcel Magics",
                "lois Province");
        ExternalBook b4 = new ExternalBook( "Pepito Magics",
                "lois Province");

//        ExternalBook b2 = new ExternalBook( "Ppepeito Magis",
//                "lois Province");
//
//        ExternalBook b3 = new ExternalBook( "Ppepeito Magis",
//                "lois Province");
//
//
//        ExternalBook b4 = new ExternalBook( "Ppepeito Magis",
//                "lois Province");


        Collection<ExternalBook> list = List.of(b1, b2);
        Collection<ExternalBook> list2 = List.of(b3, b4);


        Collection<ExternalBook> finalList = findDuplicates(list,list2);

        System.out.println(finalList.toString());

    }
}
