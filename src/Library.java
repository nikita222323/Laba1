import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Library {
    private List<Book> books = new ArrayList<>();
    private HashMap<Person, List<Book>> rentedBooks = new HashMap<>();
    private StudentFactory studentFactory;
    private TeacherFactory teacherFactory;

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

    public void returnBook(Person person, Book returnedBook) {
        if (rentedBooks.containsKey(person)) {
            List<Book> personBooks = rentedBooks.get(person);
            if (personBooks.contains(returnedBook)) {
                personBooks.remove(returnedBook);
                books.add(returnedBook);
                System.out.println("Книга возвращена.");
            } else {
                System.out.println("Этот ученик не взял эту книгу.");;
            }
        } else {
            System.out.println("Этот ученик не взял книгу.");
        }
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