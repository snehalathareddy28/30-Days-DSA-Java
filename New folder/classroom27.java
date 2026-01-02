//count of zeros in substring HashMap
import java.util.*;
class classroom27{
public static int find(String arr,int n,int k){
int[] result = new int[n-k+1];
HashMap<Character,Integer> h = new HashMap<>();
for(int i=0;i<n;i++){
char ch = arr.charAt(i);
h.put(ch,h.getOrDefault(ch,0)+1);
}
for(Map.Entry<Character,Integer> en : h.entrySet()){
if(en.getKey()=='0'){
int sc = en.getValue();
return sc;
}
}
return -1;
}
public static void main(String...args){
Scanner sc = new Scanner(System.in);
System.out.println("enter the string");
String arr = sc.nextLine();
int n = arr.length();
int result = find(arr,n,3);
System.out.println("zero count:" +result);
}
}

