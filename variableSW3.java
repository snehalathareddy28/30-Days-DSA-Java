//count subsrting contains unique charecters brute froce
import java.util.*;
class variableSW3{
public static int count(String str,int n){
int sum = 0;
int res = 0;
for(int i=0;i<n;i++){
HashSet<Character> hs = new HashSet<>();
for(int j=i;j<n;j++){
hs.add(str.charAt(j));
if(hs.size()==j-i+1){
res++;
}
}
}
return res;
}
public static void main(String...args){
Scanner sc = new Scanner(System.in);
System.out.println("enter the string");
String str = sc.nextLine();
int n = str.length();
System.out.println(count(str,n));
}
}