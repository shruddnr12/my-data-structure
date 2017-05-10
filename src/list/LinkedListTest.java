package list;

public class LinkedListTest {

	public static void main(String[] args) {
	List<Integer> list = new LinkedList<Integer>();
		
		//add연산
		list.add(11);
		list.add(22);
		list.add(22);
		list.add(33);
		list.add(44);
		list.add(44);
	

		//size 연산
		int count = list.size();
		System.out.println("리스트 크기: " + count);
		
		//get 연산 테스트
		for(int i = 0 ; i < count ; i++){
			System.out.println(i + "번째 항목: " + list.get(i));
		}
		//removeAll 연산 테스트
		list.removeAll();
		
		//size 연산
		count = list.size();
		System.out.println("리스트 크기: " + count);

		//exception 테스트
		try{
		System.out.println(list.get(0));  // exception이 나는게 맞는 경우이다.모든 인덱스를 초기화 하였으니 IndexOutOfBoundsException에 해당한다.
		}
		catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
	}

}
