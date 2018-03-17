package me.insert.advance;

/**
 * 插入排序可以提前终止内层循环
 *
 * @author AlbertRui
 * @date 2018-03-17 17:11
 */
public class InsertionSort {
    public <T extends Comparable<T>> void sort(T[] arr) {
        for (int i = 1; i < arr.length; i++) {
            //寻找元素arr[i]合适的插入位置
            T e = arr[i];
            int j;//j保存元素应该插入的位置
            for (j = i; j > 0 && (arr[j - 1].compareTo(e) > 0); j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = e;
        }
    }

}
