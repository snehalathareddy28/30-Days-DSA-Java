//diffreances between maxvalue and minvalue in subarray brute force
import java.util.*;
public class classroom19{
public static int[] sum(int a[],int k,int n){
int max = 0;
int min = 0;
int arr[] = new int[n-k+1];
for(int i=0;i<=n-k;i++){
max = Integer.MIN_VALUE;
min = Integer.MAX_VALUE;
for(int j=i;j<i+k;j++){
max = Math.max(max,a[j]);
min = Math.min(min,a[j]);
}
arr[i] = max-min;
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
System.out.println("max: " + Arrays.toString(result));
}
}
