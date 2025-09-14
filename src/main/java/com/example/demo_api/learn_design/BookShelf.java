package com.example.demo_api.learn_design;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookShelf implements Iterable<Book> {
    private List<Book> books;
    private int last = 0;

    public BookShelf(int initialize)
    {
        this.books = new ArrayList<Book>(initialize);
    }

    public Book getBookAt(int index)
    {
        return this.books.get(index);
    }

    public void appendBook(Book book)
    {
        this.books.add(book);
        last ++;
    }

    public int getLength()
    {
        return last;
    }

    @Override
    public Iterator<Book> iterator()
    {
        return new BookShelfIterator(this);
    }
}
