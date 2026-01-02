//distict value count in subarray brut force
import java.util.*;
class classroom16{
public static int[] find(int a[],int n,int k){
int sum = 0;
int arr[] = new int[n-k+1];
HashSet<Integer> h = new HashSet<>();
for(int i=0;i<k;i++){
sum=0;
for(int j=k;j<n;j++){
h.add(a[j]);
sum++;
}
arr[i]=sum;
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
System.out.println("distict value: "+Arrays.toString(result));
}
}

