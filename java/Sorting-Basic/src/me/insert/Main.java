package me.insert;

import me.util.SortTestHelper;

/**
 * @author AlbertRui
 * @date 2018-03-17 17:20
 */
public class Main {
    public static void main(String[] args) {
        // 测试排序算法辅助函数
        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
//        SelectionSort.sort(arr);
        SortTestHelper.testSort(InsertionSort.class, "sort", new Class[]{Comparable[].class}, new Object[]{arr});
        SortTestHelper.printArray(arr);
    }
}
