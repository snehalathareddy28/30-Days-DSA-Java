//minvalue && maxvalue difference in subarray deque
import java.util.*;
public class classroom37{
public static ArrayList<ArrayList<Integer>> sum(int a[],int k,int n){
ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
Deque<Integer> dq = new LinkedList<>();
int idx = 0;
for (int i = 0; i < n; i++) {
while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
dq.removeFirst();
}
while (!dq.isEmpty() && a[dq.peekLast()] >= a[i]) {
dq.removeLast();
}
dq.addLast(i);
if (i >= k - 1) {
ArrayList<Integer> res1 = new ArrayList<>();
res1.add(a[dq.peekLast()]);
res1.add(a[dq.peekFirst()]);
arr.add(res1);
}
}
return arr;
};
public static void main(String...args)
{
Scanner sc = new Scanner(System.in);
System.out.println("enter size of array");
int n = sc.nextInt();
int a[] = new int[n];
System.out.println("enter the array of elements");
for(int i=0;i<n;i++){
a[i] = sc.nextInt();
}
ArrayList<ArrayList<Integer>> result = sum(a,3,n);
System.out.println("min: " +result);
}
}
