// Problem : Two Sum

//Brute :
//Idea : Using nexted loop
//T.C : O(n^2)  //S.c : O(1)
class Solution {
    public int[] twoSum(int[] arr, int target) {
        int n = arr.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i]+arr[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }
}



//Optimal :
//Idea : Using HashMap
//To search whether the required (target-arr[i]) is already visited.
//If yes, return [previousIndex, curIndex]
//T.C : O(n) average //S.c : O(n)
class Solution {
    public int[] twoSum(int[] arr, int target) {
        int n = arr.length;

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.containsKey(target-arr[i]))
                return new int[]{map.get(target-arr[i]),i};
            
            map.put(arr[i],i);
        }

        return new int[]{-1,-1};
    }
}
