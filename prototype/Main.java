import java.util.List;
import java.util.Scanner;

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
        library.addBookToRecommendation(1, 1);
        library.addBookToRecommendation(2, 1);
        library.addBookToRecommendation(3, 1);
        library.addBookToRecommendation(0, 0);
        library.addBookToRecommendation(5, 0);

        Recommendation cloned = library.cloneRecommendation(1);
        cloned.setTargetAudience("Adventure fan");
        library.addBookToRecommendation(5, 3);

//        library.getRecommendation(2).showBooks();
//        library.getRecommendation(1).showBooks();
//        library.getRecommendation(3).showBooks();

        // This UI code is horrendous, but it still beats making a graphical interface.
        Scanner input = new Scanner(System.in);
        int userInput = -1;
        View view = View.MENU;
        while (userInput != 0) {
            System.out.println("You can quit at any time by entering '0'");
            if (view == View.MENU) {
                System.out.println("Choose an option: ");
                System.out.println("1. View all books");
                System.out.println("2. View all recommendation lists");
                System.out.println("3. Add new recommendation list");
                userInput = input.nextInt();
                switch (userInput) {
                    case 1:
                        view = View.BOOKS;
                        break;
                    case 2:
                        view = View.RECOMMENDS;
                        break;
                    case 3:
                        view = View.CREATE;
                        break;
                }
            }
            else if (view == View.BOOKS) {
                library.printAllBooks();
                System.out.println("Choose an option: ");
                System.out.println("1. Go back");
                userInput = input.nextInt();
                if (userInput == 1) {
                    view = View.MENU;
                }
            }
            else if (view == View.RECOMMENDS) {
                List<Recommendation> recommends = library.getAllRecommendations();
                System.out.println("\n----------------------------------");
                for (int  i = 0; i < recommends.size(); i++) {
                    Recommendation recommendation = recommends.get(i);
                    System.out.println(recommendation + " { ID: " + i + " }");
                }
                System.out.println("----------------------------------\n");
                System.out.println("Choose an option: ");
                System.out.println("1. Go back");
                userInput = input.nextInt();
                if (userInput == 1) {
                    view = View.MENU;
                }
            }
        }
        System.out.println("Quitting...");
    }
}
