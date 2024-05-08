import javax.lang.model.element.Name;
import java.util.ArrayList;
import java.util.List;


public class Main  {
    public static void main(String[] args) {
  Book book = new Book.Builder().name("Война и миир").build();

  System.out.println(book);

  ParserFIO parser = new ParserFIO();
  parser.parseTeacherData();


       // StudentFactory studentFactory = new StudentFactory(names, surnames);
  //Student student = studentFactory.makeStudent();
  //Student student1 = studentFactory.makeStudent();


        TeacherFactory teacherFactory = new TeacherFactory(parser.getTeacherNames(), parser.getTeacherPatronymics(), parser.getTeacherSurnames());
        Teacher teacher = teacherFactory.makeTeacher();
        Teacher teacher1 = teacherFactory.makeTeacher();

 // System.out.println(student);
  //System.out.println(student1);
  System.out.println(teacher);
        System.out.println(teacher1);


        }
    }
