package guru.commerce.spring5WebApp.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String address1;
    private String city;

    @OneToMany(mappedBy = "publisher")
    private Set<Book> books;

    public Publisher(String name, String address1, String city) {
        this.name = name;
        this.address1 = address1;
        this.city = city;
    }

    public Publisher(String name, String address1, String city, Set<Book> books) {
        this.name = name;
        this.address1 = address1;
        this.city = city;
        this.books = books;
    }
    public Publisher(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBook(Set<Book> books) {
        this.books = books;
    }
}
