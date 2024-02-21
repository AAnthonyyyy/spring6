package com.hgm.springiocxml.di;


public class Book {
    private String name;
    private String author;

    public Book() {
        System.out.println("无参数构造...");
    }

    public Book(String name, String author) {
        System.out.println("有参数构造...");
        this.name = name;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author=" + author +
                '}';
    }
}
