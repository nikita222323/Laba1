import javax.lang.model.element.Name;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class Main {
    public static void main(String[] args) {
  Book book = new Book.Builder().name("Война и миир").build();

  System.out.println(book);

  ParserFIO parser = new ParserFIO();
  parser.parseTeacherData();

  ExcelReader excelReader = new ExcelReader();
  excelReader.ReadExcel("/Users/nikitagramma/IdeaProjects/untitled/src/StudentName.xlsx");
  List<String> names = excelReader.ReadExcel("/Users/nikitagramma/IdeaProjects/untitled/src/StudentName.xlsx");
  excelReader.ReadExcel("/Users/nikitagramma/IdeaProjects/untitled/src/StudentSecondName.xlsx");
  List<String> surnames = excelReader.ReadExcel("/Users/nikitagramma/IdeaProjects/untitled/src/StudentSecondName.xlsx");
        excelReader.ReadExcel("/Users/nikitagramma/IdeaProjects/untitled/src/Objects.xlsx");
        List<String> Objects = excelReader.ReadExcel("/Users/nikitagramma/IdeaProjects/untitled/src/Objects.xlsx");
        Random random = new Random();




        StudentFactory studentFactory = new StudentFactory(names, surnames);
  Student student = studentFactory.makeStudent();
  Student student1 = studentFactory.makeStudent();


        TeacherFactory teacherFactory = new TeacherFactory(parser.getTeacherNames(), parser.getTeacherPatronymics(), parser.getTeacherSurnames());
        Teacher teacher = teacherFactory.makeTeacher();
        Teacher teacher1 = teacherFactory.makeTeacher();


  System.out.println(student);
  System.out.println(student1);
 // System.out.println(teacher);
  //System.out.println(teacher1);



       // StudentFactory studentFactory = new StudentFactory(names, surnames);
       // TeacherFactory teacherFactory = new TeacherFactory();

        int numOfStudents = 5; // Specify the number of students you want to generate
        int numOfTeachers = 3; // Specify the number of teachers you want to generate

        Library library = new Library();
        library.generateRandomUsers(numOfStudents, numOfTeachers);
    }
}
