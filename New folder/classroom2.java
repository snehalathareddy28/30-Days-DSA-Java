//sliding window using fixed size sliding window returns arraylist
import java.util.*;
public class classroom2{
public static ArrayList<Integer> sum(int a[],int k,int n){
ArrayList<Integer> arr = new ArrayList<>();
int sum = 0;
for(int i=0;i<k;i++){
sum = sum + a[i];
}
arr.add(sum);
for(int j=1;j<n-k;j++){
sum = sum-a[j-1];
sum = sum+a[j+k-1];
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
System.out.println("Window sums: "+result);
}
}
