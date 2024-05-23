import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TeacherFactory {

   private List<String> names ;
    private List<String> surnames ;
   private List<String> patronymic ;

    public TeacherFactory(List<String> names, List<String> surnames, List<String> patronymic) {
        this.names = names;
        this.surnames = surnames;
        this.patronymic = patronymic;

    }
    public Teacher makeTeacher(){
        Random random = new Random();
        int randomIndex = random.nextInt(names.size());
        String teachert_name = names.get(randomIndex);
        String teacher_surname = surnames.get(randomIndex);
        String teacher_patronymic = patronymic.get(randomIndex);
        Teacher teacher = new Teacher(teachert_name, teacher_surname, teacher_patronymic);
        return teacher;
    }

    public List<Teacher> makeTeachers(int count) {
        List<Teacher> teachers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Teacher teacher = makeTeacher();
            teachers .add(teacher);
        }
        return teachers ;

    }
}