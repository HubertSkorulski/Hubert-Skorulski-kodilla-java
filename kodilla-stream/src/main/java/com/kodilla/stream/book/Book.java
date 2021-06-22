package com.kodilla.stream.book;

public class Book {
    private final String author;
    private final String tittle;
    private final int yearOfPublication;
    private final String signature;

    public Book(String author, String tittle, int yearOfPublication, String signature) {
        this.author = author;
        this.tittle = tittle;
        this.yearOfPublication = yearOfPublication;
        this.signature = signature;

    }

    public String getAuthor() {
        return author;
    }

    public String getTittle() {
        return tittle;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }
    public String getSignature(){
        return signature;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", tittle='" + tittle + '\'' +
                ", yearOfPublication=" + yearOfPublication +
                ", signature" + signature +
                '}';
    }
}
