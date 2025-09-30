import java.util.ArrayList;
import java.util.List;

public class Recommendation implements Cloneable {
    private String targetAudience;
    private List<Book> books;

    public Recommendation(String targetAudience, List<Book> books) {
        this.targetAudience = targetAudience;
        this.books = books;
    }

    @Override
    public Recommendation clone() {
        try {
            Recommendation clonedRecommendation = (Recommendation) super.clone();
            clonedRecommendation.books = new ArrayList<>();
            for (Book book : this.books) {
                clonedRecommendation.books.add(book.clone());
            }
            return clonedRecommendation;
        }
        catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public void removeBook(Book book) {
        this.books.remove(book);
    }

    public void addBook(Book book) {
        this.books.add(book.clone());
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    public void showBooks() {
        System.out.println("Books for " + targetAudience + ":");
        for (Book book : this.books) {
            System.out.println(book.toString());
        }
    }
}
