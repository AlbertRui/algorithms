package me.select.generate;

/**
 * @author AlbertRui
 * @date 2018-03-17 15:33
 */
public class SortTestHelper {
    /**
     * 生成一个包含n个元素的随机数。随机范围在[rangeL, rangeR]
     *
     * @param n
     * @param rangeL
     * @param rangeR
     */
    public static Integer[] generateRandomArray(Integer n, Integer rangeL, Integer rangeR) {
        // SortTestHelper不允许产生任何实例

        // 生成有n个元素的随机数组,每个元素的随机范围为[rangeL, rangeR]

        assert rangeL <= rangeR;

        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * (rangeR - rangeL + 1) + rangeL);
        }
        return arr;

    }

    private SortTestHelper() {
    }

    /**
     * 打印arr数组的所有内容
     *
     * @param arr
     */
    public static void printArray(Object arr[]) {

        for (Object anArr : arr) {
            System.out.print(anArr);
            System.out.print(' ');
        }
        System.out.println();

    }
}
