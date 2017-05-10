package list;

public class LinkedList<E> implements List<E> {
	private int size = 0;  // 연결리스트의 크기를 알기위해 for연산에 size를 증감 하는 방식은 시간복잡도가 n이 소모 됨으로 add할때 증가하는 식으로 만들기 위해 필드에 변수를 생성하여 시간복잡도를 1로 한 것이다. 
	private Node<E> head = null;
	private Node<E> tail = null;

	@Override
	public void add(E element) {
		Node<E> newNode = new Node<E>(element);
		if(head == null ){
			head = newNode;
			if(tail == null)
			tail = head;
		}
		else {
			Node<E> x = head;
			while(x.next != null){
				x = x.next;
			}
			x.next = newNode;
		}
		size++;
	}

	@Override
	public void add(int index, E element) {
		if(tail == null ){
			tail = head;
		}
		

		//1. 맨 앞 추가
		if(index == 0){
			Node<E> newNode = new Node<E>(element,head); 
			head = newNode;		
		}
		else if(size == index){
			add(element);
		}
		
		//2. 중간 추가
		else{	
			Node<E> x = head;
			for(int i = 0; i < index-1 ;i++){
				x = x.next;
			}	
			Node<E> newNode = new Node<E>(element,x.next);
			x.next = newNode;
			
		}
		size++;

	}

	@Override
	public E get(int index) {

		if(size <=index ){
			throw new IndexOutOfBoundsException("index: "+index +", size: "+size );
		}
		Node<E> x = head;
		for(int i = 0; i < index; i++){
			x = x.next;
		}
		return x.data;
	}

	@Override
	public E remove(int index) {
		//1. 맨 앞 삭제
		if(index == 0){
			Node<E> newNode = head; 
			head = head.next;		
			newNode.next = null;
		}
		//2. 중간 삭제
		else if(index <= size){	
			Node<E> x = head;
			for(int i = 0; i < index-1 ;i++){
				x = x.next;
			}	
			Node<E> newNode = x.next;
			x = newNode;
			newNode.next = null;
				
			
		}
		
		//3. 끝 삭제
		else{
			
		}
		
		size--;
		return null;
	}

	@Override
	public void removeAll() {
		for(Node<E> x = head; x != null;){
			Node<E> next = x.next;

			x.data = null;
			x.next = null;

			x = next;
		}
		head = null;
		size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	private static class Node<E>{  //인스턴스 내부클래스와 클래스 내부클래스. 생성하는데만 쓰기 때문에 현재 static이 없어도  무방하다. 바깥에서도 쓰고 싶다면 static을 빼면 된다. //위에 클래스에서 new Node().data = 10; 이렇게 가능. 
		private Node<E> next;
		private E data;

		private Node(E element){
			this.data = element;
			this.next = null;
		}

		private Node(E element, Node<E> next){
			this.data = element;
			this.next = next;
		}

	}

}
