public class Book {
    private String name;
    private String author;
    private String title;
    private String genre;
    private String level;
    private String type;

    private Book(String name, String author, String title, String genre, String level, String type) {
        this.name = name;
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.level = level;
        this.type = type;
    }
@Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", level='" + level + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
    public static class Builder {
        private String name;
        private String author;
        private String title;
        private String genre;
        private String level;
        private String type;


        public  Builder() {

            }

    public Builder author(String author) {
        this.author = author;
        return this;

    }
    public Builder name(String name) {
        this.name = name;
        return this;
    }
    public Builder title(String title) {
        this.title = title;
        return this;
    }
    public Builder genre(String genre) {
        this.genre = genre;
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
        return new Book(name, author, title, genre, level, type);
    }
}}
