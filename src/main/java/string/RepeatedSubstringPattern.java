package string;

import java.util.regex.Pattern;

/*
* LeetCode 459. Repeated Substring Pattern
* https://leetcode.com/problems/repeated-substring-pattern/
*
* */
public class RepeatedSubstringPattern {
/*
* Repeated pattern string looks like PatternPattern, and the others like Pattern1Pattern2.
  Let's double the input string:
     PatternPattern --> PatternPatternPatternPattern
     Pattern1Pattern2 --> Pattern1Pattern2Pattern1Pattern2

  Now let's cut the first and the last characters in the doubled string:
     PatternPattern --> *atternPatternPatternPatter*
     Pattern1Pattern2 --> *attern1Pattern2Pattern1Pattern*

  It's quite evident that if the new string contains the input string, the input string is a repeated pattern string.
*
* */
    public static boolean repeatedSubstringPattern(String s) {
        return (s +s).substring(1, 2*s.length()-1).contains(s);
    }

    public static boolean repeatedSubstringPattern2(String s) {
        Pattern pat = Pattern.compile("^(.+)\\1+$"); //This \1+ causes repetitions
        return pat.matcher(s).matches();
    }

    /*
    * Rabin-Karp
      Rabin-Karp is a linear-time \mathcal{O}(N)O(N) string searching algorithm:
      Move a sliding window of length LL along the string of length NN.
      Check hash of the string in the sliding window.
     Find divisors

    Now the only problem is to find divisors of N. Let's iterate to the square root of N, and for each identified divisor i calculate the paired divisor N / i.
        Algorithm
        Deal with base cases: n <= 2.
        Iterate from \sqrt{n} to 1.
        For each divisor n % i == 0:
        Compute paired divisor n / i.
        Use Rabin-Karp to check substrings of the lengths l = i and l = n / i:
        Take as a reference hash first_hash the hash of the first substring of length l.
        Jump along the string with a step of length l while the hash of the current substring is equal to first_hash.
        If the hashes of all substrings along the way are equal, the input string consists of repeated patterns of length l. Return True.
    * */


}
/*
* Description
* Given a string s, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.



Example 1:

Input: s = "abab"
Output: true
Explanation: It is the substring "ab" twice.
Example 2:

Input: s = "aba"
Output: false
*
* */
