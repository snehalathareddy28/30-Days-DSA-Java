//count mul of subsrting less than target brute froce
import java.util.*;
class variableSW7{
public static int count(int arr[],int target,int n){
int mul = 0;
int res = 0;
for(int i=0;i<n;i++){
mul = 0;
for(int j=i;j<n;j++){
mul *= arr[j];
if(mul<target){
res++;
}
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