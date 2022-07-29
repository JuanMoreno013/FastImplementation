package reseach1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

class ExternalBookTest {

    static ExternalBook b1 = new ExternalBook("Pepito Magics",
            "lois Province");

    static ExternalBook b2 = new ExternalBook("Pepito Magics",
            "lois Province");

    static ExternalBook b3 = new ExternalBook("Pepito isd",
            "lois menus");

    static ExternalBook b4 = new ExternalBook("Pepito ",
            "lois Province");

    static ExternalBook b11 = new ExternalBook("Pepito Magics",
            "lois Province", 1);

    static ExternalBook b12 = new ExternalBook("Pepito Magics",
            "lois Province", 1);
    static ExternalBook b13 = new ExternalBook("Marcel Magics",
            "lois Province", 2);

    static ExternalBook b14 = new ExternalBook("Marcel Magics",
            "lois Province", 2);

    static ExternalBook b15 = new ExternalBook("Pepito Magics",
            "lois Province", 1);

    static ExternalBook b16 = new ExternalBook(" Magics",
            "lois Province", 2);

    static ExternalBook b21 = new ExternalBook(" Magics",
            "lois Province", 2, new Object[1234]);

    static ExternalBook b22 = new ExternalBook(" Roll Bag",
            "lois Province", 2, new Object[1234]);

    @Test
    @DisplayName("Remove Duplicate, shows the current time of execution, when you implement this method")
    void removeDuplicateTest() {

        List<ExternalBook> listRemove = List.of(b1, b2, b3, b4, b11, b12, b13, b3, b14, b15, b2, b2, b1, b16);

        long startTime = System.currentTimeMillis();
        System.out.println("Initial time: " + startTime / 1000d + "s");

        Collection<ExternalBook> books = ExternalBook.removeDuplicates(listRemove);

        long finalTime = System.currentTimeMillis();
        System.out.println("Final time: " + finalTime / 1000d + "s");

        System.out.println("Time passed: " + (finalTime - startTime) / 1000d + "s");
        System.out.println("Duplicated books removed: " + books.size());

    }


    @Test
    @DisplayName("Find Duplicate, shows the current time of execution, when you implement this method")
    void findDuplicatesTest() {

        long startTime = System.currentTimeMillis();
        System.out.println("Initial time: " + startTime);

        List<ExternalBook> collOne = List.of(b1, b2, b3, b4, b11, b12, b13, b3, b14, b15, b2, b2, b1, b16, b11, b12, b13, b3, b14, b22);
        List<ExternalBook> collTwo = List.of(b1, b2, b3, b11, b12, b13, b4, b21, b12, b13, b3, b14, b15, b2, b2, b22, b16, b3, b14, b21);

        Collection<ExternalBook> books = ExternalBook.findDuplicates(collOne, collTwo);

        long finalTime = System.currentTimeMillis();
        System.out.println("Final time: " + finalTime);

        System.out.println("Time passed: " + (finalTime - startTime) / 1000d + "s");
        System.out.println("Duplicated books found: " + books.size());

    }

    private List<BookDecorator> transformExternalBooks(final List<ExternalBook> externalBookList) {

        List<BookDecorator> decoratorBookList = new ArrayList<>();

        for (ExternalBook externalBook : externalBookList) {
            BookDecorator newBookDecorator = new BookDecorator(externalBook);
            decoratorBookList.add(newBookDecorator);
        }
        return decoratorBookList;
    }

    @Test
    @DisplayName("Remove Duplicate Decorator, shows the current time of execution, when you implement this method")
    void removeDuplicateTest2() {

        List<ExternalBook> listRemove = List.of(b1, b2, b3, b4, b11, b12, b13, b3, b14, b15, b2, b2, b1, b16);
        Collection<BookDecorator> newList = transformExternalBooks(listRemove);


        long startTime = System.currentTimeMillis();
        System.out.println("Initial time: " + startTime / 1000d + "s");

        Collection<BookDecorator> books = BookDecorator.removeDuplicates(newList);

        long finalTime = System.currentTimeMillis();
        System.out.println("Final time: " + finalTime / 1000d + "s");

        System.out.println("Time passed: " + (finalTime - startTime) / 1000d + "s");
        System.out.println("Duplicated books removed: " + books.size());

    }

    @Test
    @DisplayName("Book 2, the size of the new list are 0, when there is not books duplicates")
    void Book2() {
        List<ExternalBook> list = List.of(b1, b2);
        List<ExternalBook> list2 = List.of(b3, b4);

        assertEquals(0, ExternalBook.findDuplicates(list, list2).size());
    }

