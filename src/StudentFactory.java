import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StudentFactory {

    List<String> names ;
    List<String> surnames ;
    public StudentFactory(String StudentName, StringStudentSecondName) {
        this.names = names;
        this.surnames = surnames;

    }
    public Student makeStudent(){
        if (names.isEmpty()) {
            throw new IllegalArgumentException("List of names is empty!");
        }
        Random random = new Random();
        int randomIndex = random.nextInt(names.size());
        String studentname = names.get(randomIndex);
        String surname = surnames.get(randomIndex);
        Student student = new Student(studentname, surname);
        return student;
}
}


