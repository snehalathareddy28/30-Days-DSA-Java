//max values using sliding window with max heap
import java.util.*;
class classroom13{
public static int[] find(int a[],int n,int k){
PriorityQueue <Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
int arr[] = new int[n-k+1];
for(int i=0;i<k;i++){
pq.add(a[i]);
}
arr[0] = pq.peek();
for(int i=1;i<=n-k;i++){
pq.add(a[i+k-1]);
pq.remove(a[i-1]);
arr[i] = pq.peek();
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
int result[] = find(a,n,3);
System.out.println("max values: "+Arrays.toString(result));
}
}

