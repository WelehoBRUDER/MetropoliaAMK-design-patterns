public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        library.createUnprotectedDocument("For public use");
        library.createProtectedDocument("If you're reading this without authorization, you will be sued.");

        User bob = new User("Bob");
        User janice = new User("Janice");

        library.giveAccess(1, janice.getUsername());

        try {
            System.out.println(library.getDocument(0).getContent(bob));
            System.out.println(library.getDocument(0).getContent(janice));
            System.out.println(library.getDocument(1).getContent(janice));
            System.out.println(library.getDocument(1).getContent(bob));
        }
        catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }

    }
}
