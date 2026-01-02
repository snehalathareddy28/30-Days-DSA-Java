//sliding window using fixed size sliding window returns arraylist 
//logic two average
import java.util.*;
public class classroom11{
public static ArrayList<Integer> sum(int a[],int k,int n){
ArrayList<Integer> arr = new ArrayList<>();
int sum = 0;
for(int i=0;i<k;i++){
sum = sum + a[i];
}
arr.add(sum/k);
for(int j=k;j<n;j++){  //logic two
sum = sum+a[j];
sum = sum+a[j-k];
arr.add(sum/k);
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
