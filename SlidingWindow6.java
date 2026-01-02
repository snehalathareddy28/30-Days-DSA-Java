import java.util.*;
class SlidingWindow6 {
public static String check(String s) {
int n = s.length();
int maxLen = 0;
String longest = "";
for (int i = 0; i < n; i++) {
HashSet<Character> set = new HashSet<>();
for (int j = i; j < n; j++) {
char ch = s.charAt(j);
if (set.contains(ch)) {
break;
}
set.add(ch);
if (j - i + 1 > maxLen) {
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
