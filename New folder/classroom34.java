//maxvalue in subarray deque
import java.util.*;
public class classroom34{
public static int[] sum(int a[],int k,int n){
int[] res = new int[n - k + 1];
Deque<Integer> dq = new LinkedList<>();
int idx = 0;
for (int i = 0; i < n; i++) {
while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
dq.removeFirst();
}
while (!dq.isEmpty() && a[dq.peekLast()] <= a[i]) {
dq.removeLast();
}
dq.addLast(i);
if (i >= k - 1) {
res[idx++] = a[dq.peekFirst()];
}
}
return res;
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
int result[] = sum(a,3,n);
System.out.println("max: " + Arrays.toString(result));
}
}
