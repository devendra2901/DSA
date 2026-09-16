/*
    Problem  : Group Anagrams
    Given an array of strings strs, group the anagrams together. You can return the answer in any order.
*/

//Brute
/* 
    Idea : Verify each string pairs, valid anagrams or not
        -> If valid, add them to hashset and to the list
        -> When loop reaches to end of arr[] add curList to finalList
        -> Process the words which are not present in the hashSet 

    T.C = O(n^2 *k) , k is string length
    S.C = O(n)
*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;

        List<List<String>> res = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<n;i++){
            if(set.contains(strs[i]))
                continue;

            List<String> cur = new ArrayList<>(); 
            cur.add(strs[i]);
            set.add(strs[i]);

            for(int j=i+1;j<n;j++){
                if(validAnagrams(strs[i],strs[j])){
                    cur.add(strs[j]);
                    set.add(strs[j]);
                }
            }
            res.add(cur);
        }
        return res;
    }


    //Checks whether the given two strings are anagrams
    // T.C = 0(N), S.C = O(1)
    boolean validAnagrams(String s, String t){
        int n1 = s.length();
        int n2 = t.length();

        if(n1!=n2)
            return false;
        
        int count[] = new int[26];
        for(int i=0;i<n1;i++)
            count[s.charAt(i)-'a']++;
        
        for(int i=0;i<n2;i++)
            count[t.charAt(i)-'a']--;
        
        for(int i=0;i<26;i++)
            if(count[i]!=0)
                return false;
        return true;
    }
    
}

//Optimal
/* 
    Idea : HashMap + Frequency Signature
        -> For every string, generate frequencyCount[26].
        -> Convert frequencyCount[] into a unique key.
        -> Same frequency key indicates anagrams.
        -> Maintain a list of strings for each key.

    T.C = O(n*k), n->no. of strings and k->string length
    S.C = O(n*k), 
        Worst case, If there are no matching anagrams then map stores n groups each group of 1 string of length k.

    NOTE : Direct use of freqCount[] as key in hashmap does n't work bcoz in java arrays are compared based on references rather than content.
*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(String word:strs){
            int freqCount[] = frequencyCount(word);         //O(k)

            String key = Arrays.toString(freqCount);        //O(26)

            map.putIfAbsent(key, new ArrayList<>());        //O(1)
            map.get(key).add(word);                         //O(1)
        }

        List<List<String>> res = new ArrayList<>(map.values());

        return res;
    }
    
    //O(k) -> k is length of the string
    int[] frequencyCount(String s){
        int count[] = new int[26];      //S.C = O(26)

        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
        }

        return count;
    } 
}
