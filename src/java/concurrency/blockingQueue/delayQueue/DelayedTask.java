package concurrency.blockingQueue.delayQueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author liuxucheng
 * @since 2023/3/8
 */
public class DelayedTask implements Delayed {

    private String name;

    private long createTime;

    private long deadline;

    public DelayedTask(String name, long delay) {
        this.name = name;
        this.createTime = System.currentTimeMillis();
        this.deadline = delay + createTime;
    }

    public void process() {

    }

    /**
     * 剩余时间 = 到期时间 - 当前时间
     *
     * @param unit
     * @return
     */
    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(this.deadline - System.currentTimeMillis(),
                TimeUnit.MILLISECONDS);
    }

    /**
     * 升序
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(Delayed o) {
        return (int)(this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getDeadline() {
        return deadline;
    }

    public void setDeadline(long deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "DelayedTask{" +
                "name='" + name + '\'' +
                ", createTime=" + createTime +
                ", deadline=" + deadline +
                '}';
    }
}