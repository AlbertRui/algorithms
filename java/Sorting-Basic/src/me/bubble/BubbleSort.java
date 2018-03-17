package me.bubble;

/**
 * 冒泡排序法
 *
 * @author AlbertRui
 * @date 2018-03-17 18:51
 */
public class BubbleSort {
    public <T extends Comparable<T>> void bubbleBasic(T[] arr) {
        System.out.println("==========经典冒泡排序法，升序============");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    swap(arr, j, j - 1);
                }
            }
        }
    }

    /**
     * 对其进行优化，设置一个标志，如果这一趟发生了交换，则为true，否则为false。 明显如果有一趟没有发生交换，说明排序已经完成。
     *
     * @param arr
     * @param <T>
     */
    public <T extends Comparable<T>> void bubbleBasic2(T[] arr) {
        System.out.println("==========优化的冒泡排序法，升序============");
        boolean flag = true;
        int k = arr.length;
        while (flag) {
            flag = false;
            for (int i = 1; i < k; i++) {
                if (arr[i].compareTo(arr[i - 1]) < 0) {
                    swap(arr, i, i - 1);
                    flag = true;
                }
            }
            k--;
        }
    }

    /**
     * 最优冒泡排序法，升序 做进一步的优化。如果有100个数的数组，仅前面10个无序，后面90个都已排好序且都大于前面10个数字，
     * 那么在第一趟遍历后，最后发生交换的位置必定小于10，且这个位置之后的数据必定已经有序了，
     * 记录下这位置，第二次只要从数组头部遍历到这个位置就可以了。
     *
     * @param arr
     * @param <T>
     */
    public <T extends Comparable<T>> void bubbleBasic3(T[] arr) {
        System.out.println("==========最优冒泡排序法，升序============");
        int flag = arr.length;
        int k = 0;
        while (flag > 0) {
            k = flag;
            flag = 0;
            for (int i = 1; i < k; i++) {
                if (arr[i].compareTo(arr[i - 1]) < 0) {
                    swap(arr, i, i - 1);
                    flag = i;
                }
            }
        }
    }

    private <T extends Comparable<T>> void swap(T[] arr, int j, int i) {
        T temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
