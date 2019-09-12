package test;
/**
 * @author 赫少华
 * @date 2019.9.12
 * @version 1.0
 * @param <E>泛型
 */
public class MyList02<E> {
	// 定义默认数组的长度
	private final int DEFAULT_SIZE = 10;
	// 定义默认数组
	private Object MyCreateList[];
	// 定义数组当前长度
	private int size = 0;

	// 无参构造方法
	public MyList02() {
		MyCreateList = new Object[DEFAULT_SIZE];
	}

	// 有参构造方法
	public MyList02(int lenth) {
		MyCreateList = new Object[lenth];
	}

	// 增加元素的方法
	public boolean add(E data) {
		if (size == MyCreateList.length) {
			grow();
		}
		MyCreateList[size++] = data;
		return true;
	}

	// 获取元素的方法
	public E get(int index) {
		if (indexout(index)) {
			return (E) MyCreateList[index];
		} else {
			return (E) "OUT OF INDEX";
		}

	}

	// Set方法
	public void set(E data, int index) {
		if (!indexout(index)) {
			System.out.println("數組越界！");
		}
		if (size == MyCreateList.length) {
			grow();
		}
		for (int i = size - 1; i >= index; i--) {
			/*
			 * System.out.println(MyCreateList[i+1]); System.out.println(MyCreateList[i]);
			 */
			MyCreateList[i + 1] = MyCreateList[i];
			/*
			 * System.out.println(MyCreateList[i+1]); System.out.println(MyCreateList[i]);
			 */
		}
		MyCreateList[index] = data;
		size++;
	}

	// 删除元素的方法(通过索引)
	public int remove(int index) {
		if (!indexout(index));
		for (int i = index; i <= size - 1; i++) {
			MyCreateList[i] = MyCreateList[i + 1];
		}
		MyCreateList[size] = null;
		size--;
		return -1;

	}

	// 删除元素（通过内容）
	public int elmremove(E data) {

		for (int i = 0; i < size; i++) {
			if (data.equals(MyCreateList[i])) {
				return remove(i);
			}
		}
		return -1;
	}
	//判断是否为空
	public boolean isempty() {
		return size==0? true:false;
	}
	//获取列表长度
	public int size() {
		return size;
	}
	// 判断数组是否越界
	public boolean indexout(int index) {
		if (index >= 0 && index < size) {
			return true;
		} else {
			throw new RuntimeException("索引不合法！" + index);
		}
	}

	// 数组扩容的方法
	private void grow() {
		Object MyNewCreateList[] = new Object[(MyCreateList.length + (MyCreateList.length / 2))];
		System.arraycopy(MyCreateList, 0, MyNewCreateList, 0, MyCreateList.length);
		MyCreateList = MyNewCreateList;

	}

	public String toString() {
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < size; i++) {

			if (i == size - 1) {
				sb.append(MyCreateList[i]);
			} else {
				sb.append(MyCreateList[i]);
				sb.append(",");
			}

		}
		return ("[" + sb + "]");

	}

	public static void main(String[] args) {
		MyList02<String> my = new MyList02<String>();
		my.add("a");
		my.add("b");
		my.add("c");
		my.add("d");
		my.add("e");
		System.out.println(my);
		System.out.println(my.get(1));
		my.set("hello", 1);
		System.out.println(my);

		my.remove(1);
		System.out.println(my);

		my.elmremove("c");
		System.out.println(my);
		System.out.println(my.isempty());
		System.out.println(my.size());
	}
}
