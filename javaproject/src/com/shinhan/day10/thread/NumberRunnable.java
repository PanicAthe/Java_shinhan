package com.shinhan.day10.thread;

class Parent{
	
}

public class NumberRunnable extends Parent implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i <= 26; i++) {
			System.out.println("[" + Thread.currentThread().getName() + "]" + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}

}
