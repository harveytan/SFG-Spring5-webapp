package guru.commerce.spring5WebApp.devBootStrap;

import guru.commerce.spring5WebApp.model.Author;
import guru.commerce.spring5WebApp.model.Book;
import guru.commerce.spring5WebApp.model.Publisher;
import guru.commerce.spring5WebApp.repositories.AuthorRepository;
import guru.commerce.spring5WebApp.repositories.BookRepository;
import guru.commerce.spring5WebApp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository){
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        this.initData();
    }
    private void initData() {
        Author author1 = new Author("John", "Doe");
        Author author2 = new Author("Kimberly", "Doe");
        Set<Book> johnsBooks = new HashSet<Book>();
        Publisher publisher = new Publisher("Addison", "111 wayne", "new york");
        publisher = publisherRepository.save(publisher);
        Book[] books = {new Book("How to do Spring", "isbn-1", publisher),
                new Book("How to do Spring Second Edition", "isbn-2", publisher),
                new Book("How to do Spring Third Edition", "isbn-3", publisher)};
        johnsBooks.addAll(Arrays.asList(books));
        author1.setBooks(johnsBooks);

        author1 = this.authorRepository.save(author1);
        for (Book book : johnsBooks){
            book.getAuthors().add(author1);
            this.bookRepository.save(book);
        }

        author2 = this.authorRepository.save(author2);

        // john owns 3 books exclusively
        // kim own 1 book which is also co-owned by john

        Publisher publisher2 = new Publisher("WROX", "111 wrox way", "new york");
        publisher2 = publisherRepository.save(publisher2);
        Book kimAndJohnBook = new Book("How to program in Java by Kim and John", "isbn-4", publisher2);
        Set<Author> authors = new HashSet<Author>();
        authors.add(author1);
        authors.add(author2);
        kimAndJohnBook.setAuthors(authors);
        this.bookRepository.save(kimAndJohnBook);
        System.out.println("*************************************** CREATED DATA ***************************************************************");
        System.out.println(publisher.getId());
        // Optional<Publisher> o = publisherRepository.findById(publisher.getId());
        // Publisher publisher3 = o.get();
        Iterable<Publisher> i = publisherRepository.findAll();
        Publisher publisher3 = i.iterator().next();
//        System.out.println(publisher.getName() + " published book:" + publisher.getBooks()..getTitle());
//        System.out.println(publisher3.getName() + " published book:" + publisher3.getBook().getTitle());

    }
}
