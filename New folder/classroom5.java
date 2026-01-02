//sliding window fixed size using brute force
import java.util.*;
public class classroom5{
public static ArrayList<Integer> sum(int a[],int k,int n){
int sum = 0;
ArrayList<Integer> arr = new ArrayList<>();
for(int i=0;i<n-k;i++){
sum = 0;
for(int j=i;j<k+i;j++){
sum = sum+a[j];
}
arr.add(sum);
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
ArrayList<Integer> result = sum(a,3,n);
System.out.println("Window sums: " +result);
}
}
