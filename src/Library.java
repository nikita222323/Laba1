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

    public List<Book> getBooks() {
        return books;
    }

    public Book getRandomBook(Person person) {
        if (books.isEmpty()) {
            return null;
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
                System.out.println("The person did not rent this book.");
            }
        } else {
            System.out.println("The person has not rented any books.");
        }
    }
    public void generateRandomUsers(int numOfStudents, int numOfTeachers) {
        List<Student> students = new ArrayList<>();
        List<Teacher> teachers = new ArrayList<>();

        for (int i = 0; i < numOfStudents; i++) {
            Student student = studentFactory.makeStudent();
            students.add(student);
        }

        for (int i = 0; i < numOfTeachers; i++) {
            Teacher teacher = teacherFactory.makeTeacher();
            teachers.add(teacher);
        }

        System.out.println("Generated Students:");
        for (Student student : students) {
            System.out.println(student.toString());
        }

        System.out.println("Generated Teachers:");
        for (Teacher teacher : teachers) {
            System.out.println(teacher.toString());
        }
    }
}