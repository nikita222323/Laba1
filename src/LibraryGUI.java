import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LibraryGUI extends JFrame {
    private JButton generateButton;
    private JTree userTree;
    private DefaultTreeModel treeModel;
    private Library library;


    public LibraryGUI() {
        setTitle("Library");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        generateButton = new JButton("Generate Books");
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateRandomUsers();
            }
        });
        add(generateButton, BorderLayout.NORTH);

        userTree = new JTree();
        treeModel = (DefaultTreeModel) userTree.getModel();
        add(new JScrollPane(userTree), BorderLayout.CENTER);

        library = new Library();
    }

    private void generateRandomUsers() {
        int numOfStudents = 5; // Количество рандомных студентов
        int numOfTeachers = 3; // Количество рандомных преподавателей

        library.generateRandomUsers(numOfStudents, numOfTeachers);
        updateTree();
    }

    private void updateTree() {
        treeModel.setRoot(createTreeNode(library));
    }
    int numOfStudents = 5;
    int numOfTeachers = 5;
    private DefaultMutableTreeNode createTreeNode(Library library) {
        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("Library");

        List<Student> students = library.generateRandomUsers(numOfStudents,  numOfTeachers);
        DefaultMutableTreeNode studentsNode = new DefaultMutableTreeNode("Students");
        for (Student student : students) {
            DefaultMutableTreeNode studentNode = new DefaultMutableTreeNode(student.toString());
            studentsNode.add(studentNode);
        }
        rootNode.add(studentsNode);

        List<Teacher> teachers = library.generateRandomUsers( numOfStudents,  numOfTeachers);
        DefaultMutableTreeNode teachersNode = new DefaultMutableTreeNode("Teachers");
        for (Teacher teacher : teachers) {
            DefaultMutableTreeNode teacherNode = new DefaultMutableTreeNode(teacher.toString());
            teachersNode.add(teacherNode);
        }
        rootNode.add(teachersNode);

        return rootNode;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                LibraryGUI libraryGUI = new LibraryGUI();
                libraryGUI.setVisible(true);
            }
        });
    }
}