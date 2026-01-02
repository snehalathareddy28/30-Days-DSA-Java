//anagram in string p contains in string p print first indices brute froce
import java.util.*;
class variableSW5{
public static List<Integer> count(String s,String p){
List<Integer> res = new ArrayList<>();
int n = s.length();
int m = p.length();
if(m>n)
return res;
char p1[] = p.toCharArray();
Arrays.sort(p1);
for(int i=0;i<=n-m;i++){
String s1 = s.substring(i,i+m);
char s11[] = s1.toCharArray();
Arrays.sort(s11);
if(Arrays.equals(s11,p1)){
res.add(i);
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