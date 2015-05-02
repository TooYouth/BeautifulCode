package Third;

import java.util.HashMap;

/*判断字符串的相似度
 * 手段：
 * 1，增加一个字符
 * 2，删除一个字符
 * 3，修改一个字符
 * 定义字符串之间的距离为：
 * 	距离等于使用手段的次数
 * 定义相似度：
 * 	相似度等于距离的倒数
 *
 **/
public class Third {
	
	public static void main(String[] args) {
		String str1 = "abcdefgdsadsadsa";
		String str2 = "abdecabfdsfasddadsadsadas";
		//System.out.println(getDistance(str1, 0, str1.length()-1, str2,0, str2.length()-1));
		//无耻的hash了
		HashMap <Integer,Integer> map = new HashMap<>();
		System.out.println(getDistance(str1, 0, str1.length()-1, str2,0, str2.length()-1,map));
	}
	
	//未保存重复递归
	public static int getDistance(String str1,int b1,int e1,String str2,int b2,int e2){
		//结束条件
		if(b1>e1){
			if(b2>e2){
				return 0;
			}else{
				return e2 - b2+1;
			}
		}
		
		if(b2 > e2){
			if(b1 > e1){
				return 0;
			}else{
				return e1-b1+1;
			}
		}
		
		//未结束
		if(str1.charAt(b1) == str2.charAt(b2)){
			return getDistance(str1,b1+1,e1,str2,b2+1,e2);
		}else{
			//可能是str2删除，插入
			int t1 = getDistance(str1,b1,e1,str2,b2+1,e2);
			//可能是str1删除，插入
			int t2 = getDistance(str1,b1+1,e1,str2,b2,e2);
			//可能是str1修改或者str2修改
			int t3 = getDistance(str1,b1+1,e1,str2,b2+1,e2);
			
			return (t1>t2?(t2>t3?t3:t2):(t1>t3?t3:t1))+1;
		}
	}
	
	
	
	//保存重复递归
	public static int getDistance(String str1,int b1,int e1,String str2,int b2,int e2,HashMap<Integer,Integer> map){
		//结束条件
		if(b1>e1){
			if(b2>e2){
				return 0;
			}else{
				return e2 - b2+1;
			}
		}
		
		if(b2 > e2){
			if(b1 > e1){
				return 0;
			}else{
				return e1-b1+1;
			}
		}
		
		//未结束
		if(str1.charAt(b1) == str2.charAt(b2)){
			int t;
			if(map.get((b1+1+(b2+1)*e1)) == null){
				//可能是str1删除，插入
				t = getDistance(str1,b1+1,e1,str2,b2+1,e2,map);
				map.put((b1+1+(b2+1)*e1),t);
			}else{
				t = map.get((b1+1+(b2+1)*e1));
			}
			return t;
		}else{
			int t1,t2,t3;
			
			if(map.get((b1+(b2+1)*e1)) == null){
				//可能是str2删除，插入
				t1 = getDistance(str1,b1,e1,str2,b2+1,e2,map);
				map.put((b1+(b2+1)*e1),t1);
			}else{
				t1 = map.get((b1+(b2+1)*e1));
			}
			
			
			
			if(map.get((b1+1+b2*e1)) == null){
				//可能是str1删除，插入
				t2 = getDistance(str1,b1+1,e1,str2,b2,e2,map);
				map.put((b1+1+b2*e1),t2);
			}else{
				t2 = map.get((b1+1+b2*e1));
			}
				
			if(map.get((b1+1+(b2+1)*e1)) == null){
				//可能是str1删除，插入
				t3 = getDistance(str1,b1+1,e1,str2,b2+1,e2,map);
				map.put((b1+1+(b2+1)*e1),t3);
			}else{
				t3 = map.get((b1+1+(b2+1)*e1));
			}
			return (t1>t2?(t2>t3?t3:t2):(t1>t3?t3:t1))+1;
		}
	}
	
}
