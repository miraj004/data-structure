package array;

public class Book {

    private final String author;
    private final String title;
    public final static int TITLE = 1;
    public final static int AUTHOR = 2;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String toString() {
        return "{ Title: " + this.title + ", Author:" + this.author + " }";
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}
