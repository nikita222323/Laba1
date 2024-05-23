import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StudentFactory {
    private List<String> names;
    private List<String> surnames;

    public StudentFactory(List<String> names, List<String> surnames) {
        this.names = names;
        this.surnames = surnames;
    }

    public Student makeStudent() {
        Random random = new Random();
        int randomIndex = random.nextInt(names.size());
        String studentName = names.get(randomIndex);
        String studentSurname = surnames.get(randomIndex);
        return new Student(studentName, studentSurname);
    }

    public List<Student> makeStudents(int count) {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Student student = makeStudent();
            students.add(student);
        }
        return students;
    }

   // public static StudentFactory readFromExcel(String namesFilePath, String surnamesFilePath) {
     //   ExcelReader excelReader = new ExcelReader();
       // List<String> names = excelReader.ReadExcel(namesFilePath);
        //List<String> surnames = excelReader.ReadExcel(surnamesFilePath);
        //return new StudentFactory(names, surnames);
    //}
}