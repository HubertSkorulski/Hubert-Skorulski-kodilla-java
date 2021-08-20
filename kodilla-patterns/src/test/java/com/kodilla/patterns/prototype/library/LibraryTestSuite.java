package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LibraryTestSuite {

    @Test
    void testGetBooks() {
        //Given
        Library firstLibrary = new Library("First Library");
        firstLibrary.getBooks().add(new Book("First Book","First author", LocalDate.of(1995,8,14)));
        firstLibrary.getBooks().add(new Book("Second Book","Second author", LocalDate.of(1995,9,14)));
        firstLibrary.getBooks().add(new Book("Third Book","Third author", LocalDate.of(1995,10,14)));
        firstLibrary.getBooks().add(new Book("Fourth Book","Fourth  author", LocalDate.of(1995,11,14)));

        //shallow copy
        Library shallowLibrary = null;
        try {
            shallowLibrary = firstLibrary.shallowCopy();
            shallowLibrary.setName("Shallow Library");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //deep copy
        Library deepLibrary = null;
        try {
            deepLibrary = firstLibrary.deepCopy();
            deepLibrary.setName("Deep Library");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //When
        //firstLibrary.getBooks().clear();

        //Then
        assertEquals(4,firstLibrary.getBooks().size());
        assertEquals(4,shallowLibrary.getBooks().size());
        assertEquals(4,deepLibrary.getBooks().size());
        assertEquals(firstLibrary.getBooks(),shallowLibrary.getBooks());
        assertNotEquals(firstLibrary,deepLibrary);

    }
}
