package me.select.entity;

/**
 * @author AlbertRui
 * @date 2018-03-17 15:04
 */
public class Student implements Comparable<Student> {

    private int score;
    private String name;

    public Student(String name, int score) {
        this.score = score;
        this.name = name;
    }


    /**
     * 分数高的排在前面
     * 分数相同按姓名首字母字典顺序
     *
     * @param other
     * @return
     */
    @Override
    public int compareTo(Student other) {
        if (this.score < other.score) {
            return 1;
        } else if (this.score > other.score) {
            return -1;
        } else {
            return this.name.compareTo(other.name);
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "score=" + score +
                ", name='" + name + '\'' +
                '}';
    }
}
