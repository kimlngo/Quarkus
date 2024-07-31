package org.kimlngo.quarkus.starting.repository;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.kimlngo.quarkus.starting.model.Book;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookRepository {

    @ConfigProperty(name = "books.genre", defaultValue = "Sci-Fi")
    private String genre;

    public List<Book> getAllBooks() {
        return List.of(new Book(1, "Understanding Quarkus", "Antonio", 2020, genre),
                new Book(2, "Practicing Quarkus", "Antonio", 2020, genre),
                new Book(3, "Effective Java", "Josh Bloch", 2001, genre),
                new Book(4, "Thinking in Java", "Bruce Eckel", 1998, genre),
                new Book(5, "The Complete JavaScript Course 2024: From Zero to Expert!", "Jonas Schmedtmann", 2021, genre));

    }

    public Optional<Book> getBookById(int id) {
        return this.getAllBooks()
                   .stream()
                   .filter(book -> book.id() == id)
                   .findFirst();
    }
}
