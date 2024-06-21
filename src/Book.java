

public class Book {
    private String name;
    private String level;
    private String type;

    public Book(String name,  String level, String type) {
        this.name = name;
        this.level = level;
        this.type = type;
    }
@Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", level='" + level + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public  String getName() {
        return this.name;
    }
    public  String getLevel() {
        return this.level;
    }
    public  String getType() {
        return this.type;
    }
}
