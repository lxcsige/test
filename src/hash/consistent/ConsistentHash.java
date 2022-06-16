package hash.consistent;

import java.util.*;

/**
 * @author xucheng.liu
 * @since 2022/3/25
 */
public class ConsistentHash {

    /**
     * 集群地址列表
     */
    private static List<String> groups = new ArrayList<>();

    /**
     * 虚拟节点映射关系
     */
    private static SortedMap<Integer, String> virtualNodes = new TreeMap<>();

    private static final int VIRTUAL_NODE_NUM = 1000;

    static {
        groups.addAll(Arrays.asList("192.168.0.0:111", "192.168.0.1:111", "192.168.0.2:111",
                "192.168.0.3:111", "192.168.0.4:111"));

        // 将虚拟节点映射到Hash环上
        for (String realGroup: groups) {
            for (int i = 0; i < VIRTUAL_NODE_NUM; i++) {
                // 虚拟节点名，拼接后缀编号
                String virtualNodeName = getVirtualNodeName(realGroup, i);
                int hash = HashUtil.getHash(virtualNodeName);
                System.out.println("[" + virtualNodeName + "] launched @ " + hash);
                virtualNodes.put(hash, virtualNodeName);
            }
        }
    }

    /**
     * 根据真实节点名和编号映射到虚拟节点名
     *
     * @param realName
     * @param num
     * @return
     */
    private static String getVirtualNodeName(String realName, int num) {
        return realName + "&&VN" + num;
    }

    /**
     * 根据虚拟节点名找到真实节点名
     *
     * @param virtualName
     * @return
     */
    private static String getRealNodeName(String virtualName) {
        return virtualName.split("&&")[0];
    }

    private static String getServer(String key) {
        int hash = HashUtil.getHash(key);
        // 只取出所有大于该hash值的部分而不必遍历整个Tree
        SortedMap<Integer, String> subMap = virtualNodes.tailMap(hash);
        String virtualNodeName;
        if (subMap.isEmpty()) {
            // hash值在最尾部，应该映射到第一个group上
            virtualNodeName = virtualNodes.get(virtualNodes.firstKey());
        }else {
            virtualNodeName = subMap.get(subMap.firstKey());
        }
        return getRealNodeName(virtualNodeName);
    }

    /**
     * 当集群变动时，刷新hash环，其余的集群在hash环上的位置不会发生变动
     */
    private static void refreshHashCircle() {
        virtualNodes.clear();
        for (String realGroup: groups) {
            for (int i = 0; i < VIRTUAL_NODE_NUM; i++) {
                String virtualNodeName = getVirtualNodeName(realGroup, i);
                int hash = HashUtil.getHash(virtualNodeName);
                System.out.println("[" + virtualNodeName + "] launched @ " + hash);
                virtualNodes.put(hash, virtualNodeName);
            }
        }
    }

    /**
     * 新增节点
     *
     * @param identifier
     */
    private static void addGroup(String identifier) {
        groups.add(identifier);
        refreshHashCircle();
    }

    /**
     * 删除节点
     *
     * @param identifier
     */
    private static void removeGroup(String identifier) {
        int i = 0;
        for (String group : groups) {
            if (group.equals(identifier)) {
                groups.remove(i);
            }
            i++;
        }
        refreshHashCircle();
    }

    public static void main(String[] args) {
        // 生成随机数进行测试
        Map<String, Integer> resMap = new HashMap<>();

        for (int i = 0; i < 100000; i++) {
            String group = getServer(Integer.toString(i));
            if (resMap.containsKey(group)) {
                resMap.put(group, resMap.get(group) + 1);
            } else {
                resMap.put(group, 1);
            }
        }

        resMap.forEach(
                (k, v) -> System.out.println("group " + k + ": " + v + "(" + v/1000.0D +"%)")
        );
    }
}
