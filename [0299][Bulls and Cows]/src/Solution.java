//You are playing the following Bulls and Cows game with your friend: You write
//down a number and ask your friend to guess what the number is. Each time your fr
//iend makes a guess, you provide a hint that indicates how many digits in said gu
//ess match your secret number exactly in both digit and position (called "bulls")
// and how many digits match the secret number but locate in the wrong position (c
//alled "cows"). Your friend will use successive guesses and hints to eventually d
//erive the secret number.
//
// Write a function to return a hint according to the secret number and friend's
// guess, use A to indicate the bulls and B to indicate the cows.
//
// Please note that both secret number and friend's guess may contain duplicate
//digits.
//
// Example 1:
//
//
//Input: secret = "1807", guess = "7810"
//
//Output: "1A3B"
//
//Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.
//
// Example 2:
//
//
//Input: secret = "1123", guess = "0111"
//
//Output: "1A1B"
//
//Explanation: The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow.
//
//
// Note: You may assume that the secret number and your friend's guess only cont
//ain digits, and their lengths are always equal. Related Topics Hash Table


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String getHint(String secret, String guess) {

        // 假如参数不合法
        if (secret == null || guess == null || secret.length() != guess.length()) {
            throw new IllegalArgumentException("secret: " + secret + ", guess: " + guess);
        }

        Map<Integer, Character> indexMap = new HashMap<>();
        Map<Character, Integer> countMap = new HashMap<>();

        for (int i = 0; i < secret.length(); i++) {
            char c = secret.charAt(i);
            indexMap.put(i, c);
            countMap.put(c, 1 + countMap.getOrDefault(c, 0)); // 记录字符出现的次数
        }

        int bull = 0;
        int cows = 0;

        // 先计算bull
        for (int i = 0; i < guess.length(); i++) {
            char c = guess.charAt(i);
            if (indexMap.get(i) == c) {
                bull++;
                indexMap.remove(i); // 删除已经匹配过的位置
                countMap.put(c, countMap.get(c) - 1);
            }
        }

        // 再计算cows
        for (int i = 0; i < guess.length(); i++) {
            char c = guess.charAt(i);
            // 位置没有被匹配过，并且值大于0，说明猜测的值是有的，但是位置错误了
            if (indexMap.containsKey(i) && countMap.getOrDefault(c, 0) > 0) {
                cows++;
                countMap.put(c, countMap.get(c) - 1);
            }
        }

        return bull + "A" + cows + "B";
    }
}
//leetcode submit region end(Prohibit modification and deletion)
