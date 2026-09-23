public class recurssion {
    public static void main (String[] args){
     System.out.println(fact(10));
    } 
    //we want to determine the factorial of 10
    public static long fact(long n){
        if (n ==1 || n== 0){
         return 1;
        }
        else
        return n* fact(n-1); 
    }
}
