/******************************************************************************

    Problem : Reverse Words in a String
    
    I/P: Hello World
    O/P : World Hello
         
    Note : Should n't use split()

*******************************************************************************/
public class ReverseWordsInAString
{
	public static void main(String[] args) {
		String s  = "Satti Devendra Adi Reddy";
		
		int n = s.length();
		String rev="";
		int end=n-1;
		for(start=end-1;start>=0;start--){
            if(s.charAt(start)==' '){
                rev += s.substring(start+1,end+1);
                rev += " "; 
                end = start-1;
            }
		}
		rev += s.substring(start+1,end+1);
		
		System.out.println(rev);
	}
}
