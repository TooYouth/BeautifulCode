package Sort;

import java.util.Arrays;

/*���������㷨
 * */
@SuppressWarnings("hiding")
public class Quicksort<T extends Comparable<? super T>> {
	 
	public static void main(String[] args) {
		int n = 1000;
		QSort1<?> mQSort1 = new QSort1();
		long current = System.currentTimeMillis();
		Arrays.sort(getData(n));
		System.out.println(System.currentTimeMillis() -current);
		current = System.currentTimeMillis();
		mQSort1.sort(getData(n),0,n-1);
		System.out.println(System.currentTimeMillis() -current);
	}
	
	public static Integer[] getData(int n){
		Integer data[] = new Integer[n];
		for(int i= n;i>0;i--){
			data[i-1] = i;
		}
		return data;
	}
	
	@SuppressWarnings("hiding")
	interface QSort<T>{
		public <T extends Comparable<T>> T[] sort(T[] t,int p,int r);
		public <T extends Comparable<T>> int partition(T[] t,int p,int r);
	}
	
	@SuppressWarnings("hiding")
	static class QSort1<T extends Comparable<T>> implements QSort<T>{
		
		//��Ͷ˵Ŀ��ţ��ᱬջ���ٶȾ�Ȼ��ϵͳ������1000��
		public <T extends Comparable<T>> T[] sort(T[] t, int p, int r) {
			int q;
			if(p < r){
				q = partition(t,p,r);
				sort(t,p,q-1);
				sort(t,q+1,r);
			}
			return t;
		}
		@Override
		public <T extends Comparable<T>> int partition(T[] t, int p, int r) {
			T temp;
			T x = t[r];
			int i = p -1;
			for(int j = p;j<r-1;j++){
				if(t[j].compareTo(x) == 1){
					i++;
					temp = t[j];
					t[j] = t[i];
					t[i] = temp;
				}
			}
			temp = t[r];
			t[r] = t[i+1];
			t[i+1] = temp;
			return i+1;
		}
	}
}
