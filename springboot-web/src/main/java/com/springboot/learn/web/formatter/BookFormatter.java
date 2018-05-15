package com.springboot.learn.web.formatter;

import java.awt.print.Book;
import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

public class BookFormatter implements Formatter<Book> {

	@Override
	public String print(Book book, Locale locale) {
		return String.valueOf(book.getNumberOfPages());
	}

	@Override
	public Book parse(String bookIdentifier, Locale locale) throws ParseException {
		Book book = new Book();
        return book;
	}

}
