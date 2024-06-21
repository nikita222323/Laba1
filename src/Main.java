import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;


public class Main {
   // public static void main(String[] args) throws IOException {}
    public static List<Person> GeneratePersonList() throws IOException {


        ExcelReader excelReader = new ExcelReader();
        excelReader.ReadExcel("/Users/nikitagramma/IdeaProjects/untitled/src/StudentName.xlsx");
        List<String> names = excelReader.ReadExcel("/Users/nikitagramma/IdeaProjects/untitled/src/StudentName.xlsx");
        excelReader.ReadExcel("/Users/nikitagramma/IdeaProjects/untitled/src/StudentSecondName.xlsx");
        List<String> surnames = excelReader.ReadExcel("/Users/nikitagramma/IdeaProjects/untitled/src/StudentSecondName.xlsx");
        excelReader.ReadExcel("/Users/nikitagramma/IdeaProjects/untitled/src/Objects.xlsx");
        List<String> Objects = excelReader.ReadExcel("/Users/nikitagramma/IdeaProjects/untitled/src/Objects.xlsx");
        Random random = new Random();

        List<String> NameBooks = ParserBook.ParseNameBook();
        List<String> EngNameBooks = ParserBook.ParseEnglishBook();
        List<Book> books = new ArrayList<Book>();
        for (String i : NameBooks) {
            books.add(new BookBuilder().name(i).build());
        }

        List<String> types = new ArrayList<String>();
        types.add("Учебник");
        types.add("Пособие");
        types.add("Задачник");

        List<String> level = new ArrayList<String>();
        level.add("Бакалавр");
        level.add("Магистр");
        level.add("Аспирант");

        for (String i : Objects) {
            int randomIndex = new Random().nextInt(types.size());
            String random_Name = types.get(randomIndex);
            books.add(new BookBuilder().name(i).type(random_Name).build());

        }

        for (String i : EngNameBooks) {
            int randomIndex = new Random().nextInt(types.size());
            String random_Name = level.get(randomIndex);
            books.add(new BookBuilder().name(i).level(random_Name).build());
        }

        StudentFactory studentFactory = new StudentFactory(names, surnames);


        ParserFIO parser = new ParserFIO();
        parser.parseTeacherData();

        TeacherFactory teacherFactory = new TeacherFactory(parser.getTeacherNames(), parser.getTeacherPatronymics(), parser.getTeacherSurnames());

        List<Person> persons = new ArrayList<Person>();
        List<Teacher> teachers = teacherFactory.makeTeachers(30);
        List<Student> student = studentFactory.makeStudents(30);
        persons.addAll(teachers);
        persons.addAll(student);

        Library library = new Library();
        library.addBooks(books);
        List<Person> Person = library.TakeRandomBook(persons);
        System.out.println(Person);
        return persons;
    }
    public static void printPersonList(List<Person> persons, DropdownTreeNode dropdownNode) {
        for (Person person : persons) {
                DropdownTreeNode dropdownNode_Teacher = new DropdownTreeNode(person.getSurname() + " " + person.getName());
                for (Book book : person.getBooks()) {
                    if(Objects.equals(book.getName(), "")){
                        continue;
                    }
                    DropdownTreeNode dropdownNode_Book = new DropdownTreeNode(book.getName());
                    if (book.getLevel() != null) {
                        dropdownNode_Book.add(new DropdownTreeNode(book.getLevel()));
                    }
                    if (book.getType() != null) {
                        dropdownNode_Book.add(new DropdownTreeNode(book.getType()));
                    }
                    dropdownNode_Teacher.add(dropdownNode_Book);
                }
                dropdownNode.add(dropdownNode_Teacher);
            }
        }

    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame("Библиотека");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("Пользователи");
        DropdownTreeNode dropdownNode = new DropdownTreeNode("Преподаватели");
        DropdownTreeNode dropdownNode_Student = new DropdownTreeNode("Студенты");

        List<Person> persons = GeneratePersonList();
        List<Person> student = new ArrayList<>();
        List<Person> teacher = new ArrayList<>();
        for(Person person : persons){
            if(person instanceof Teacher){
                teacher.add(person);
            }
            if(person instanceof Student){
                student.add(person);
            }
        }
        printPersonList(student, dropdownNode_Student);
        printPersonList(teacher, dropdownNode);
        rootNode.add(dropdownNode);
        rootNode.add(dropdownNode_Student);

        JTree tree = new JTree(rootNode);
        frame.add(new JScrollPane(tree));
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    static class DropdownTreeNode extends DefaultMutableTreeNode {
        public DropdownTreeNode(Object userObject) {
            super(userObject);
        }

        @Override
        public boolean isLeaf() {
            return false; // Помечаем узел как нелистовой, чтобы отобразить его как выпадающий список
        }
    }
}

