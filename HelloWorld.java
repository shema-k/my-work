import java.util.Scanner;

public class HelloWorld {
    public static void  main(String[] args) {
    String[] words = {"Shema", "Starrr", "Kevine", "Shtarrr"};
    //starts with sh
    for(String w : words){
        if (w.startsWith("Sh")){
            System.out.println(w + " starts with sh.");
        }
    }
    //ends with rrr
    for(String w: words){
        if(w.endsWith("rrr")){
            System.out.println(w + " ends with rrr");
        }
    }
    //finding index of strings or finding substrings in strings
    String s= "shemakevineshemakevineshemakevineshemakevine";
    System.out.println(s.indexOf("v")); //returns index showing the first instance of v
    //if you put a substring that is not in the string, it returns a -1 or false
    System.out.println(s.indexOf("v",10)); //returns index of the first instance of v excluding the first 10 letters
    System.out.println(s.indexOf("kevine")); //returns index of the first letter of the substring

   String m ="Shema";
   String k ="Kevine";
   System.out.println(m.replace("S", "X")); //replacing characters
   System.out.println(k.toUpperCase()); //to uppercase
   System.out.println(k.replace("i", "rrrrr").toUpperCase());

}}
    
    


 