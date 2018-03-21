package BuilderTest;

import java.util.List;

/**
 * User: lxcfour
 * Date: 2018/3/12
 * Time: 上午11:10
 */
public class Query {

    private String queryType;

    private String dataSource;

    private String granularity;

    private List<String> dimensions;

    private Object filter;

    private String intervals;

    private String aggregations;

    private String postAggregations;

    public Query() {

    }

    public Query(Builder builder) {
        this.queryType = builder.queryType;
        this.dataSource = builder.dataSource;
        this.granularity = builder.granularity;
        this.dimensions = builder.dimensions;
        this.filter = builder.filter;
        this.intervals = builder.intervals;
        this.aggregations = builder.aggregations;
        this.postAggregations = builder.postAggregations;
    }

    public static class Builder {

        private String queryType;

        private String dataSource;

        private String granularity;

        private List<String> dimensions;

        private Object filter;

        private String intervals;

        private String aggregations;

        private String postAggregations;

        public Builder queryType (String queryType) {
            this.queryType = queryType;
            return this;
        }

        public Builder dataSource (String dataSource) {
            this.dataSource = dataSource;
            return this;
        }

        public Builder granularity (String granularity) {
            this.granularity = granularity;
            return this;
        }

        public Builder intervals (String intervals) {
            this.intervals = intervals;
            return this;
        }

        public Builder filter (Object filter) {
            this.filter = filter;
            return this;
        }

        public Builder dimensions (List<String> dimensions) {
            this.dimensions = dimensions;
            return this;
        }

        public Builder aggregations (String aggregations) {
            this.aggregations = aggregations;
            return this;
        }

        public Builder postAggregations (String postAggregations) {
            this.postAggregations = postAggregations;
            return this;
        }

        public Query build () {
            return new Query(this);
        }
    }
}
