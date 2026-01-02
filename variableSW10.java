//count longest subsrting contains unique charecters sliding window

import java.util.*;
class variableSW10{
public static int count(String s,int n){
int arr[] = new int[26];
int res = 0;
int l=0,r=0;
while(r<n){
while(arr[s.charAt(r)-'a'] == 1){
arr[s.charAt(l)-'a'] = 0;
l++;
}
arr[s.charAt(r)-'a']=1;
int len = r-l+1;
res = Math.max(res,len);
r++;
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