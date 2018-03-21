package me.heap.swim;

/**
 * 由下至上的堆有序化
 *
 * @author AlbertRui
 * @date 2018-03-21 16:31
 */
@SuppressWarnings("ALL")
public class MaxHeap<Item extends Comparable> {
    //堆中存储的元素
    protected Item[] data;
    //元素个数
    protected int count;
    protected int capacity;

    /**
     * 构造一个空堆
     *
     * @param capacity
     */
    public MaxHeap(int capacity) {
        this.data = (Item[]) new Comparable[capacity + 1];
        this.count = 0;
        this.capacity = capacity;
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

    /**
     * 在堆中插入一个元素
     *
     * @param item
     */
    public void insert(Item item) {
        //防止越界问题的发生
        assert (count < capacity);
        data[++count] = item;
        swim(count);
    }

    /**
     * 上浮操作
     *
     * @param k
     */
    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            swap(k / 2, k);
            k /= 2;
        }
    }

    /**
     * 交换两个元素的值
     *
     * @param i
     * @param j
     */
    private void swap(int i, int j) {
        Item temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    /**
     * 比较两个元素大小
     *
     * @param i
     * @param j
     * @return
     */
    private boolean less(int i, int j) {
        return data[i].compareTo(data[j]) < 0;
    }

    /**
     * 比较两个元素的大小，含等于
     *
     * @param i
     * @param j
     * @return
     */
    private boolean lessIgnore(int i, int j) {
        return data[i].compareTo(data[j]) > 0 ? false : true;
    }

    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<>(15);
        System.out.println(maxHeap.size());

        for (int i = 0; i < maxHeap.capacity; i++) {
            maxHeap.insert((int) (Math.random() * 100));
        }
    }
}
