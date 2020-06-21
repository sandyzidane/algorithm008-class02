# Week09 学习笔记

## 字符串
### 字符串基础问题
- https://leetcode-cn.com/problems/to-lower-case/
- https://leetcode-cn.com/problems/length-of-last-word/
- https://leetcode-cn.com/problems/jewels-and-stones/
- https://leetcode-cn.com/problems/first-unique-character-in-a-string/
- https://leetcode-cn.com/problems/string-to-integer-atoi/

### 字符串操作问题
- https://leetcode-cn.com/problems/longest-common-prefix/description/
- https://leetcode-cn.com/problems/reverse-string
- https://leetcode-cn.com/problems/reverse-string-ii/
- https://leetcode-cn.com/problems/reverse-words-in-a-string/
- https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
- https://leetcode-cn.com/problems/reverse-only-letters/

### 字符串异位词问题
- https://leetcode-cn.com/problems/valid-anagram/
- https://leetcode-cn.com/problems/group-anagrams/
- https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/

### 字符串回文串问题
- https://leetcode-cn.com/problems/valid-palindrome/
- https://leetcode-cn.com/problems/valid-palindrome-ii/
- https://leetcode-cn.com/problems/longest-palindromic-substring/

### 高级字符串算法
#### 最长子串、子序列问题
- [1143.最长公共子序列](https://leetcode-cn.com/problems/longest-common-subsequence/)
- [72.编辑距离](https://leetcode-cn.com/problems/edit-distance/)
- [5.最长回文子串](https://leetcode-cn.com/problems/longest-palindromic-substring/)

#### 字符串+DP问题
- [正则表达式匹配](https://leetcode-cn.com/problems/regular-expression-matching/)
- [正则表达式匹配的一个详细推导过程](https://leetcode-cn.com/problems/regular-expression-matching/solution/ji-yu-guan-fang-ti-jie-gen-xiang-xi-de-jiang-jie-b/)
- [44.通配符匹配](https://leetcode-cn.com/problems/wildcard-matching/)
- [115.不同的子序列](https://leetcode-cn.com/problems/distinct-subsequences/)

### 字符串匹配算法
- 算法介绍
  - Boyer-Moore 算法
    - [阮一峰的介绍](https://www.ruanyifeng.com/blog/2013/05/boyer-moore_string_search_algorithm.html)
    - [Wikipedia](https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_string-search_algorithm)
    - 我的总结
      - 被搜索文本：T
      - 搜索词：P
      - 用P的尾部而不是头部进行匹配
      - 在T中跳跃往前搜，而不是每个字符都检查一次
        - bad character rules
        - good suffix rules
	- [Sunday 算法](https://blog.csdn.net/u012505432/article/details/52210975)
	- [字符串匹配暴力法代码示例](https://shimo.im/docs/8G0aJqNL86wWrPUE)
	- [Rabin-Karp 代码示例](https://shimo.im/docs/1wnsM7eaZ6Ab9j9M)
	- [KMP 字符串匹配算法视频](https://www.bilibili.com/video/av11866460?from=search&seid=17425875345653862171)
	- [字符串匹配的 KMP 算法](http://www.ruanyifeng.com/blog/2013/05/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm.html)
- 字符串匹配相关题目
	- [387. 字符串中的第一个唯一字符](https://leetcode-cn.com/problems/first-unique-character-in-a-string/)
	- [8. 字符串转换整数 (atoi)](https://leetcode-cn.com/problems/string-to-integer-atoi/)
	- [541. 反转字符串 II](https://leetcode-cn.com/problems/reverse-string-ii/)
	- [151. 翻转字符串里的单词](https://leetcode-cn.com/problems/reverse-words-in-a-string/)
	- [557. 反转字符串中的单词 III](https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/)
	- [917. 仅仅反转字母](https://leetcode-cn.com/problems/reverse-only-letters/)
	- [438. 找到字符串中所有字母异位词](https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/)
	- [5. 最长回文子串](https://leetcode-cn.com/problems/longest-palindromic-substring/)
	- [205. 同构字符串](https://leetcode-cn.com/problems/isomorphic-strings/)
	- [680. 验证回文字符串 Ⅱ](https://leetcode-cn.com/problems/valid-palindrome-ii/)
	- [44. 通配符匹配](https://leetcode-cn.com/problems/wildcard-matching)
	- [32. 最长有效括号](https://leetcode-cn.com/problems/longest-valid-parentheses)
	- [115. 不同的子序列](https://leetcode-cn.com/problems/distinct-subsequences/)
