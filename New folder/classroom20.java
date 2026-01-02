//minvalue in  each subarray with bruteforce
import java.util.*;
public class classroom20{
public static int[] sum(int a[],int k,int n){int min = 0;
int arr[] = new int[n-k+1];
for(int i=0;i<=n-k;i++){
min = Integer.MAX_VALUE;
for(int j=i;j<i+k;j++){
min = Math.min(min,a[j]);
}
arr[i] = min;
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
System.out.println("min values in each subarray: " + Arrays.toString(result));
}
}
