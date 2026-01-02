//variable sliding window  return array
import java.util.*;
class SlidingWindow1{
public static ArrayList<Integer> check(int a[],int n,int target){
int csum = 0;int st=0,end=0;
int res= 0;
ArrayList<Integer> r  = new ArrayList<>();
Map<Integer,Integer> hm = new HashMap<>();
for(int i=0;i<n;i++){
csum = csum+a[i];
if(csum == target){
res = i+1;
end=i;
st = st+1;
}
else if(hm.containsKey(csum-target)){
int len = i-hm.get(csum-target);
if(len>res)
{
res=len;
st=hm.get(csum-target);
end=i;
}
}
if(!hm.containsKey(csum)){
hm.put(csum,i);
}
}
for(int i=st;i<=end;i++){
r.add(a[i]);
}
return r;
}

public static void main(String...args){
int a[] = {-5,8,-14,2,4,12};
int n = a.length;
int k = -5;
System.out.println(check(a,n,k));
}
}