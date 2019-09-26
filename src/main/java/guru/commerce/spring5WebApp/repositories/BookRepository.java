package guru.commerce.spring5WebApp.repositories;

import guru.commerce.spring5WebApp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
