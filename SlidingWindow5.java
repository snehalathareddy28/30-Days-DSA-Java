//variable sliding window
import java.util.*;
class SlidingWindow5{
public static int check(String s){
int n = s.length();
int res = 0;
boolean vis[] = new boolean[26];
int l=0,r=0;
while(r<n){
while(vis[s.charAt(r)-'a']==true){
vis[s.charAt(l)-'a'] = false;
l++;
}
 vis[s.charAt(r)-'a']=true;
res = Math.max(res,r-1+1);
r++;
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