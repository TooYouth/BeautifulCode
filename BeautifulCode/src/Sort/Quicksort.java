package Sort;

import java.util.ArrayList;
import java.util.Arrays;

/*快速排序算法
 * */
@SuppressWarnings("hiding")
public class Quicksort<T extends Comparable<? super T>> {

	public static void main(String[] args) {
		int n = 100000;
		QSort<?> mQSort = new QSort();
		QSort<?> mQSort1 = new QSort1();
		QSort<?> mQSort2 = new QSort2();
		long current = System.currentTimeMillis();
		Arrays.sort(getData(n));
		System.out.println(System.currentTimeMillis() - current);
		Integer[] c = getData(n);
		current = System.currentTimeMillis();
		c = mQSort.sort(c, 0, n-1);
		System.out.println(System.currentTimeMillis() - current);
		Integer b [] = getData(n);
		current = System.currentTimeMillis();
		b = mQSort1.sort(b, 0, n-1 );
		System.out.println(System.currentTimeMillis() - current);
		current = System.currentTimeMillis();
		Integer a [] = getData(n);
		a = mQSort2.sort(a, 0, n-1);
		System.out.println(System.currentTimeMillis() - current);
	}

	public static <T> void outData(T[] a){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+"   ");
		}
		System.out.println();
		System.out.println();
		System.out.println();
	}
	public static Integer[] getData(int n) {
		Integer data[] = new Integer[n];
		for (int i = 0; i < n; i++) {
			data[i] = i;
		}
		return data;
	}
	

	static class QSort<T> {
		public <T extends Comparable<T>> T[] sort(T[] t, int p, int r) {
			int q;
			if (p < r) {
				q = partition(t, p, r);
				sort(t, p, q - 1);
				sort(t, q + 1, r);
			}
			return t;
		}

		// 最低端的快排，会爆栈
		public <T extends Comparable<T>> int partition(T[] t, int p, int r) {
			T temp;
			T x = t[r];
			int i = p - 1;
			for (int j = p; j <= r-1; j++) {
				if (t[j].compareTo(x) == 1) {
					i++;
					temp = t[j];
					t[j] = t[i];
					t[i] = temp;
				}
			}
			temp = t[r];
			t[r] = t[i + 1];
			t[i + 1] = temp;
			return i+1;
		}
	}

	// 优化了参照值得选法，依旧爆栈
	static class QSort1<T extends Comparable<T>> extends QSort<T> {

		@Override
		public <T extends Comparable<T>> int partition(T[] t, int p, int r) {
			T temp;
			int index = t[r].compareTo(t[p]) == 1 ? (t[r].compareTo(t[((r + p) / 2)]) == 1 ? (r + p) / 2
					: r)
					: (t[p].compareTo(t[((r + p) / 2)]) == 1 ? (r + p) / 2
							: p);
			T x = t[index];
			temp = t[index];
			t[index] = t[r];
			t[r] = temp;
			int i = p - 1;
			for (int j = p; j <=r-1; j++) {
				if (t[j].compareTo(x) == 1) {
					i++;
					temp = t[j];
					t[j] = t[i];
					t[i] = temp;
				}
			}
			temp = t[r];
			t[r] = t[i + 1];
			t[i + 1] = temp;
			return i + 1;
		}
	}

	// 自定义栈模拟递归,拒绝爆栈
	static class QSort2<T extends Comparable<T>> extends QSort1<T> {

		Stack<T> mStack = new Stack<T>();

		@Override
		public <T extends Comparable<T>> T[] sort(T[] t, int p, int r) {
			if (p < r) {
				int mid = partition(t, p, r);
				// 保存现场信息
				if(p<mid-1){
					mStack.push(p);
					mStack.push(mid-1);
				}
				if(mid+1 <r){
					mStack.push(mid+1);
					mStack.push(r);
				}
				while(mStack.size() > 0){
					int temp1 = mStack.pop();
					int temp2 = mStack.pop();
					//System.out.println("temp1 : "+temp1 + " temp2 : "+temp2);
					mid = partition(t, temp2,temp1);
					if(temp2 <mid-1){
						mStack.push(temp2);
						mStack.push(mid-1);
					}
					if(mid+1 <temp1){
						mStack.push(mid+1);
						mStack.push(temp1);
					}
				}
			}
			return t;
		}

		static class Stack<Integer>{
			ArrayList<Object> list = new ArrayList<Object>();
			
			public int pop() {
				int t = (int) list.remove(list.size() - 1);
				return t;
			}

			public void push(int p){
				list.add(list.size(),p);
			}
			
			public int size(){
				return list.size();
			}
		}
	}
}
