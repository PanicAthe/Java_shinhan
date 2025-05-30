package com.shinhan.day11.t;

 
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.Vector;

public class CollectionTest {

	public static void main(String[] args) {
		f12();

	}
	
	private static void f12() {
		//Properties : Map인데 key,value가 String이다. 
		Properties pro = new Properties();
		
		InputStream is = CollectionTest.class.getResourceAsStream("../util/oracle.properties");
		try {
			pro.load(is);
			
			String driver = pro.getProperty("driver");
			String url = pro.getProperty("url");
			String userid = pro.getProperty("userid");
			String password = pro.getProperty("password");
			String score = pro.getProperty("score");
			
			System.out.println(driver);
			System.out.println(url);
			System.out.println(password);
			System.out.println(userid);
			System.out.println(score);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(NullPointerException ex) {
			System.out.println("파일을 찾을수없음(경로확인)");
			ex.printStackTrace();
		}
		
		
	}

	private static void f11() {
		//Hashtable : 멀티쓰레드환경에 안정적, 동기화지원 (synchronized) 
		Map<String, Integer> data = new Hashtable<>();
		
		Runnable r1 = ()->{
			for(int i=1;i<=1000;i++) {
				data.put(String.valueOf(i), i);
			}
		};
		Runnable r2 = ()->{
			for(int i=1001;i<=2000;i++) {
				data.put(String.valueOf(i), i);
			}
		};
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();t2.start();
		
		try {
			t1.join();t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("map의 갯수:" + data.size());
		
		
		
		
	}

	private static void f10() {
		//Map : 키와 값의 쌍이다. (entry) : HashMap, HashTable
		
		Map<Board, Integer> data = new HashMap<>();
		data.put(new Board("a","a2","a3"), 100);
		data.put(new Board("a","a2","a3"), 90); //키가 같으면 새로운값으로 대체 
		data.put(new Board("a","a2","a3"), 95);
		data.put(new Board("a","a2","a3"), 85);
		data.put(new Board("a","a2","a3"), 45);
		data.put(new Board("b","b2","b3"), 99);
		
		//keySet이용
		Set<Board> keys = data.keySet();
		for(Board key:keys) {
			System.out.println(key + "==>" + data.get(key));
		}
		
		//enteySet이용
		System.out.println("-----enteySet이용----------");
		Set<Entry<Board, Integer>> entrySet = data.entrySet();
		for(Entry<Board, Integer> entry:entrySet) {
			System.out.println(entry.getKey() + "==>" + entry.getValue());
		}
		
	}
	
	
	private static void f9() {
		//Map : 키와 값의 쌍이다. (entry) : HashMap, HashTable
		
		Map<String, Integer> data = new HashMap<>();
		data.put("김길동", 100);
		data.put("김길동", 90); //키가 같으면 새로운값으로 대체 
		data.put("박길동", 95);
		data.put("홍길동", 85);
		data.put("양길동", 45);
		
		//keySet이용
		Set<String> keys = data.keySet();
		for(String key:keys) {
			System.out.println(key + "==>" + data.get(key));
		}
		
		//enteySet이용
		System.out.println("-----enteySet이용----------");
		Set<Entry<String, Integer>> entrySet = data.entrySet();
		for(Entry<String, Integer> entry:entrySet) {
			System.out.println(entry.getKey() + "==>" + entry.getValue());
		}
		
	}
	private static void f8() {
		// Set : 순서가 없다. 중복불가 , 구현class : HashSet, TreeSet(뒤)
		Set<Board> data = new HashSet<>();

		data.add(new Board("제목1", "내용1", "작성자1"));
		data.add(new Board("제목2", "내용2", "작성자2"));
		data.add(new Board("제목3", "내용3", "작성자3"));
		data.add(new Board("제목4", "내용4", "작성자4"));
		data.add(new Board("제목4", "내용4", "작성자4"));
		data.add(new Board("제목4", "bb", "cc"));
	 
		System.out.println("size:" + data.size());
		System.out.println("contains:" + data.contains(new Board("제목4", "내용4", "작성자4")));
		System.out.println("contains:" + data.contains(new Board("a", "b", "c")));
		//향상for...index불필요시 사용
		for (Board s : data) {
			System.out.println(s);
		}
		System.out.println("============일반for : set은 순서없으므로 불가 =================");		
		System.out.println("=====반복자이용(Iterator)=====");
		
		Iterator<Board> it = data.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		
	}
	private static void f7() {
		// Set : 순서가 없다. 중복불가 , 구현class : HashSet
		Set<String> data = new HashSet<>();

		data.add("토");
		data.add("월");
		data.add("수");
		data.add("화");
		data.add("토");
		System.out.println("size:" + data.size());
		System.out.println("contains:" + data.contains("월"));
		System.out.println("contains:" + data.contains("금"));
		for (String s : data) {
			System.out.println(s);
		}
	}

	private static void f6() {
		List<Board> data = new Vector<Board>();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 1; i <= 1000; i++) {
					data.add(new Board("제목" + i, "내용" + i, "작성자" + i));
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 1001; i <= 2000; i++) {
					data.add(new Board("제목" + i, "내용" + i, "작성자" + i));
				}
			}
		});
		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Vector에 저장된 data의 갯수:" + data.size());
		for (Board b : data) {
			System.out.println(b);
		}

	}

	private static void f5() {
		// List interface : 구현class는 ArrayList, LinkedList, Vector
		List<Board> data = new LinkedList<Board>();
		data.add(new Board("제목1", "내용1", "작성자1"));
		data.add(new Board("제목2", "내용2", "작성자2"));
		data.add(new Board("제목3", "내용3", "작성자3"));
		data.add(new Board("제목4", "내용4", "작성자4"));
		Board board = Board.builder().subject("제목5").content("내용5").writer("작성자5").build();
		data.add(board);
		System.out.println(data.size() + "건");
		data.remove(2);
		System.out.println("2번째 data얻기:" + data.get(2));

		display(data);

	}

	private static void f4() {
		// List interface : 구현class는 ArrayList, LinkedList, Vector
		List<Board> data = new ArrayList<Board>();
		data.add(new Board("제목1", "내용1", "작성자1"));
		data.add(new Board("제목2", "내용2", "작성자2"));
		data.add(new Board("제목3", "내용3", "작성자3"));
		data.add(new Board("제목4", "내용4", "작성자4"));
		Board board = Board.builder().subject("제목5").content("내용5").writer("작성자5").build();
		data.add(board);
		System.out.println(data.size() + "건");
		data.remove(2);
		System.out.println("2번째 data얻기:" + data.get(2));

		display(data);

	}

	private static void display(List<Board> data) {
		for (Board board : data) {
			System.out.println(board);
		}

	}

	private static void f3() {
		// Collection :
		// List interface 구현 : 순서있음, 중복허용
		// ArrayList : 연속공간에 저장됨 , 갯수는 자동으로 늘어난다.
		// 맨뒤에 추가는 빠르지만 삽입이 많은경우 바람직하지않다.(느림)
		// LinkedList : 주소로 다은 data를 접근
		List<Integer> data = new LinkedList<>();
		data.add(100);
		data.add(200);
		data.add(300);
		System.out.println(data);

		LinkedList<String> data2 = new LinkedList<>();
		data2.add("월");
		data2.add("화");
		data2.add("수");
		data2.add("토");
		data2.add("토");
		System.out.println(data2);
		System.out.println(data2.size());

	}

	private static void f2() {
		// Collection :
		// List interface 구현 : 순서있음, 중복허용
		// ArrayList : 연속공간에 저장됨 , 갯수는 자동으로 늘어난다.
		// 맨뒤에 추가는 빠르지만 삽입이 많은경우 바람직하지않다.(느림)
		ArrayList<Integer> data = new ArrayList<>();
		data.add(100);
		data.add(200);
		data.add(300);
		System.out.println(data);

		ArrayList<String> data2 = new ArrayList<>();
		data2.add("월");
		data2.add("화");
		data2.add("수");
		data2.add("토");
		data2.add("토");
		System.out.println(data2);
		System.out.println(data2.size());
	}

	private static void f1() {
		// 여러개를 모아놓은 자료구조 : 배열, Collection
		// 배열 : 같은타입, 한정적 갯수, 갯수늘릴수없다.
		int[] arr = null;
		int[] arr2 = new int[20];

		arr = new int[] { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };

		System.arraycopy(arr, 0, arr2, 0, arr.length);
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(arr2));

	}

}
