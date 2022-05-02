package com.alexandrazbant.webappspringboot.bootstrap;

import com.alexandrazbant.webappspringboot.model.Author;
import com.alexandrazbant.webappspringboot.model.Book;
import com.alexandrazbant.webappspringboot.model.Publisher;
import com.alexandrazbant.webappspringboot.repositories.AuthorRepository;
import com.alexandrazbant.webappspringboot.repositories.BookRepository;
import com.alexandrazbant.webappspringboot.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        Publisher publisher = new Publisher("SFG Publishing", "325Street no.5", "St. Petersburg", "FL", 235416);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        System.out.println("Publisher count: " + publisherRepository.count());

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        publisherRepository.save(publisher);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "32124924");

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);

        System.out.println("Number of books " + bookRepository.count());
        System.out.println("Publisher Number of Books: "+ publisher.getBooks().size());
    }
}
