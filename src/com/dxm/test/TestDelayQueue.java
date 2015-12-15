package com.dxm.test;

import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class TestDelayQueue {
	
	private class DxmThread implements Runnable{

		@Override
		public void run() {
			System.out.println("我开始了==========================" + new Date().toLocaleString());
			for (int i = 0; i < 2; i++) {
				try {
					
					Stadium ss = delayQueue.poll(10, TimeUnit.SECONDS);
					if(ss == null){
						System.out.println( "null ===============" + new Date().toLocaleString());
					}else{
						System.out.println(ss.getI() + "===============" + new Date().toLocaleString());
					}
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
		}

	}
	public static DelayQueue<Stadium> delayQueue = new DelayQueue<Stadium>();
	
	public static void main(String[] args) throws InterruptedException {
		TestDelayQueue queue = new TestDelayQueue();
		Thread thread = new Thread(queue.new DxmThread());
		thread.start();
		
		
		Stadium s1 = new Stadium();
		s1.setI(0);
		Stadium s2 = new Stadium();
		s2.setI(2000);
		delayQueue.put(s1);
		System.out.println("放进去s1了");
			
		Thread.sleep(1000);
		delayQueue.put(s2);
		System.out.println("放进去s2了==========="+ new Date().toLocaleString());
	}

}
