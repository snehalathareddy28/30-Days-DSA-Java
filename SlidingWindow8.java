import java.util.*;
class SlidingWindow8{
public static String check(String s) {
int n = s.length();
int maxLen = 0;
String longest = "";
for(int i = 0; i < n; i++) {
for(int j = i; j < n; j++) {
HashMap<Character, Boolean> hm = new HashMap<>();
boolean isValid = true;
for(int k = i; k <= j; k++) {
char ch = s.charAt(k);
if(hm.containsKey(ch)) {
isValid = false;
break;
}
hm.put(ch, true);
}
if(isValid && (j - i + 1) > maxLen) {
maxLen = j - i + 1;
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
