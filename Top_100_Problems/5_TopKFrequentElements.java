// //Better
// /*
//     Idea : HashMap + 2D Array Sorting
//         --> Use HashMap to store:
//            number -> frequency

//         -> Create a 2D with the same content as hashmap
//             a[][0] = value
//             a[][1] = corresponding frequency
//         -> Sort the array in descending order based on the frequency
//         -> create a res array and add the top k elements from a[][] into it

//     T.C : O(n) + O(m) + O(mlogm) + O(k) => O(nlogn) , At worst case (m=n)
//     S.C : O(m)+O(k)                     => O(n) , 
//         m is no.of unique elements 
// */
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int x:nums){
            map.put(x,map.getOrDefault(x,0)+1);
        }

        int[][] arr = new int[map.size()][2];
        int i=0;
        for(int x:map.keySet()){
            arr[i][0] = x;
            arr[i][1] = map.get(x);
            i++;
        }

        Arrays.sort(arr,(a,b)->b[1]-a[1]);

        int res[] = new int[k];

        for(int j=0;j<k;j++){
            res[j] = arr[j][0];
        }

        return res;
        
    }
}

// Optimal
/*
    Idea : HashMap + Bucket Sort

        --> Use HashMap to store:
            number -> frequency

        --> Maximum frequency of any element can be n.
            So create n+1 buckets where:

            bucket[1] -> elements with frequency 1
            bucket[2] -> elements with frequency 2
            ...
            bucket[n] -> elements with frequency n

        --> Multiple elements can have the same frequency,
            so each bucket stores a List<Integer>.

        --> Traverse buckets from n to 1 and
            pick elements until k elements are obtained.

    T.C : O(n) + O(m) + O(n)
        => O(n)

        n -> total number of elements
        m -> number of unique elements
        m <= n

    S.C : O(n) + O(m) + O(k)
        => O(n)

        Bucket array itself requires O(n) space.

    Key Idea:
        Frequency -> Bucket Index -> Traverse Backwards
*/
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int x:nums){                                        //O(n)
            map.put(x,map.getOrDefault(x,0)+1);
        }

        // Similar to:
        // int[] a = new int[n+1];
        //
        // Here each bucket stores multiple integers,
        // so each bucket is a List<Integer>.
        List<Integer>[] buckets = new List[nums.length+1];

        for(int x:map.keySet()){                               //O(m)
            int freq = map.get(x);

            if(buckets[freq]==null){
                buckets[freq] = new ArrayList<>();
            }

            buckets[freq].add(x);
        }

        int[] res = new int[k];
        int t = 0;
        for(int j=nums.length;j>=0;j--){                       //O(n)
            if(buckets[j]!=null){
                for(int x:buckets[j]){
                    res[t] = x;
                    t++;
                    if(t>=k) break;
                }
                if(t>=k) break;
            }
        }

        return res;
        
    }
}
