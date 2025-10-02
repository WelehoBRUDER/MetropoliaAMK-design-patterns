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

        // This UI code is horrendous, but it still beats making a graphical interface.
        // Instead of bothering with validation, I just wrapped everything in try/catch.
        // I foresee no possible problems from this kind of design philosophy!
        Scanner input = new Scanner(System.in);
        int userInput = -1;
        int id = -1;
        View view = View.MENU;
        while (userInput != 0) {
            try {
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
                } else if (view == View.BOOKS) {
                    library.printAllBooks();
                    System.out.println("Choose an option: ");
                    System.out.println("1. Go back");
                    userInput = input.nextInt();
                    if (userInput == 1) {
                        view = View.MENU;
                    }
                } else if (view == View.RECOMMENDS) {
                    List<Recommendation> recommends = library.getAllRecommendations();
                    System.out.println("\n----------------------------------");
                    for (int i = 0; i < recommends.size(); i++) {
                        Recommendation recommendation = recommends.get(i);
                        System.out.println(recommendation + " { ID: " + i + " }");
                    }
                    System.out.println("----------------------------------\n");
                    System.out.println("Choose an option: ");
                    System.out.println("1. View recommendation");
                    System.out.println("2. Edit recommendation");
                    System.out.println("3. Copy recommendation");
                    System.out.println("4. Go back");
                    userInput = input.nextInt();
                    if (userInput == 1) {
                        System.out.print("Enter ID of recommendation to view: ");
                        id = input.nextInt();
                        library.getRecommendation(id).showBooks();

                    } else if (userInput == 2) {
                        view = View.EDIT;
                        System.out.print("ID of recommendation to edit: ");
                        id = input.nextInt();

                    } else if (userInput == 3) {
                        System.out.print("ID of recommendation to copy: ");
                        id = input.nextInt();
                        library.cloneRecommendation(id);
                    }
                    else if (userInput == 4) {
                        view = View.MENU;
                    }
                } else if (view == View.EDIT) {
                    Recommendation recommendation = library.getRecommendation(id);
                    if (recommendation != null) {
                        System.out.println("You are editing recommendation");
                        System.out.println(recommendation);
                        recommendation.showBooks();
                        System.out.println("Choose an option: ");
                        System.out.println("1. Change target audience");
                        System.out.println("2. Add book");
                        System.out.println("3. Remove book");
                        System.out.println("4. Go back");
                        userInput = input.nextInt();
                        if (userInput == 1) {
                            System.out.print("Enter new target audience: ");
                            String ta = input.next();
                            recommendation.setTargetAudience(ta);
                        } else if (userInput == 2) {
                            System.out.println("-------------------");
                            System.out.println("Here are all possible books you can add:");
                            library.printAllBooks();
                            System.out.println("-------------------");
                            System.out.print("Enter ID of book: ");
                            int bookId = input.nextInt();
                            recommendation.addBook(library.getBook(bookId - 1));
                        } else if (userInput == 3) {
                            System.out.print("Enter ID of book you wish to remove: ");
                            int bookId = input.nextInt();
                            recommendation.removeBook(bookId);
                        } else if (userInput == 4) {
                            view = View.MENU;
                        }
                    }
                }
                else {
                    System.out.print("Enter target audience of new recommendation: ");
                    String ta = input.next();
                    System.out.println(ta);
                    library.addRecommendation(ta);
                    int newId = library.getAllRecommendations().size() - 1;
                    int __input = -1;
                    while (__input != 0) {
                        System.out.println("Choose an option: ");
                        System.out.println("1. Add book to recommendation");
                        System.out.println("2. Save & return to menu");
                        __input = input.nextInt();
                        if (__input == 1) {
                            library.printAllBooks();
                            System.out.print("Enter ID of book to add: ");
                            int bookId = input.nextInt();
                            library.addBookToRecommendation(bookId - 1, newId);
                        }
                        else if (__input == 2) {
                            view = View.MENU;
                            break;
                        }
                    }
                }
            }
            catch (Exception e) {
                System.out.println("****************************");
                System.out.println("Whoops, something went wrong");
                System.out.println(e.getMessage());
                System.out.println("Let's try this again!");
                System.out.println("****************************");
                userInput = -1;
                id = -1;
                view = View.MENU;
            }
        }
        System.out.println("Quitting...");
    }
}
