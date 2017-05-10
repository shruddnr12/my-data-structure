package list;

public class ArrayList<E> implements List<E> {
	private static final int INIT_CAPACITY = 3;
	private int size;
	private E[] data;

	@SuppressWarnings("unchecked")
	public ArrayList(){
		size = 0; // 실제로 데이터 들어가 있는 갯수
		resize();
	}
	private void resize(){
		int capacity = (data == null) ? INIT_CAPACITY:data.length * 2;
		E[] temp = (E[])new Object[capacity*2];

		for(int i = 0; i < size; i ++){
			temp[i] = data[i];
		}

		data = temp;
	}
	@Override
	public void add(E element) {
		if(data.length <= size){
			resize();
		}
		data[size] = element;
		size++;
	}

	@Override
	public void add(int index, E element) {
		
		if(index <= size){
			resize();
		}
		
		//0 index가 연속적이지 않을때.
		if(data.length+1 == size && index > data.length){
			throw new IndexOutOfBoundsException("index: "+index +", size: "+size );
		}
		
		//1. 맨 앞 삽입 - 1)새로운 배열을 생성하고 옴긴다. 2) 한칸씩 다 뒤로 옴긴뒤 맨 앞에 넣는다. 
		if(index == 0){	
			E[] temp = (E[])new Object[size+1];
			for(int i = 1; i < size; i++){
				temp[i] = data[i-1];
			}
			temp[index] = element;			
			
			 data = temp;
			 size++;
		}
		//2.중간 삽입
		else if( index > 0 && index < size){
			E[] temp = (E[])new Object[size+1];
			for(int i = 0; i < index; i++){
				temp[i] = data[i];
			}
			
			temp[index] = element;
			
			for(int i = index; i < size; i++){
				temp[i+1] = data[i];
			}
			 data = temp;
			 size++;
		}
		
		//3.마지막 삽입
		else{
			E[] temp = (E[])new Object[size+1];
			for(int i = 0; i < size; i++){
				temp[i] = data[i];
			}
			temp[index] = element;
			data = temp;
			size++;
		}
			
	}

	@Override
	public E get(int index) {
		if(index == size){
			throw new IndexOutOfBoundsException("index: "+index +", size: "+size );
		}

		return data[index];
	}

	@Override
	public E remove(int index) {
		// 인덱스 범위 내의 데이터 제거
		if(index < size) {
			data[index] = null;
			
			for(int i = index; i <size; i++){
				E temp =  data[i+1];
				data[i+1] = data[i];
				data[i] = temp;
			}
			
			E[] temp = (E[])new Object[size-1];
			for(int i =0; i < size-1; i++){
				temp[i] = data[i];
			}
			data = temp;
			size--;
		}
		
		//인덱스 범위 외 데이터 제거
		else{
			throw new IndexOutOfBoundsException("해당인덱스가 존재 하지 않습니다. 적절치 못한 인덱스 제거 입니다." );
		}
		

		return data[index];
	}

	@Override
	public void removeAll() {
		for(int i=0; i < size; i++){ 
			data[i]	= null;
		}
		size = 0;
	}

	@Override
	public int size() {
		return size;
	}

}


//package list;
//
//public class ArrayList<E> implements List<E> {
//	private static final int INIT_CAPACITY = 10;
//	private int size;
//	private E[] data;
//	
//	@SuppressWarnings("unchecked")
//	public ArrayList(){
//		size = 0; // 실제로 데이터 들어가 있는 갯수
//		data = (E[])new Object[INIT_CAPACITY];  //제네릭 변수는  인스턴스화 할 수 없다.형변환을 통해 가능하다.
//	}
//	private void resize(){
//		int capacity= data.length;
//		E[] temp = (E[])new Object[capacity*2];
//		
//		for(int i = 0; i < size; i ++){
//			temp[i] = data[i];
//		}
//		
//		data = temp;
//	}
//	@Override
//	public void add(E element) {
//		if(data.length <= size){
//			resize();
//		}
//
//		
//	}
//
//	@Override
//	public void add(int index, E element) {
//	
//
//	}
//
//	@Override
//	public E get(int index) {
//
//		return null;
//	}
//
//	@Override
//	public E remove(int index) {
//
//		return null;
//	}
//
//	@Override
//	public void removeAll() {
//	
//
//	}
//
//	@Override
//	public int size() {
//	
//		return 0;
//	}
//
//}
