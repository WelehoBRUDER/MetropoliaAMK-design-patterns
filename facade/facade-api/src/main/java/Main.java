public class Main {
    public static void main(String[] args) {
        ApiFacade facade = new ApiFacade();
        // Demonstrate Chuck Norris API
        try {
            String jokeText = facade.getAttributeValueFromJson("https://api.chucknorris.io/jokes/random", "value");
            System.out.println(jokeText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            String rates = facade.getAttributeValueFromJson("https://api.fxratesapi.com/latest", "rates");
            System.out.println(rates);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
