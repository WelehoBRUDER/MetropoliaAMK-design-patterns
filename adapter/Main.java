public class Main {
    public static void main(String[] args) {
        CalendarToNewDateAdapter adapter = new CalendarToNewDateAdapter();
        adapter.setDay(5);
        adapter.setMonth(11);
        adapter.setYear(2017);
        printDate(adapter);
        adapter.advanceDays(71);
        printDate(adapter);
        adapter.advanceDays(96);
        printDate(adapter);
    }

    public static void printDate(CalendarToNewDateAdapter adapter) {
        int day = adapter.getDay();
        int month = adapter.getMonth() + 1; // Adjust for 0 index
        int year = adapter.getYear();
        System.out.printf("%d.%d.%d\n", day, month, year);
    }
}
