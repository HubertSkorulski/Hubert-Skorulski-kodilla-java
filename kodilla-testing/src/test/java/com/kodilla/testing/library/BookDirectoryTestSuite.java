package com.kodilla.testing.library;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookDirectoryTestSuite {
    @Mock
    private LibraryDatabase libraryDatabaseMock;

    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<>();
        for (int n = 1; n <= booksQuantity; n++) {
            Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }

    @Test
    void testListBooksWithConditionsReturnList() {
        // Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOfBooks = new ArrayList<>();
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);

        resultListOfBooks.add(book1);
        resultListOfBooks.add(book2);
        resultListOfBooks.add(book3);
        resultListOfBooks.add(book4);

        when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);

        // When
        List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");

        // Then
        assertEquals(4, theListOfBooks.size());
    }
    @Test
    void testListBooksWithConditionMoreThan20() {
        // Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf0Books = new ArrayList<Book>();
        List<Book> resultListOf15Books = generateListOfNBooks(15);
        List<Book> resultListOf40Books = generateListOfNBooks(40);
        when(libraryDatabaseMock.listBooksWithCondition(anyString()))
                .thenReturn(resultListOf15Books);
        when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks"))
                .thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBooksWithCondition("FortyBooks"))
                .thenReturn(resultListOf40Books);
        // When
        List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
        List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
        List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");
        // Then
        assertEquals(0, theListOfBooks0.size());                                         // [14]
        assertEquals(15, theListOfBooks15.size());                                       // [15]
        assertEquals(0, theListOfBooks40.size());
    }
    @Test
    void testListBooksWithConditionFragmentShorterThan3() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);            // [2]
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);               // [3]

        // When
        List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");       // [4]

        // Then
        assertEquals(0, theListOfBooks10.size());                                     // [5]
        verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());    // [6]
    }

    @Test
    void testListBooksInHandsOf() {
        //Given

        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> borrowedBooks = new ArrayList<>();
        LibraryUser hababa = new LibraryUser("Haba","Baba","1408");

        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
        Book book5 = new Book("Secret of nothing","Hubert Skorulski",2020);
        borrowedBooks.add(book1);
        borrowedBooks.add(book2);
        borrowedBooks.add(book3);
        borrowedBooks.add(book4);
        borrowedBooks.add(book5);
        when(libraryDatabaseMock.listBooksInHandsOf(hababa)).thenReturn(borrowedBooks);
        //When
        List<Book> theListOfBooks = bookLibrary.listBooksInHandsOf(hababa);
        // Then
        assertEquals(5,theListOfBooks.size());
    }
    @Test
    void testListBooksInHandsOfOneBook() {
        //Given

        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser hababa = new LibraryUser("Haba","Baba","1408");
        List<Book> borrowedBooks = new ArrayList<>();
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        borrowedBooks.add(book1);
        when(libraryDatabaseMock.listBooksInHandsOf(hababa)).thenReturn(borrowedBooks);
        //When
        List<Book> theListOfBooks = bookLibrary.listBooksInHandsOf(hababa);
        // Then
        assertEquals(1,theListOfBooks.size());
    }
    @Test
    void testListBooksInHandsOfNoBooks() {
        //Given

        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> borrowedBooks = new ArrayList<>();
        LibraryUser hababa = new LibraryUser("Haba","Baba","1408");
        when(libraryDatabaseMock.listBooksInHandsOf(hababa)).thenReturn(borrowedBooks);
        //When
        List<Book> theListOfBooks = bookLibrary.listBooksInHandsOf(hababa);
        // Then
        assertEquals(0,theListOfBooks.size());
    }
}

