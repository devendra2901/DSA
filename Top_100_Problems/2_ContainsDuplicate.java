/*
  Problem : Contains Duplicate

  Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
*/

//Brute 
/*
    Idea : Nested Loops
        -> From every index, run a loop to verify cur ele is repeated or not.
    T.C : O(n^2) 
    S.C : O(1)
*/
class Solution {
    public boolean containsDuplicate(int[] arr) {
        int n = arr.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i]==arr[j])
                    return true;
            }
        }
        return false;
    }
}

//Optimal 
/*
    Idea : Frequency HashMap
        -> 1st loop : Create a frequencyHashMap
        -> 2nd loop : if map already contains the key, return true
    T.C : O(n) 
    S.C : O(n)
*/
class Solution {
    public boolean containsDuplicate(int[] arr) {
        int n = arr.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.containsKey(arr[i]))
                return true;
            map.put(arr[i],1);
        }
        return false;
    }
}
