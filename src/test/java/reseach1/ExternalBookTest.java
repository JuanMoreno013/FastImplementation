package reseach1;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;


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

    @Test
    @DisplayName("Book 1, time implement time")
    @Timeout(10000000)
    void Book() throws InterruptedException {

        List<ExternalBook> list = List.of(b1, b2);
        List<ExternalBook> list2 = List.of(b2, b4);

         ExternalBook.findDuplicates(list, list2);
        TimeUnit.NANOSECONDS.sleep(10000);


//        assert Timeout(Duration.of(1), ()-> ExternalBook.findDuplicates(list,list2));
    }

    @Test
    @DisplayName("Book 2, the size of the new list are 0, when there is not books duplicates")
    void Book2(){
        List<ExternalBook> list = List.of(b1, b2);
        List<ExternalBook> list2 = List.of(b3, b4);

        assertEquals(0, ExternalBook.findDuplicates(list,list2).size());
    }

    @Test
    @DisplayName("Book 3, the size of the new list are 2, when there is books duplicates")

    void Book3(){
        List<ExternalBook> list = List.of(b1, b2,b11);
        List<ExternalBook> list2 = List.of(b3, b4, b12);

        assertEquals(2, ExternalBook.findDuplicates(list,list2).size());
    }

    @Test
    @DisplayName("Book 4, time measures")
    void Book4() throws InterruptedException {
        List<ExternalBook> list = List.of(b1, b2,b11);
        List<ExternalBook> list2 = List.of(b3, b4, b12);

        Thread.sleep(10000);
        ExternalBook.findDuplicates(list,list2);



//        long startTime = System.currentTimeMillis();
//        ExternalBook.findDuplicates(list,list2);
//
//        long estimatedTime = System.currentTimeMillis()-startTime;
//        assertTrue(estimatedTime<1);

    }




}