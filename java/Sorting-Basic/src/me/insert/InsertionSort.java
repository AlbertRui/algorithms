package me.insert;

/**
 * @author AlbertRui
 * @date 2018-03-17 17:11
 */
public class InsertionSort {
    public <T extends Comparable<T>> void sort(T[] arr) {
        for (int i = 1; i < arr.length; i++) {
            //寻找元素arr[i]合适的插入位置
            for (int j = i; j > 0 && (arr[j].compareTo(arr[j - 1]) < 0); j--) {
                swap(arr, j, j - 1);
            }
        }
    }

    private <T extends Comparable<T>> void swap(T[] arr, int j, int i) {
        T temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
