package list;

public class ArrayListTest2 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		
		//add연산
		list.add(11);
		list.add(22);
		list.add(22);
		list.add(33);
	
		//list.add(0, 1);
		//list.add(2, 2);
		//list.add(4, 3);
		//list.add(6, 4);
		
		//list.remove(2);
		
		//size 연산
		int count = list.size();
		System.out.println("리스트 크기: " + count);

		

		//get 연산 테스트
		for(int i = 0 ; i < count ; i++){
			System.out.println(i + "번째 항목: " + list.get(i));
		}
		count = list.size();
		System.out.println("리스트 크기: " + count);
		
		//removeAll 연산 테스트
		list.removeAll();
		

		//exception 테스트
		try{
			
		//list.get(0);  // exception이 나는게 맞는 경우이다.모든 인덱스를 초기화 하였으니 IndexOutOfBoundsException에 해당한다.
		
		}
		catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
	}

}
