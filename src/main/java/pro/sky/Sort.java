package pro.sky;

public interface Sort {
    void run(Integer[] arr);
    default void swapElements(Integer[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
