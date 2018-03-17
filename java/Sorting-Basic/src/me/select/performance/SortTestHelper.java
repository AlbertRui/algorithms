package me.select.performance;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author AlbertRui
 * @date 2018-03-17 15:33
 */
public class SortTestHelper {

    // SortTestHelper不允许产生任何实例
    private SortTestHelper() {
    }

    /**
     * 生成一个包含n个元素的随机数。随机范围在[rangeL, rangeR]
     *
     * @param n
     * @param rangeL
     * @param rangeR
     */
    public static Integer[] generateRandomArray(Integer n, Integer rangeL, Integer rangeR) {
        // 生成有n个元素的随机数组,每个元素的随机范围为[rangeL, rangeR]

        assert rangeL <= rangeR;

        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * (rangeR - rangeL + 1) + rangeL);
        }
        return arr;

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

    /**
     * 判断arr数组是否有序
     *
     * @param arr
     */
    public static <T extends Comparable<T>> boolean isSorted(T[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1].compareTo(arr[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 测试sortClassName所对应的排序算法排序arr数组所得到结果的正确性和算法运行时间
     *
     * @param clazz
     * @param params
     */
    public static void testSort(Class<?> clazz, String methodName, Class<?>[] parameterTypes, Object[] params) {
        try {
            Method method = clazz.getMethod(methodName,parameterTypes);
            long startTime = System.currentTimeMillis();
            method.setAccessible(true);
            method.invoke(null, params);
            long endTime = System.currentTimeMillis();
            long time = endTime - startTime;
            System.out.println("The method " + methodName + " execution wtth " + time + "ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
