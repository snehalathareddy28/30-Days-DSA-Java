//count mul of subsrting less than target sliding window 
import java.util.*;
class variableSW8{
public static int count(int arr[],int target,int n){
int mul = 0;
int res = 0;
Map<Integer,Integer> hm = new HashMap<>();
for(int i=0;i<n;i++){
mul *= arr[i];
if(mul<target){
res++;
}
else if(hm.containsKey(mul/target))
{
int l = i-hm.get(mul/target+1);
res = l;
}
if(!hm.containsKey(mul)){
hm.put(mul,i);
}
}
return res;
}
public static void main(String...args){
Scanner sc = new Scanner(System.in);
System.out.println("enter the array size");
int n = sc.nextInt();
int arr[] = new int[n];
System.out.println("enter elements in array");
for(int i=0;i<n;i++){
arr[i] = sc.nextInt();
}
System.out.println("enter target value");
int target = sc.nextInt();
System.out.println(count(arr,target,n));
}
}