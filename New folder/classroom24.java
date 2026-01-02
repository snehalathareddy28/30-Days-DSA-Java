//minvalue and maxvalue in  each subarray with priorityQueue
import java.util.*;
class classroom24{
public static ArrayList<ArrayList<Integer>> minsub(int a[],int n,int k){
ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
PriorityQueue<Integer> pq1 = new PriorityQueue<>();
PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
for(int i=0;i<k;i++){
pq1.add(a[i]);
pq2.add(a[i]);
}
ArrayList<Integer> arr1 = new ArrayList<>();
arr1.add(pq1.peek());
arr1.add(pq2.peek());
arr.add(arr1);
for(int i=1;i<n-k+1;i++){
pq1.add(a[i+k-1]);
pq2.add(a[i+k-1]);
pq1.remove(a[i-1]);
pq2.remove(a[i-1]);
ArrayList<Integer> temp = new ArrayList<>();
temp.add(pq1.peek());
temp.add(pq2.peek());
arr.add(temp);
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
ArrayList<ArrayList<Integer>> result = minsub(arr,n,3);
System.out.println("min amd max values:"+ result);
}
}