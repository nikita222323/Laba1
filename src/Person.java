import java.util.List;

public abstract class Person {
    private String name;
    private String surname;
    private List<Book> books;

    public abstract String getName();

    public abstract String getSurname();
    public abstract  void setName(String name);
    public abstract  void setSurname(String surname);
    public abstract  List<Book> getBooks();
    public abstract  void addBook(Book book);

}
