package me.insert.advance;

import me.select.performance.SelectionSort;
import me.util.SortTestHelper;

import java.util.Arrays;

/**
 * @author AlbertRui
 * @date 2018-03-17 17:20
 */
public class Main {
    public static void main(String[] args) {
        // 测试排序算法辅助函数
        int N = 20000;
//        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        Integer[] arr = SortTestHelper.generateNearlyOrderedArray(10000, 10);
        Integer[] arrCopy = Arrays.copyOf(arr, arr.length);
//        SelectionSort.sort(arr);
        SortTestHelper.testSort(SelectionSort.class, "sort", new Class[]{Comparable[].class}, new Object[]{arr});
        SortTestHelper.printArray(arr);
        SortTestHelper.testSort(InsertionSort.class, "sort", new Class[]{Comparable[].class}, new Object[]{arrCopy});
        SortTestHelper.printArray(arrCopy);
    }
}
