package org.kimlngo.quarkus.starting;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.logging.Logger;
import org.kimlngo.quarkus.starting.model.Book;
import org.kimlngo.quarkus.starting.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Path("/api/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

    @Inject
    private BookRepository bookRepository;

    @Inject
    private Logger logger; //Jboss logger

    @GET
    public List<Book> getAllBooks() {
        logger.info("Get all books");
        return this.bookRepository.getAllBooks();
    }

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public int countAllBooks() {
        logger.info("Get the number of books");
        return this.bookRepository.getAllBooks()
                                  .size();
    }

    @GET
    @Path("/{id}")
    public Optional<Book> getBookById(@PathParam("id") int id) {
        logger.info("Get the book with id = " + id);
        return this.bookRepository.getBookById(id);
    }
}
