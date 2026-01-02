//method 1 bruteforce on String
import java.util.*;
class SlidingWindow3{
public static int check(String s){
int n = s.length();
int res = 0;
for(int i=0;i<n;i++){
boolean vis[] = new boolean[26];
for(int j=i;j<n;j++){
int idx = s.charAt(j)-'a';
if(vis[idx]==true){
break;
}
vis[idx] = true;
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