import java.util.*;
class SlidingWindow7 {
public static String check(String s) {
int n = s.length();
int maxLen = 0;
String longest = "";
for(int i = 0; i < n; i++) {
HashMap<Character, Integer> hm = new HashMap<>();
for(int j = i; j < n; j++) {
char ch = s.charAt(j);

if(hm.containsKey(ch)) {
break;
}
hm.put(ch, 1);
int currLen = j - i + 1;
if(currLen > maxLen) {
maxLen = currLen;
longest = s.substring(i, j + 1);
}
}
}
return longest;
}
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
System.out.println("Enter a string:");
String str = sc.nextLine();
System.out.println("Longest substring: " + check(str));
}
}
