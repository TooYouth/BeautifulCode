package First;

/*�й���˧����
 * ����81�����
 * ��ȡ�Ĳ�����һ��������һ��ѭ��
 * i/9 �൱�ڲ���
 * i%9 �൱��ѭ��
 * �����3���ж��Ƿ���ͬһ��
 * */
public class Second {
	
	public static void main(String[] args) {
		
		byte i = 81;
		while(i-- > 0){
			if(i/9%3 == i%9%3) continue;
			System.out.println("A = "+(i/9+1)+" B = "+(i%9+1));
		}
	}
}
