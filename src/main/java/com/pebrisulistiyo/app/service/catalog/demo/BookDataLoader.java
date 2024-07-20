package com.pebrisulistiyo.app.service.catalog.demo;

import com.pebrisulistiyo.app.service.catalog.domain.Book;
import com.pebrisulistiyo.app.service.catalog.domain.BookRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Profile("testdata")
public class BookDataLoader {
    private final BookRepository bookRepository;
    public BookDataLoader(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void loadBookTestData() {
        var book1 = new Book("1234567891", "Title 1", "Author", 1.1);
        var book2 = new Book("1234567892", "Title 2", "Author 2", 5.1);

        bookRepository.save(book1);
        bookRepository.save(book2);
    }
}
