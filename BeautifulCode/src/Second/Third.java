package Second;
/*寻找水王
 * 可以看作是寻找一个超过总量一半的id的最简单的办法
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
