package Second;
/*Ѱ��ˮ��
 * ���Կ�����Ѱ��һ����������һ���id����򵥵İ취
 * */
public class Third <T>{
	
	public static void main(String[] args) {
		
		String s[] = {"123","123","234","2345","123","3456","234","123","123","2345","123"};
		System.out.println(find(s));
	}
	
	public static <T> T find(T[] t){
		T res = null;
		if(t != null){
			int count = 0;
			for(int i=0;i<t.length;i++){
				if(count==0){
					count++;
					res = t[i];
				}else{
					if(res.equals(t[i])){
						count++;
					}else{
						count--;
					}
				}
			}
		}
		return res;
	}
}
