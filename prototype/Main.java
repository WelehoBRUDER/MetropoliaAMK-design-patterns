public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        library.addBook("Biology 101", "James Cook", "science", 2006);
        library.addBook("Mysteries Unsolved", "James Gunn", "mystery", 1999);
        library.addBook("Fantasy Lands", "Drewl", "fantasy", 2003);
        library.addBook("Grand Stars", "Janice M", "scifi", 2015);
        library.addBook("Epic Tales of Fantasia", "Lisa Bold", "fantasy", 1926);
        library.addBook("Voyage Through Time", "Trevor Smith", "scifi", 2023);
        library.addBook("Advanced Math", "James Cook", "science", 2007);

        library.addRecommendation("Young");
        library.addRecommendation("Adult");
        library.addRecommendation("Student");

        library.addBookToRecommendation(0, 2);
        library.addBookToRecommendation(6, 2);

        library.getRecommendation(2).showBooks();
    }
}