    @Test
    @DisplayName("Book 3, the size of the new list are 1, when there is books duplicates")
    void Book3() {
        List<ExternalBook> list = List.of(b1, b2, b11);
        List<ExternalBook> list2 = List.of(b3, b4, b12);

        assertEquals(1, ExternalBook.findDuplicates(list, list2).size());
    }


    @Test
    @DisplayName("Book 4, show the time to execution to find duplicates, when the both list of 10 000 000 elements ")
    void Book4() {


        List<ExternalBook> list = new ArrayList<>();
        List<ExternalBook> list2 = new ArrayList<>();

        long startTime = System.currentTimeMillis();

        for (int x = 0; x < 10000000; x++) {
            list.add(b1);
            list.add(b2);
            list.add(b11);

            list2.add(b3);
            list2.add(b4);
            list.add(b12);
        }

        ExternalBook.findDuplicates(list, list2);

        long timeAfter = System.currentTimeMillis();
        long estimatedTime = timeAfter - startTime;
        System.out.println("Time estimated with a list 10 million elements " + estimatedTime);

    }


    @Test
    @DisplayName("Book 5, show the time to execution to find duplicates, when the both list of 1000 elements ")
    void Book5() {
        List<ExternalBook> list = new ArrayList<>();
        List<ExternalBook> list2 = new ArrayList<>();

        long startTime = System.currentTimeMillis();

        for (int x = 0; x < 1000; x++) {
            list.add(b1);
            list.add(b2);
            list.add(b11);

            list2.add(b3);
            list2.add(b4);
            list.add(b12);

        }
        ExternalBook.findDuplicates(list, list2);

        long timeAfter = System.currentTimeMillis();
        long estimatedTime = timeAfter - startTime;
        System.out.println("Time estimated with a list of 1000 elements: " + estimatedTime);

    }

    @Test
    @DisplayName("Book 6, show the time from remove the duplicates, when the collection of 10 000 elements ")
    void Book6() {
        List<ExternalBook> list = new ArrayList<>();


        long startTime = System.currentTimeMillis();

        for (int x = 0; x < 10000; x++) {
            list.add(b1);
            list.add(b2);
            list.add(b11);
            list.add(b3);
            list.add(b4);
            list.add(b16);
            list.add(b13);
            list.add(b14);
            list.add(b16);
        }

        ExternalBook.removeDuplicates(list);
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("Time estimated with a list of 10 000 elements: " + estimatedTime);


    }

    @Test
    @DisplayName("Book 7, the size of the new list are 6, when remove duplicates elements")
    void Book7() {

        List<ExternalBook> listRemove = List.of(b1, b2, b3, b4, b11, b12, b13, b3, b14, b15, b2, b2, b1, b16);
        List<ExternalBook> newList = (List<ExternalBook>) ExternalBook.removeDuplicates(listRemove);

        assertEquals(6, newList.size());
    }


    @Test
    @DisplayName("Book using BookDecorator, the size of the new list are 0, when there is not books duplicates")
    void BookDecorator() {

        BookDecorator newBook2 = new BookDecorator(b15);
        BookDecorator newBook3 = new BookDecorator(b14);


        List<ExternalBook> list = List.of(b14, b15);
        List<ExternalBook> list2 = List.of(b21, b22);

        assertEquals(0, ExternalBook.findDuplicates(list, list2).size());
    }

    @Test
    @DisplayName("Remove Books Decorator duplicates, the size of the new list are 3, when remove books duplicates")
    void BookDecorator2() {

        ExternalBook book2Dec = new ExternalBook("Bag",
                "Province", 1, new Object[12]);

        ExternalBook book3Dec = new ExternalBook("Roll Bag",
                "lois Province", 2, new Object[1]);

        ExternalBook book4Dec = new ExternalBook("Roll Bag",
                "lois Province", 2, new Object[1]);

        ExternalBook book5Dec = new ExternalBook("ROLL",
                "lois", 3, new Object[1]);

        ExternalBook book6Dec = new ExternalBook("Roll Bag",
                "lois Province", 2, new Object[1]);


        BookDecorator newBook1 = new BookDecorator(book2Dec);
        BookDecorator newBook2 = new BookDecorator(book3Dec);
        BookDecorator newBook3 = new BookDecorator(book4Dec);
        BookDecorator newBook4 = new BookDecorator(book5Dec);
        BookDecorator newBook5 = new BookDecorator(book6Dec);

        List<BookDecorator> decoratorList = List.of(newBook1, newBook2, newBook4, newBook3, newBook5);
        List<BookDecorator> newDecoratorList = (List<BookDecorator>) BookDecorator.removeDuplicates(decoratorList);

        assertEquals(3, newDecoratorList.size());
    }
}