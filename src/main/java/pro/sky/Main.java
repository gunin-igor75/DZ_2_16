package pro.sky;

import java.util.Arrays;
import java.util.Random;

public class Main {

    private Integer[] arr = generateRandomArray();

    public Integer[] getArr() {
        return Arrays.copyOf(arr, arr.length);
    }

    private Integer[] generateRandomArray() {
        Random random = new Random();
        Integer[] arr = new Integer[100_000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(Integer.MAX_VALUE);
        }
        return arr;
    }

    private long getTime(Sort obj) {
        Integer[] arr = getArr();
        long begin = System.currentTimeMillis();
        obj.run(arr);
        long finish = System.currentTimeMillis();
        return finish - begin;
    }
    private void run() {
        System.out.println("Время сортировки вставкой "
                + getTime(new SortInsertion()));
        System.out.println("Время сортировки выбором "
                + getTime(new SortSelection()));
        System.out.println("Время сортировки пузырьком "
                + getTime(new SortBubble()));
    }


    public static void main(String[] args) {
        new Main().run();
    }
}
