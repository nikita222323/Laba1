import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Library {
    private List<Book> books = new ArrayList<>();
    private HashMap<Person, List<Book>> rentedBooks = new HashMap<>();

    public Library() {
    }

    public void addBook(Book book) {
        books.add(book);
    }
    public void addBooks(List<Book> books){
    this.books.addAll(books);
    }

    public List<Book> getBooks() {
        return books;
    }

    public Book getRandomBook(Person person) {
        if (books.isEmpty()) {
            throw new IllegalArgumentException("Лист с книгами пустой!");
        }
        int randomIndex = new Random().nextInt(books.size());
        Book randomBook = books.get(randomIndex);
        books.remove(randomIndex);
        person.addBook(randomBook);
        rentedBooks.put(person, books);
        return randomBook;
    }


    public List<Person> TakeRandomBook(List<Person> person) {
        for (Person person1 : person) {
            int randomIndex = new Random().nextInt(3, 10);
            for (int i = 0; i < randomIndex; i++){
            Book book = getRandomBook(person1);}
        }
        return person;
    }
}