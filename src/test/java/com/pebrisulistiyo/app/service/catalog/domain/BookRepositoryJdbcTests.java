package com.pebrisulistiyo.app.service.catalog.domain;

import com.pebrisulistiyo.app.service.catalog.config.DataConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;
import org.springframework.data.jdbc.core.JdbcAggregateTemplate;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import java.util.logging.Logger;

@DataJdbcTest
@Import(DataConfig.class)
@AutoConfigureTestDatabase(
        replace = AutoConfigureTestDatabase.Replace.NONE
)
public class BookRepositoryJdbcTests {
    private static final Logger LOGGER = Logger.getLogger(BookRepositoryJdbcTests.class.getName());

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private JdbcAggregateTemplate aggregateTemplate;

    @Test
    void findBookByIsbnWhenExist() {
        LOGGER.info("Starting test container!");
        var bookIsbn = "1234567890";
        var book = Book.of(bookIsbn, "Title", "Author", 12.1, "Manning");
        aggregateTemplate.insert(book);
        Optional<Book> actualBook = bookRepository.findByIsbn(bookIsbn);

        assertThat(actualBook).isPresent();
        assertThat(actualBook.get().isbn()).isEqualTo(book.isbn());
        LOGGER.info("Finished test container!");
    }
}
