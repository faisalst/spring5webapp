package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repoitories.AuthorRepository;
import guru.springframework.spring5webapp.repoitories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private AuthorRepository authorrepo;
    private BookRepository bookrepo;

    public BootStrapData(AuthorRepository authorrepo, BookRepository bookrepo) {
        this.authorrepo = authorrepo;
        this.bookrepo = bookrepo;
    }

    @Override
    public void run(String... args) throws Exception {

        Book hah = new Book("hah", "33424");
        Author bob = new Author("bob", "johns");
        hah.getAuthors().add(bob);
        bob.getBooks().add(hah);

        bookrepo.save(hah);
        authorrepo.save(bob);


        System.out.println("Number of books: " + bookrepo.count());
    }
}
