//count sum of subsrting equal target
import java.util.*;
class variableSW{
public static int count(int arr[],int target,int n){
int sum = 0;
int res = 0;
for(int i=0;i<n;i++){
sum = 0;
for(int j=i;j<n;j++){
sum += arr[j];
if(sum==target){
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