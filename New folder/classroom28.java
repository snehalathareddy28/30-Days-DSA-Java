//count of zeros in substring HashMap
import java.util.*;
class classroom28{
public static int[] find(String arr,int n,int k){

int[] result = new int[n-k+1];
TreeMap<Character,Integer> h = new TreeMap<>();

for(int i=0;i<k;i++){
char ch = arr.charAt(i);
h.put(ch,h.getOrDefault(ch,0)+1);
}
result[0] = h.getOrDefault('0',0);
int idx = 1;
for(int i=k;i<n;i++){
char ch = arr.charAt(i-k);
h.put(ch,h.get(ch)-1);
if(h.get(ch)==0){
h.remove(ch);
}
char in = arr.charAt(i);
h.put(in,h.getOrDefault(in,0)+1);
result[idx++] = h.getOrDefault('0',0);
}
return result;
}
public static void main(String...args){
Scanner sc = new Scanner(System.in);
System.out.println("enter the string");
String arr = sc.nextLine();
int n = arr.length();
int result[] = find(arr,n,3);
System.out.println("zero count:" +Arrays.toString(result));
}
}

