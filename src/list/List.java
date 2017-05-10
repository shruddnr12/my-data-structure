package list;

public interface List<E> {
	void add(E element);
	void add(int index, E element);
	E get(int index);
	E remove(int index); //반환형을 E로 하여 삭제하기 전에 한번 확인.
	void removeAll();
	int size();
	
}
