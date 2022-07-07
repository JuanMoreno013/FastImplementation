package reseach1;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class ExternalBookTest {

    ExternalBook externalBook = new ExternalBook();

    ExternalBook b1 = new ExternalBook( "Ppepeito Magis",
            "lois Province");

    ExternalBook b2 = new ExternalBook( "Ppepeito Magis",
            "lois Province");

    ExternalBook b3 = new ExternalBook( "Ppepeito oisd",
            "lois menis");


    ExternalBook b4 = new ExternalBook( "Ppepeito Magis",
            "lois Province");

    @Test
    @DisplayName("Book 1, time implement time")
    void Book(){

        List<ExternalBook> list = List.of(b1, b2);
        List<ExternalBook> list2 = List.of(b2, b4);

ExternalBook.findDuplicates(list, list2);
    }




}