import javax.lang.model.element.Name;
import java.util.ArrayList;
import java.util.List;


public class Main  {
    public static void main(String[] args) {
  Book book = new Book.Builder().name("Война и миир").build();

  System.out.println(book);
        List<String> names = List.of("Сергей", "Павел", "Дмитрий", "Иван", "Андрей", "Никита");
        List<String> surnames = List.of("Иванов", "Петров", "Сидоров", "Глушков", "Смирнов", "Бочкарев");
        List<String> patronymic = List.of("Иванович", "Петрович", "Владимирович", "Анатольевич", "Юрьевич", "Александрович");


        StudentFactory studentFactory = new StudentFactory(names, surnames);
  Student student = studentFactory.makeStudent();
  Student student1 = studentFactory.makeStudent();


        TeacherFactory teacherFactory = new TeacherFactory(names, patronymic, surnames);
        Teacher teacher = teacherFactory.makeTeacher();

 // System.out.println(student);
  //System.out.println(student1);
  System.out.println(teacher);


        }
    }
