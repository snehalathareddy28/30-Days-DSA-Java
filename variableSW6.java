//anagram in string p contains in string p print first indices 
//sliding window
import java.util.*;
class variableSW6{
public static List<Integer> count(String s,String p){
List<Integer> res = new ArrayList<>();
int n = s.length();
int m = p.length();
if(m>n)
return res;
int c1[] = new int[26];
int c2[] = new int[26];
for(int i=0;i<m;i++){
c1[s.charAt(i)-'a']++;
c2[s.charAt(i)-'a']++;
}
if(Arrays.equals(c1,c2)){
res.add(0);
}
for(int i=m;i<n;i++){
c1[s.charAt(i)-'a']++;
c1[s.charAt(i-m)-'a']--;
if(Arrays.equals(c1,c2)){
res.add(i-m+1);
}
}
return res;
}
public static void main(String...args){
Scanner sc = new Scanner(System.in);
System.out.println("enter the string s");
String str1 = sc.nextLine();
System.out.println("enter the string p");
String str2 = sc.nextLine();
System.out.println(count(str1,str2));
}
}