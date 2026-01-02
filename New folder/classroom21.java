////minvalue in  each subarray with priorityQueue
import java.util.*;
class classroom21{
public static int[] minsub(int a[],int n,int k){
int arr[] = new int[n-k+1];
int min = 0;
PriorityQueue<Integer> pq = new PriorityQueue<>();
for(int i=0;i<k+1;i++){
pq.add(a[i]);
}
arr[0] = pq.peek();
for(int i=1;i<n-k+1;i++){
pq.add(a[i+k-1]);
pq.remove(a[i-1]);
arr[i] = pq.peek();
}
return arr;
}
public static void main(String...args){
Scanner sc = new Scanner(System.in);
System.out.println("enter size of your array");
int n = sc.nextInt();
int arr[] = new int[n];
System.out.println("enter elements array");
for(int i=0;i<n;i++){
arr[i] = sc.nextInt();
}
int result[] = minsub(arr,n,2);
System.out.println("min values:"+ Arrays.toString(result));
}
}