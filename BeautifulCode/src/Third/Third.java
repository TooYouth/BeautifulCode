package Third;

import java.util.HashMap;

/*�ж��ַ��������ƶ�
 * �ֶΣ�
 * 1������һ���ַ�
 * 2��ɾ��һ���ַ�
 * 3���޸�һ���ַ�
 * �����ַ���֮��ľ���Ϊ��
 * 	�������ʹ���ֶεĴ���
 * �������ƶȣ�
 * 	���ƶȵ��ھ���ĵ���
 *
 **/
public class Third {
	
	public static void main(String[] args) {
		String str1 = "abcdefgdsadsadsa";
		String str2 = "abdecabfdsfasddadsadsadas";
		//System.out.println(getDistance(str1, 0, str1.length()-1, str2,0, str2.length()-1));
		//�޳ܵ�hash��
		HashMap <Integer,Integer> map = new HashMap<>();
		System.out.println(getDistance(str1, 0, str1.length()-1, str2,0, str2.length()-1,map));
	}
	
	//δ�����ظ��ݹ�
	public static int getDistance(String str1,int b1,int e1,String str2,int b2,int e2){
		//��������
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
		
		//δ����
		if(str1.charAt(b1) == str2.charAt(b2)){
			return getDistance(str1,b1+1,e1,str2,b2+1,e2);
		}else{
			//������str2ɾ��������
			int t1 = getDistance(str1,b1,e1,str2,b2+1,e2);
			//������str1ɾ��������
			int t2 = getDistance(str1,b1+1,e1,str2,b2,e2);
			//������str1�޸Ļ���str2�޸�
			int t3 = getDistance(str1,b1+1,e1,str2,b2+1,e2);
			
			return (t1>t2?(t2>t3?t3:t2):(t1>t3?t3:t1))+1;
		}
	}
	
	
	
	//�����ظ��ݹ�
	public static int getDistance(String str1,int b1,int e1,String str2,int b2,int e2,HashMap<Integer,Integer> map){
		//��������
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
		
		//δ����
		if(str1.charAt(b1) == str2.charAt(b2)){
			int t;
			if(map.get((b1+1+(b2+1)*e1)) == null){
				//������str1ɾ��������
				t = getDistance(str1,b1+1,e1,str2,b2+1,e2,map);
				map.put((b1+1+(b2+1)*e1),t);
			}else{
				t = map.get((b1+1+(b2+1)*e1));
			}
			return t;
		}else{
			int t1,t2,t3;
			
			if(map.get((b1+(b2+1)*e1)) == null){
				//������str2ɾ��������
				t1 = getDistance(str1,b1,e1,str2,b2+1,e2,map);
				map.put((b1+(b2+1)*e1),t1);
			}else{
				t1 = map.get((b1+(b2+1)*e1));
			}
			
			
			
			if(map.get((b1+1+b2*e1)) == null){
				//������str1ɾ��������
				t2 = getDistance(str1,b1+1,e1,str2,b2,e2,map);
				map.put((b1+1+b2*e1),t2);
			}else{
				t2 = map.get((b1+1+b2*e1));
			}
				
			if(map.get((b1+1+(b2+1)*e1)) == null){
				//������str1ɾ��������
				t3 = getDistance(str1,b1+1,e1,str2,b2+1,e2,map);
				map.put((b1+1+(b2+1)*e1),t3);
			}else{
				t3 = map.get((b1+1+(b2+1)*e1));
			}
			return (t1>t2?(t2>t3?t3:t2):(t1>t3?t3:t1))+1;
		}
	}
	
}
