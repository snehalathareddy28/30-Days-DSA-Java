//maxvalue of subarrays sum 
import java.util.*;
public class classroom14{
public static int sum(int a[],int k,int n){
int sum = 0;
int max = 0;
for(int i=0;i<=n-k;i++){
sum = 0;
max = Integer.MIN_VALUE;
for(int j=i;j<k+i;j++){
sum = sum+a[j];
}
max = Math.max(max,sum);
}
return max;
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
int result = sum(a,3,n);
System.out.println("max: " + result);
}
}
