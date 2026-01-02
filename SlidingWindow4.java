//method 2 brute using hashmap
import java.util.*;
class SlidingWindow4{
public static int check(String s){
int n = s.length();
int res = 0;
for(int i=0;i<n;i++){
HashMap<Character,Boolean> hm = new HashMap<>();
for(int j=i;j<n;j++){
char ch = s.charAt(j);
if(hm.containsKey(ch)){
break;
}
hm.put(ch,true);
res = Math.max(res,j-i+1);
}
}
return res;
}
public static void main(String...args){
Scanner sc = new Scanner(System.in);
System.out.println("enter a string ");
String str = sc.nextLine();
System.out.println(check(str));
}
}