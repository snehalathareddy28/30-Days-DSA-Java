//finding first negative value in subarray
import java.util.*;
public class classroom18{
public static int[] sum(int a[],int k,int n){
int sum = 0;
int x = 0;

int arr2[] = new int[n-k+1];
for(int i=0;i<=n-k;i++){
sum = 0;
x = -1;
int arr[] = new int[n-k+1];
for(int j=i;j<k+1;j++){
if(a[j]<0)
{
x++;
arr[x] = a[j];
}
}
arr2[i] = arr[0];
}

return arr2;
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
System.out.println("first negative values" +Arrays.toString(result));
}
}
