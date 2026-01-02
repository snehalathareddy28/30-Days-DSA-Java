//count sum of subsrting equal target sliding window froce
import java.util.*;
class variableSW2{
public static int count(int arr[],int target,int n){
int sum = 0;
int res = 0;
Map<Integer,Integer> hm = new HashMap<>();
for(int i=0;i<n;i++){
sum = sum+arr[i];
if(sum == target){
res++;
}
if(hm.containsKey(sum-target))
{
res = res+hm.get(sum-target);
}
hm.put(sum,hm.getOrDefault(sum,0)+1);
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