public  class BookBuilder {
    private String name;
    private String level;
    private String type;


    public BookBuilder() {

    }
    public BookBuilder name(String name) {
        this.name = name;
        return this;
    }

    public BookBuilder level(String level) {
        this.level = level;
        return this;
    }
    public BookBuilder type(String type) {
        this.type = type;
        return this;
    }
    public Book build() {
        return new Book(name, level, type);
    }}
