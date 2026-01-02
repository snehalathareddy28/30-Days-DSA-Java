//using sliding window fixed size find max value
//brute force
import java.util.*;
class classroom12{
public static int[] max(int a[],int k,int n){
int arr[] = new int[n-k+1]; 
int max = 0;
for(int i=0;i<n-k+1;i++){
max = Integer.MIN_VALUE;
for(int j=0;j<k-1;j++){
max = Math.max(max,a[j]);
}
arr[i] = max;
}
return arr;
}
public static void main(String...args){
Scanner sc = new Scanner(System.in);
System.out.println("enter size of array");
int n = sc.nextInt();
int a[] = new int[n];
System.out.println("enter the array of elements");
for(int i=0;i<n;i++){
a[i] = sc.nextInt();
}
int result[] = max(a,3,n);
System.out.println("max: "+Arrays.toString(result));
}
}
