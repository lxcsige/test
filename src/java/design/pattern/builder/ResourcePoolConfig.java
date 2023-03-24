package design.pattern.builder;

import java.util.concurrent.TimeUnit;

/**
 * @author liuxucheng
 * @since 2022/12/22
 */
public class ResourcePoolConfig {

    private String name;

    private int maxTotal;

    private int maxIdle;

    private int minIdle;

    private long maxIdleTime;

    private TimeUnit unit;

    /**
     * 私有构造函数
     *
     * @param builder
     */
    private ResourcePoolConfig(Builder builder) {
        this.name = builder.name;
        this.maxTotal = builder.maxTotal;
        this.maxIdle = builder.maxIdle;
        this.minIdle = builder.minIdle;
        this.maxIdleTime = builder.maxIdleTime;
        this.unit = builder.unit;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxTotal() {
        return maxTotal;
    }

    public void setMaxTotal(int maxTotal) {
        this.maxTotal = maxTotal;
    }

    public int getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(int maxIdle) {
        this.maxIdle = maxIdle;
    }

    public int getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(int minIdle) {
        this.minIdle = minIdle;
    }

    public long getMaxIdleTime() {
        return maxIdleTime;
    }

    public void setMaxIdleTime(long maxIdleTime) {
        this.maxIdleTime = maxIdleTime;
    }

    public TimeUnit getUnit() {
        return unit;
    }

    public void setUnit(TimeUnit unit) {
        this.unit = unit;
    }

    public static class Builder {

        private String name;

        private int maxTotal;

        private int maxIdle;

        private int minIdle;

        private long maxIdleTime;

        private TimeUnit unit;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder maxTotal(int maxTotal) {
            this.maxTotal = maxTotal;
            return this;
        }

        public Builder maxIdle(int maxIdle) {
            this.maxIdle = maxIdle;
            return this;
        }

        public Builder minIdle(int minIdle) {
            this.minIdle = minIdle;
            return this;
        }

        public Builder maxIdleTime(long maxIdleTime) {
            this.maxIdleTime = maxIdleTime;
            return this;
        }

        public Builder unit(TimeUnit unit) {
            this.unit = unit;
            return this;
        }

        public ResourcePoolConfig build() {
            return new ResourcePoolConfig(this);
        }
    }
}
