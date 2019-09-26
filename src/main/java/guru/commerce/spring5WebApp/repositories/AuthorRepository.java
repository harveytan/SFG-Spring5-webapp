package guru.commerce.spring5WebApp.repositories;

import guru.commerce.spring5WebApp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
