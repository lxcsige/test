package design.pattern.prototype;

import java.io.Serializable;

/**
 * @author liuxucheng
 * @since 2022/12/23
 */
public class Coupon implements Serializable {

    private int id;

    private int discount;

    private long startTime;

    private long dueTime;

    public Coupon(int id, int discount, long startTime, long dueTime) {
        this.id = id;
        this.discount = discount;
        this.startTime = startTime;
        this.dueTime = dueTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getDueTime() {
        return dueTime;
    }

    public void setDueTime(long dueTime) {
        this.dueTime = dueTime;
    }
}
