import java.util.*;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-07 11:23
 **/
public class Solution {
    /**
     * <pre>
     * There are a total of n courses you have to take, labeled from 0 to n-1.
     *
     * Some courses may have prerequisites, for example to take course 0 you have to first take
     * course 1, which is expressed as a pair: [0,1]
     *
     * Given the total number of courses and a list of prerequisite pairs, is it possible for
     * you to finish all courses?
     *
     * Example 1:
     *
     * Input: 2, [[1,0]]
     * Output: true
     * Explanation: There are a total of 2 courses to take.
     *              To take course 1 you should have finished course 0. So it is possible.
     * Example 2:
     *
     * Input: 2, [[1,0],[0,1]]
     * Output: false
     * Explanation: There are a total of 2 courses to take.
     *              To take course 1 you should have finished course 0, and to take course 0 you should
     *              also have finished course 1. So it is impossible.
     * Note:
     *
     * The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read
     * more about how a graph is represented.
     * You may assume that there are no duplicate edges in the input prerequisites.
     *
     * 解题思路：
     * 使用深度度优先遍历，记录每个访问过的点，如果遍历过程中再次遍历到了已经访问过的点，
     * 说明有环状依赖，课程安排不合理
     * </pre>
     */

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 说明没有课程依赖
        if (prerequisites == null || prerequisites.length == 0) {
            return true;
        }


        Map<Integer, List<Integer>> dependencies = new HashMap<>();

        for (int[] arr : prerequisites) {
            List<Integer> val = dependencies.computeIfAbsent(arr[0], k -> new LinkedList<>());
            val.add(arr[1]);
        }

        boolean[] visit = new boolean[numCourses];
        Deque<Integer> path = new LinkedList<>();
        for (int i = 0; i < visit.length; i++) {
            if (!visit[i]) {
                if (!dfs(i, dependencies, visit, path)) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * 判断从i课程序开始，是否存在环
     *
     * @param course
     * @param dependencies
     * @param visit
     * @return
     */
    private boolean dfs(int course, Map<Integer, List<Integer>> dependencies, boolean[] visit, Deque<Integer> path) {
        List<Integer> dependency = dependencies.get(course);

        if (dependency == null) {
            return true;
        }

        if (path.contains(course)) {
            return false;
        }

        path.addLast(course);


        for (int i : dependency) {
            boolean result = dfs(i, dependencies, visit, path);
            if (!result) {
                return false;
            }
        }

        visit[course] = true;
        path.removeLast();

        return true;
    }
}
