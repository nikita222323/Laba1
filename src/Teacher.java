import java.util.List;
import java.util.ArrayList;

public class Teacher {
    private String name;
    private String patronymic;
    private String surname;
    private List<Book> books;

    public Teacher(String name, String patronymic, String surname) {
        this.name = name;
        this.patronymic = patronymic;
        this.surname = surname;
        this.books = new ArrayList<>();
    }

    @Override
    public String toString() {
        return this.surname + " " + this.name + " " + this.patronymic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }
}