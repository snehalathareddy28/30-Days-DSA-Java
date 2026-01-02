//diffreances between maxvalue and minvalue in subarray priorityQueue
import java.util.*;
public class classroom32{
public static int[] sum(int a[],int k,int n){
PriorityQueue<Integer> pq1 = new PriorityQueue<>();
PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
int arr[] = new int[n-k+1];
for(int i=0;i<k;i++){
pq1.add(a[i]);
pq2.add(a[i]);
}
arr[0] = pq2.peek()-pq1.peek();
int idx = 1;
for(int j=k;j<n;j++){
int out = a[j - k];
pq1.remove(out);
pq2.remove(out);
pq1.add(a[j]);
pq2.add(a[j]);
arr[idx++] = pq2.peek()-pq1.peek();
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
