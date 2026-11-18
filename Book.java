
public class Book {

    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String borrowBy(Student student) {

        return student.getName()
                + " with matric number "
                + student.getMatric()
                + " has borrow a book with title "
                + title + ".";
    }

    @Override
    public String toString() {
        return title + " (" + author + ")";
    }
}
