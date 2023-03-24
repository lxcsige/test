package design.pattern.prototype;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author liuxucheng
 * @since 2022/12/23
 */
public class DeepCopyDemo {

    /**
     * 快照
     */
    private HashMap<String, SearchWord> currentKeywords = new HashMap<>();

    /**
     * 最近一次更新时间
     */
    private long lastUpdateTime = -1;

    /**
     * 更新关键词数据快照
     */
    public void refresh() {
        // 查询最近更新的数据
        List<SearchWord> updatedWords = getSearchWords(lastUpdateTime);
        if (updatedWords == null || updatedWords.size() == 0) {
            return;
        }
        // shallow copy
        HashMap<String, SearchWord> newWords = (HashMap<String, SearchWord>) currentKeywords.clone();
        // 最近一次更新时间
        long maxUpdateTime = lastUpdateTime;
        for (SearchWord searchWord : updatedWords) {
            newWords.put(searchWord.keyword, searchWord);
            if (searchWord.lastUpdateTime > maxUpdateTime) {
                maxUpdateTime = searchWord.lastUpdateTime;
            }
        }
        // 更新
        currentKeywords = newWords;
        lastUpdateTime = maxUpdateTime;
    }

    /**
     * 查询更新时间在timestamp之后的数据
     *
     * @param timestamp
     * @return
     */
    private List<SearchWord> getSearchWords(long timestamp) {
        // TODO: 从数据库中取出更新时间>lastUpdateTime的数据
        return new ArrayList<>();
    }

    /**
     * 关键词检索信息类
     */
    private static class SearchWord {

        private String keyword;

        private int searchCnt;

        private long lastUpdateTime;

        public SearchWord(String keyword, int searchCnt, long lastUpdateTime) {
            this.keyword = keyword;
            this.searchCnt = searchCnt;
            this.lastUpdateTime = lastUpdateTime;
        }
    }
}
