import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<Recommendation> recommendations;

    public Library() {
        this.books = new ArrayList<>();
        this.recommendations = new ArrayList<>();
    }

    public Recommendation getRecommendation(int recommendationId) {
        return this.recommendations.get(recommendationId);
    }

    public void addBook(String title, String author, String genre, int year) {
        Book book = new Book(title, author, genre, year);
        this.books.add(book);
    }

    public void addRecommendation(String audience) {
        Recommendation recommendation = new Recommendation(audience, new ArrayList<>());
        this.recommendations.add(recommendation);
    }

    public void addBookToRecommendation(int bookId, int recommendationId) {
        this.recommendations.get(recommendationId).addBook(books.get(bookId));
    }
}
