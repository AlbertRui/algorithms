package me.heap.maxheap;

/**
 * @author AlbertRui
 * @date 2018-03-21 16:31
 */
@SuppressWarnings("ALL")
public class MaxHeap<Item> {
    //堆中存储的元素
    private Item[] data;
    //元素个数
    private int count;

    /**
     * 构造一个空堆
     *
     * @param capacity
     */
    public MaxHeap(int capacity) {
        this.data = (Item[]) new Object[capacity + 1];
        this.count = 0;
    }

    /**
     * 返回堆中元素的个数
     *
     * @return
     */
    public int size() {
        return count;
    }

    /**
     * 判断堆是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return count == 0;
    }

    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<>(100);
        System.out.println(maxHeap.size());
    }
}
