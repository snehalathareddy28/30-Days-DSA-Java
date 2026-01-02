//sliding window fixed size using brute force
import java.util.*;
public class classroom{
public static int[] sum(int a[],int k,int n){
int sum = 0;
int arr[] = new int[n-k+1];
for(int i=0;i<n-k;i++){
sum = 0;
for(int j=i;j<k+i;j++){
sum = sum+a[j];
}
arr[i] = sum;
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
