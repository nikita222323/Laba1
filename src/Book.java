import javax.swing.tree.MutableTreeNode;

public class Book {
    private String name;
    private String level;
    private String type;

    private Book(String name,  String level, String type) {
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

    public static class Builder {
        private String name;
        private String level;
        private String type;


        public  Builder() {

            }


    public Builder name(String name) {
        this.name = name;
        return this;
    }

    public Builder level(String level) {
        this.level = level;
        return this;
    }
    public Builder type(String type) {
        this.type = type;
        return this;
    }
    public Book build() {
        return new Book(name, level, type);
    }

}}
