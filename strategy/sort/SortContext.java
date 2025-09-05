package sort;

public class SortContext {

    private Sort sortStrategy;

    public SortContext(Sort sort) {
        this.sortStrategy = sort;
    }

    public void setStrategy(Sort sort) {
        this.sortStrategy = sort;
    }

    public int[] sortArray(int[] arr) {
        return sortStrategy.sort(arr);
    }
}