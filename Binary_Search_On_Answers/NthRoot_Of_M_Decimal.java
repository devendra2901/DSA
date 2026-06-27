
public class NthRoot_Of_M_Decimal
{
    static double NthRoot(int n,int m){
        double low = 1, high=m;
        double eps = 1e-6;  //We need accuracy over 5 decimal places
        
        while((high-low)>eps){
            double mid = (low+high)/2.0;
            
            double val = multiply(mid,n);
            
            if(val < m)
                 low = mid;
            else
                high = mid;
        }
        return low;
    }
    static double multiply(double x,int n) //x^n
    {
        double ans = 1.0;
        for(int i=1;i<=n;i++){
            ans = ans *x;
        }
        return ans;
    }   
    
	public static void main(String[] args) {
		System.out.println(NthRoot(3,9));
	}
}
