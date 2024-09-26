package guru.springframework.spring6webapp.bootstrap;

import guru.springframework.spring6webapp.domain.Author;
import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.domain.repository.AuthorRespository;
import guru.springframework.spring6webapp.domain.repository.BookRespository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData  implements CommandLineRunner {

    private final AuthorRespository authorRespository;
    private final BookRespository bookRespository;

    public BootstrapData(AuthorRespository authorRespository, BookRespository bookRespository) {
        this.authorRespository = authorRespository;
        this.bookRespository = bookRespository;
    }


    @Override
    public void run(String... args) throws Exception {
        Author robbie = new Author();
        robbie.setFirstName("Robbie");
        robbie.setLastName("Bowers");

        Book magic = new Book();
        magic.setTitle("Magic Book");
        magic.setIsbn("1234");

        Author robbieSaved = authorRespository.save(robbie);
        Book magicSaved = bookRespository.save(magic);

        Author emily = new Author();
        emily.setFirstName("Emily");
        emily.setLastName("Adams");

        Book thesis = new Book();
        thesis.setTitle("Thesis");
        thesis.setIsbn("1235");

        Author emilySaved = authorRespository.save(emily);
        Book thesisSaved = bookRespository.save(thesis);

        robbieSaved.getBooks().add(magicSaved);
        emilySaved.getBooks().add(thesisSaved);

        authorRespository.save(robbieSaved);
        authorRespository.save(emilySaved);

        System.out.println("In Bootstrap");
        System.out.println("Author Count:" + authorRespository.count());
        System.out.println("Book Count:" + bookRespository.count());



    }
}
