package guru.commerce.spring5WebApp.repositories;

import guru.commerce.spring5WebApp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
