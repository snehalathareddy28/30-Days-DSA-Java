// maxvalue and minvalue in subarray with brute force
import java.util.*;
public class classroom23{
public static ArrayList<ArrayList<Integer>> sum(int a[],int k,int n){
ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
int max = 0;
int min = 0;
for(int i=0;i<=n-k;i++){
max = Integer.MIN_VALUE;
min = Integer.MAX_VALUE;
for(int j=i;j<i+k;j++){
max = Math.max(max,a[j]);
min = Math.min(min,a[j]);
}
ArrayList<Integer> arr1 = new ArrayList<>();
arr1.add(min);
arr1.add(max);
arr.add(arr1);
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
ArrayList<ArrayList<Integer>> result = sum(a,3,n);

System.out.println("max: " + result);
}
}
