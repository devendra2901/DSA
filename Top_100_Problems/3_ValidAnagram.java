/*
   Problem : Valid Anagram

  Given two strings s and t, return true if t is an anagram of s, and false otherwise.

  An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, using all the original letters exactly once.

*/

//Brute
/*
    Idea : Sort and compare
        -> Sort both the given strings and compare character by character.

    T.C : O(2*nlogn) + O(n) => O(nlogn)
    S.C : O(2*n)            => O(n)
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();

        if(n1!=n2) return false;

        String sortedS = sortString(s);
        String sortedT = sortString(t);

        for(int i=0;i<n1;i++){
            if(sortedS.charAt(i)!=sortedT.charAt(i))
                return false;
        }
        return true;
    }

    String sortString(String s){
        char[] chars = s.toCharArray();

        Arrays.sort(chars);

        return new String(chars);
    }
}

//Optimal
/*
    Idea : charCount[] and compare
        -> +1 : for characters in 1st string
        -> -1 : for characters in 2nd string
        -> Finally, every count should be 0

    T.C : O(2*n)  => O(n)
    S.C : O(26) => O(1)

    NOTE : The given problem stated that the strings contians only lowercase english characters so arr of size 26 is enough, if it cotains unicode character then we need to use a HashMap.
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();

        if(n1!=n2) return false;

        int count[] = new int[26];
        for(int i=0;i<n1;i++){
            count[s.charAt(i)-'a']++;
        }

        for(int i=0;i<n2;i++){
            count[t.charAt(i)-'a']--;
        }
        
        for(int i=0;i<26;i++){
            if(count[i]!=0)
                return false;
        }

        return true;
    }
}
