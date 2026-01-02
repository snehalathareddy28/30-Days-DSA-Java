//count longest subsrting contains unique charecters 
//with exactly  k charecters brute froce
import java.util.*;
class variableSW11{
public static int count(String str,int n,int k){
int maxLen = 0;
for(int i=0;i<n;i++){
HashSet<Character> hs = new HashSet<>();
for(int j=i;j<n;j++){
if(hs.contains(str.charAt(j))){
break;
}
hs.add(str.charAt(j));
int len = j-i+1;
if(len == k){
maxLen = Math.max(maxLen,j-i+1);
}
}
}
return maxLen;
}
public static void main(String...args){
Scanner sc = new Scanner(System.in);
System.out.println("enter the string");
String str = sc.nextLine();
int n = str.length();
System.out.println("enter k value");
int k = sc.nextInt();
System.out.println(count(str,n,k));
}
}