public class Book implements Cloneable {
    private String title;
    private String author;
    private String genre;
    private int publicationYear;
    private static int idCounter = 0;
    private int id;

    public Book(String title, String author, String genre, int publicationYear) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publicationYear = publicationYear;
        this.id = ++Book.idCounter;
    }

    @Override
    public Book clone() {
        try {
            Book clonedBook = (Book) super.clone();
            clonedBook.id = ++Book.idCounter;
            return clonedBook;
        }
        catch (CloneNotSupportedException e) {
            throw new RuntimeException("This should not happen since we implement Cloneable", e);
        }
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s | %s | ID: %s", this.title, this.author, this.genre, this.publicationYear, this.id);
    }
}
