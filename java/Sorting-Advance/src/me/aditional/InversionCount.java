package me.aditional;

import me.util.SortTestHelper;

import java.util.Arrays;

/**
 * 求一个数组中的逆序数对的个数
 *
 * @author AlbertRui
 * @date 2018-03-19 20:08
 */
public class InversionCount {

    // merge函数求出在arr[left...mid]和arr[mid+1...right]有序的基础上, arr[left...right]的逆序数对个数
    private static long merge(Comparable[] arr, int left, int mid, int right) {

        Comparable[] aux = Arrays.copyOfRange(arr, left, right + 1);

        // 初始化逆序数对个数 res = 0
        long res = 0L;
        // 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
        int i = left, j = mid + 1;
        for (int k = left; k <= right; k++) {

            if (i > mid) {  // 如果左半部分元素已经全部处理完毕
                arr[k] = aux[j - left];
                j++;
            } else if (j > right) {   // 如果右半部分元素已经全部处理完毕
                arr[k] = aux[i - left];
                i++;
            } else if (aux[i - left].compareTo(aux[j - left]) <= 0) {  // 左半部分所指元素 <= 右半部分所指元素
                arr[k] = aux[i - left];
                i++;
            } else {   // 右半部分所指元素 < 左半部分所指元素
                arr[k] = aux[j - left];
                j++;
                // 此时, 因为右半部分k所指的元素小
                // 这个元素和左半部分的所有未处理的元素都构成了逆序数对
                // 左半部分此时未处理的元素个数为 mid - i + 1
                res += (long) (mid - i + 1);
            }
        }

        return res;
    }

    // 求arr[left..right]范围的逆序数对个数
    // 思考: 归并排序的优化可否用于求逆序数对的算法? :)
    private static long solve(Comparable[] arr, int left, int right) {

        if (left >= right)
            return 0L;

        int mid = left + (right - left) / 2;
        // 求出 arr[left...mid] 范围的逆序数
        long res1 = solve(arr, left, mid);
        // 求出 arr[mid+1...right] 范围的逆序数
        long res2 = solve(arr, mid + 1, right);

        return res1 + res2 + merge(arr, left, mid, right);
    }

    public static long solve(Comparable[] arr) {

        int n = arr.length;
        return solve(arr, 0, n - 1);
    }

    // 测试 InversionCount
    public static void main(String[] args) {

        int N = 1000000;

        // 测试1: 测试随机数组
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        System.out.println("Test Inversion Count for Random Array, n = " + N + " :" + solve(arr));

        // 测试2: 测试完全有序的数组
        // 结果应该为0
        arr = SortTestHelper.generateOrderedArray(N);
        System.out.println("Test Inversion Count for Ordered Array, n = " + N + " :" + solve(arr));

        // 测试3: 测试完全逆序的数组
        // 结果应改为 N*(N-1)/2
        arr = SortTestHelper.generateInversedArray(N);
        System.out.println("Test Inversion Count for Inversed Array, n = " + N + " :" + solve(arr));


        return;
    }
}
