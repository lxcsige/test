package BuilderTest;

/**
 * User: lxcfour
 * Date: 2018/3/12
 * Time: 上午11:10
 */
public class Query {

    private String clientId;

    private String secret;

    private String query;

    private long timestamp;

    public Query() {
        this(new Builder());
    }

    Query(Builder builder) {
        this.clientId = builder.clientId;
        this.secret = builder.secret;
        this.query = builder.query;
        this.timestamp = builder.timestamp;
    }

    public static class Builder {

        private String clientId = "default";

        private String secret = "default";

        private String query = "";

        private long timestamp = 0L;

        public Builder clientId (String clientId) {
            this.clientId = clientId;
            return this;
        }

        public Builder secret (String secret) {
            this.secret = secret;
            return this;
        }

        public Builder query (String query) {
            this.query = query;
            return this;
        }

        public Builder timestamp (long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Query build () {
            return new Query(this);
        }
    }
}
