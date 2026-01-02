//sliding window using fixed size sliding window
import java.util.*;
public class classroom1{
public static int[] sum(int a[],int k,int n){
int sum = 0;
int arr[] = new int[n-k+1];
for(int i=0;i<k;i++){
sum = sum + a[i];
}
arr[0] = sum;
for(int j=1;j<n-k;j++){
sum = sum-a[j-1];
sum = sum+a[j-k+1];
arr[j] = sum;
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
int result[] = sum(a,3,n);
System.out.println("Window sums: " + Arrays.toString(result));
}
}
