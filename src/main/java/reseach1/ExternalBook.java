package reseach1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public final class ExternalBook {

    private String bookName;

    private String bookAuthor;

    private Object[] customData;

    private byte[] id;

    private int newId;


    public ExternalBook(String bookName, String bookAuthor ) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.id = new byte[newId];
        newId++;

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

        return book.getBookName().equals(this.getBookName());
    }

    public static boolean isEqualCollection(final Collection<?> a, final Collection<?> b) {
        if(a.size() != b.size()) {
                        return false;
                    }
                final CardinalityHelper<Object> helper = new CardinalityHelper<>(a, b);
                if(helper.cardinalityA.size() != helper.cardinalityB.size()) {
                        return false;
                    }
                for( final Object obj : helper.cardinalityA.keySet()) {
                        if(helper.freqA(obj) != helper.freqB(obj)) {
                                return false;
                            }
                    }
                return true;
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

    private static class CardinalityHelper<O> {
        /** Contains the cardinality for each object in collection A. */
        final  Map<O, Integer> cardinalityA;

        /** Contains the cardinality for each object in collection B. */
        final Map<O, Integer> cardinalityB;

            public CardinalityHelper(final Iterable<? extends O> a, final Iterable<? extends O> b) {
                cardinalityA = getCardinalityMap(a);
                cardinalityB = getCardinalityMap(b);
        }

//        public static <O> Map<O, Integer> getCardinalityMap(final Iterable<? extends O> coll) {
//            final Map<O, Integer> count = new HashMap<>();
//            for (final O obj : coll) {
//                count.merge(obj, 1, Integer::sum);
//            }
//            return count;
//        }


        public final int max(final Object obj) {
                        return Math.max(freqA(obj), freqB(obj));
                    }

                public final int min(final Object obj) {
                        return Math.min(freqA(obj), freqB(obj));
            }

        public int freqA(final Object obj) {
                        return getFreq(obj, cardinalityA);
            }

        public int freqB(final Object obj) {
                        return getFreq(obj, cardinalityB);
                    }

        private int getFreq(final Object obj, final Map<?, Integer> freqMap) {
                        final Integer count = freqMap.get(obj);
            return Objects.requireNonNullElse(count, 0);
        }
    }



    public static <O> Map<O, Integer> getCardinalityMap(final Iterable<? extends O> coll) {
                final Map<O, Integer> count = new HashMap<>();
                for (final O obj : coll) {
                        final Integer c = count.get(obj);
                        if (c == null) {
                                count.put(obj, Integer.valueOf(1));
                            } else {
                                count.put(obj, Integer.valueOf(c.intValue() + 1));
                            }
                    }
                return count;
            }

    public static <T> Collection<T> removeDuplicates(Collection<T> collection) {
        return null;
    }

    public static boolean compareList(Collection<ExternalBook> collOne, Collection<ExternalBook> collTwo)
    {
            return false;
    }

    public static void main(String[] args) {

        ExternalBook b1 = new ExternalBook( "Ppepeito Magis",
                "lois Province");

        ExternalBook b2 = new ExternalBook( "Ppepeito Magi",
                "lois Province");

        ExternalBook b3 = new ExternalBook( "Ppepeito Magis",
                "lois Province");
        ExternalBook b4 = new ExternalBook( "Ppepeito Magis",
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


        System.out.println(findDuplicates(list,list2));

//        System.out.println(isEqualCollection(list, list2));
    }
}
