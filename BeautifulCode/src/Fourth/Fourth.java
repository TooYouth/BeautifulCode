package Fourth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*判断点是否在三角形内
 * 问题引申凸包问题
 **/
public class Fourth {

	public static void main(String[] args) {
		
		Point A = new Point();
		A.x = 1;
		A.y = 1;
		
		Point B = new Point();
		B.x = 5;
		B.y = 1;
		
		
		Point C = new Point();
		C.x = 3;
		C.y = 6;
		
		Point D = new Point();
		D.x = 2;
		D.y = 3;
		
		System.out.println(isInTriangleArea(A, B, C, D));
		System.out.println(isInTriangleProduct(A, B, C, D));
	}
	
	//下面是面积法
	//面积发面临的是精度问题，几乎没办法解决
	public static boolean isInTriangleArea(Point A,Point B,Point C,Point D){
		double abcArea = area(A,B,C);
		double abdArea = area(A,B,D);
		double adcArea = area(A,D,C);
		double dbcArea = area(D,B,C);
		System.out.println("abcArea : "+abcArea);
		System.out.println("abdArea : "+abdArea);
		System.out.println("adcArea : "+adcArea);
		System.out.println("dbcArea : "+dbcArea);
		if(abcArea == abdArea + adcArea + dbcArea){
			return true;
		}else{
			return false;
		}
	}
	//利用海伦公式求面积
	private static double area(Point A,Point B,Point C){
		double ab = distance(A, B);
		double ac = distance(A, C);
		double bc = distance(B, C);
		double p = (ab+ac+bc)/2;
		return Math.sqrt((p-ab)*(p-ac)*(p-bc)*p);
	}
	//两点间距离
	private static double distance(Point A,Point B){
		return Math.sqrt((A.x - B.x)*(A.x - B.x) +(A.y - B.y)*(A.y - B.y));
	}
	
	
	//下面是向量叉积方法
	//必须是逆时针方向
	public static boolean isInTriangleProduct(Point A,Point B,Point C,Point D){
		List<Point> list = getList( A, B, C);
		
//		for(int i = 0;i<list.size();i++){
//			System.out.println(list.get(i).x +"   "+list.get(i).y);
//		}
		if(product(list.get(0), list.get(1), D) >=0 && product(list.get(1), list.get(2), D)>=0 && product(list.get(2), list.get(0), D)>=0){
			return true;
		}
		return false;
	}
	
	
	//向量叉积
	private static double product(Point A,Point B,Point C){
		
		return Math.sqrt((B.x - A.x)*(C.y - A.y) - (C.x - A.x)*(B.y - A.y)) ;
		
	}
	
	private static List<Point> getList(Point A,Point B,Point C){
		List<Point> list = new ArrayList<Point>();
		list.add(A);
		list.add(B);
		list.add(C);
		Collections.sort(list);
		return list;
	}
	
	//为了得到逆时针序列
	static class Point implements Comparable<Point> {
		int x;
		int y;
		@Override
		public int compareTo(Point p) {
			if(p.x > this.x){
				return 1;
			}else if(p.x < this.x){
				return -1;
			}else{
				if(p.y> this.y){
					return 1;
				}else if(p.y < this.y){
					return -1;
				}else{
					return 0;
				}
			}
		}
	}
}

