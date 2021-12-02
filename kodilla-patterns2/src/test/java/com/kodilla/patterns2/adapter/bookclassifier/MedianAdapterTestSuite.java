package com.kodilla.patterns2.adapter.bookclassifier;


import com.kodilla.patterns2.adapter.bookclasifier.MedianAdapter;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedianAdapterTestSuite {

    @Test
    void medianTest () {
        // Given
        MedianAdapter medianAdapter = new MedianAdapter();
        Set<Book> booksA = new HashSet<>();
        Book firstBook = new Book("First", "First Title", 2020, "2020x");
        Book secondBook = new Book("Second", "Second Title", 2018, "2018x");
        Book thirdBook = new Book("Third", "Third Title", 2016, "2016x");
        Book fourthBook = new Book("Fourth", "Fourth Title", 2014, "2014x");
        Book fifthBook = new Book("Fifth", "Fifth Title", 2012, "2012x");
        booksA.add(firstBook);
        booksA.add(secondBook);
        booksA.add(thirdBook);
        booksA.add(fourthBook);
        booksA.add(fifthBook);
        // When
        int median = medianAdapter.publicationYearMedian(booksA);
        // Then
        assertEquals(2016,median);
    }
}
