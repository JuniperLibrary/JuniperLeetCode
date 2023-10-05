package main.java.com.uin.leetcode_100.string.leetcode_1233;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1233. 删除子文件夹
 * 你是一位系统管理员，手里有一份文件夹列表 folder，你的任务是要删除该列表中的所有 子文件夹，并以 任意顺序 返回剩下的文件夹。
 * 如果文件夹folder[i]位于另一个文件夹folder[j]下，那么folder[i]就是folder[j]的 子文件夹 。
 * 文件夹的「路径」是由一个或多个按以下格式串联形成的字符串：'/'后跟一个或者多个小写英文字母。
 * 例如，"/leetcode"和"/leetcode/problems"都是有效的路径，而空字符串和"/"不是。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/remove-sub-folders-from-the-filesystem
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 输入：folder = ["/a","/a/b","/c/d","/c/d/e","/c/f"]
 * 输出：["/a","/c/d","/c/f"]
 * 解释："/a/b/" 是 "/a" 的子文件夹，而 "/c/d/e" 是 "/c/d" 的子文件夹。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/remove-sub-folders-from-the-filesystem
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {
    public static void main(String[] args) {
        removeSubfolders(new String[]{"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"});
    }

    public static List<String> removeSubfolders(String[] folder) {
        // 现将数组folder按照字典排序 然后遍历数组
        // 对于当前的文件夹f，如果他的长度大于等于答案数组中最后一个文件夹的长度，并且它的前缀包含答案数组的最后一个文件夹再加上一个 /
        // 则说明f是答案数组中最后一个文件夹的子文件夹，我们不需要将其加入答案数组中
        // "/a","/a/b","/c/d","/c/d/e","/c/f"

        Arrays.sort(folder);
        List<String> ans = new ArrayList<>();
        // folder:["/a","/a/b","/c/d","/c/d/e","/c/f"]
        // ans:{["/a"]}
        ans.add(folder[0]);

        for (int i = 1; i < folder.length; i++) {
            int m = ans.get(ans.size() - 1).length();
            int n = folder[i].length();

            int size = ans.size();

            if (m >= n || !(ans.get(size - 1)).equals(folder[i].substring(0, m)) && folder[i].charAt(m) == '/') {
                ans.add(folder[i]);
            }
        }
        return ans;
    }
}
