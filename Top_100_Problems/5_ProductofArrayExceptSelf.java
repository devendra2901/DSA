/*
  Problem : Product of Array Except Self

  Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

  You must write an algorithm that runs in O(n) time and without using the division operation.

   ********** SEE OPTIMAL SOLUTION *********************
*/
//Brute
/*
    Idea : Using Nested Loops
        -> Simply multiply every element except cur ele and store the result

    T.C : O(n^2)
    S.C : O(1)
*/
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] res = new int[n];
        for(int i=0;i<n;i++){
            int cur = 1;
            for(int j=0;j<n;j++){
                if(i==j) continue;

                cur = cur*nums[j];
            }
            res[i] = cur;
        }

        return res;
    }
}

//Better (Used division Operator)
/*
    Idea : Multiply and divide
        -> Multiply all ele's (except 0) and store the res.
        -> Maintain a count variable for zeroes
        -> If curEle is 0,
             If noOfZeroes <=1,
                means only one zero exists so place the multiplied value
             If noOfZeroes > 1,
                Entire res[] becomes zero
           If curEle is non-zero
             If noOfZeroes > 0,
                Entire res[] becomes zero except zero
             Otherwise
                res[i] = multipliedValue/nums[i];

    T.C : O(n) + O(n) = O(n)
    S.C : O(1)
*/
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        
        int multipliedValue = 1;
        int noOfZeroes = 0;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                noOfZeroes++;
            }else{
                multipliedValue = multipliedValue*nums[i];
            }
        }

        int[] res = new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]==0 ){
                if(noOfZeroes<=1) //Current zero is the only zero
                    res[i] = multipliedValue;
                else   //If noOfZeroes>1
                    res[i] = 0;
            }
            else { //nums[i]!=0 
                if(noOfZeroes>0){
                    res[i] = 0;
                }
                else{
                    res[i] = multipliedValue/nums[i];
                }
            }
        }

        return res;
    }
}

//Optimal (Without division operator)
/*
    Idea : PrefixProdct * suffixProduct
            pre[i]  = product of elements BEFORE i
            suff[i] = product of elements AFTER i
            
    Eg: arr  : [ 1   2  3  4]
        pre  : [ 1   1  2  6]
        suff : [24  12  4  1]

        res :  [24  12  8  6]

    T.C : O(n) + O(n) = O(n)
    S.C : O(1)
*/
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int res[] = new int[n];

        //Prefix Product
        int prefix = 1;

        for(int i=0;i<n;i++){
            res[i] = prefix;
            prefix *= nums[i];
        }

        //Suffix Product
        int suffix = 1;

        for(int i=n-1;i>=0;i--){
            res[i] *= suffix;
            suffix *= nums[i];
        }

        return res;
    }
}
