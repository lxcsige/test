package design.pattern.strategy;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuxucheng
 * @since 2023/1/9
 */
public class Sorter {

    private static final long GB = 1000 * 1000 * 1000;

    private final List<ISortAlg> sortAlgList = new ArrayList<>();

    private List<AlgRange> algRanges = new ArrayList<>();

    /**
     * Spring依赖注入
     */
    public Sorter() {
        sortAlgList.add(new QuickSort());
        sortAlgList.add(new ExternalSort());
        sortAlgList.add(new ConcurrentExternalSort());
        sortAlgList.add(new MapReduceSort());

        algRanges.add(new AlgRange(0, 6*GB, "quick"));
        algRanges.add(new AlgRange(6*GB, 10*GB, "external"));
        algRanges.add(new AlgRange(10*GB, 100*GB, "concurrentExternal"));
        algRanges.add(new AlgRange(100*GB, Long.MAX_VALUE, "mapReduceSort"));
    }

    @PostConstruct
    public void init() {
        Map<String, ISortAlg> sortAlgMap = new HashMap<>();
        for (ISortAlg sortAlg : sortAlgList) {
            SortAlg annotation = sortAlg.getClass().getAnnotation(SortAlg.class);
            if (annotation == null) {
                continue;
            }
            sortAlgMap.put(annotation.value(), sortAlg);
        }

        for (AlgRange algRange : algRanges) {
            algRange.alg = sortAlgMap.get(algRange.algName);
        }
    }

    public void sortFile(String filePath) {
        // 省略校验逻辑
        File file = new File(filePath);
        long fileSize = file.length();
        ISortAlg sortAlg = null;
        for (AlgRange algRange : algRanges) {
            if (algRange.inRange(fileSize)) {
                sortAlg = algRange.alg;
                break;
            }
        }
        if (sortAlg == null) {
            throw new IllegalArgumentException("");
        }
        sortAlg.sort(filePath);
    }

    static class AlgRange {

        private long start;

        private long end;

        private String algName;

        private ISortAlg alg;

        public AlgRange(long start, long end, String algName) {
            this.start = start;
            this.end = end;
            this.algName = algName;
        }

        public boolean inRange(long size) {
            return size >= start && size < end;
        }
    }
}
