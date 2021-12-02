package com.kodilla.patterns2.adapter.bookclassifier;


import com.kodilla.patterns2.adapter.bookclasifier.MedianAdapter;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.BookA;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedianAdapterTestSuite {

    @Test
    void medianTest () {
        // Given
        MedianAdapter medianAdapter = new MedianAdapter();
        Set<BookA> booksA = new HashSet<>();
        BookA firstBook = new BookA("First", "First Title", 2020, "2020x");
        BookA secondBook = new BookA("Second", "Second Title", 2018, "2018x");
        BookA thirdBook = new BookA("Third", "Third Title", 2016, "2016x");
        BookA fourthBook = new BookA("Fourth", "Fourth Title", 2014, "2014x");
        BookA fifthBook = new BookA("Fifth", "Fifth Title", 2012, "2012x");
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
