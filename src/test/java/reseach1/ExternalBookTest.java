package reseach1;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;



import static org.junit.jupiter.api.Assertions.*;

class ExternalBookTest {

    ExternalBook externalBook = new ExternalBook();

    ExternalBook b1 = new ExternalBook( "Pepito Magics",
            "lois Province");

    ExternalBook b2 = new ExternalBook( "Pepito Magics",
            "lois Province");

    ExternalBook b3 = new ExternalBook( "Pepito oisd",
            "lois menis");

    ExternalBook b4 = new ExternalBook( "Pepito Magics",
            "lois Province");

    ExternalBook b11 = new ExternalBook( "Pepito Magics",
            "lois Province",1);

    ExternalBook b12 = new ExternalBook( "Pepito Magics",
            "lois Province",1);

    ExternalBook b13 = new ExternalBook( "Marcel Magics",
            "lois Province",2);

    ExternalBook b14 = new ExternalBook( "Marcel Magics",
            "lois Province",2);

    ExternalBook b15 = new ExternalBook( "Pepito Magics",
            "lois Province",1);

    ExternalBook b16 = new ExternalBook( " Magics",
            "lois Province",2);

    @Test
    @DisplayName("Book 2, the size of the new list are 0, when there is not books duplicates")
    void Book2(){
        List<ExternalBook> list = List.of(b1, b2);
        List<ExternalBook> list2 = List.of(b3, b4);

        assertEquals(0, ExternalBook.findDuplicates(list,list2).size());
    }

    @Test
    @DisplayName("Book 3, the size of the new list are 1, when there is books duplicates")

    void Book3(){
        List<ExternalBook> list = List.of(b1, b2,b11);
        List<ExternalBook> list2 = List.of(b3, b4, b12);

        assertEquals(2, ExternalBook.findDuplicates(list,list2).size());
    }

    @Test
    @DisplayName("Book 4, show the time to execution to find duplicates, when the both list has 10 000 000 elements ")
    void Book4()  {


        List<ExternalBook> list = new ArrayList<>();
        List<ExternalBook> list2 = new ArrayList<>();

        long startTime = System.currentTimeMillis();

        for (int x=0; x<10000000; x++)
        {
            list.add(b1);
            list.add(b2);
            list.add(b11);

            list2.add(b3);
            list2.add(b4);
            list.add(b12);

        }
        ExternalBook.findDuplicates(list,list2);

        long estimatedTime = System.currentTimeMillis()-startTime;
        System.out.println(estimatedTime);

    }


    @Test
    @DisplayName("Book 5, show the time to execution to find duplicates, when the both list has 1000 elements ")
    void Book5() {
        List<ExternalBook> list = new ArrayList<>();
        List<ExternalBook> list2 = new ArrayList<>();

        long startTime = System.currentTimeMillis();

        for (int x=0; x<1000; x++)
        {
            list.add(b1);
            list.add(b2);
            list.add(b11);

            list2.add(b3);
            list2.add(b4);
            list.add(b12);

        }
        ExternalBook.findDuplicates(list,list2);

        long estimatedTime = System.currentTimeMillis()-startTime;
        System.out.println(estimatedTime);

    }

    @Test
    @DisplayName("Book 6, show the time from remove the duplicates, when the collection has 10 000 elements ")
    void Book6() {
        List<ExternalBook> list = new ArrayList<>();


        long startTime = System.currentTimeMillis();

        for (int x=0; x<10000; x++)
        {
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
        long estimatedTime = System.currentTimeMillis()-startTime;
        System.out.println(estimatedTime);

    }

    @Test
    @DisplayName("Book 7, the size of the new list are 6, when remove duplicates elements")
    void Book7() {

        List<ExternalBook> list = List.of(b1,b2,b3,b4,b11,b12,b13,b3,b14,b15,b2,b2,b1,b16);
       List<ExternalBook> newList = (List<ExternalBook>) ExternalBook.removeDuplicates(list);

        assertEquals(6, newList.size());
    }
}