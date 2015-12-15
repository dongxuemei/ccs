package com.dxm.test;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author user
 * lisi
 *
 */
public class Stadium implements Delayed {
	
	private long  i;

	@Override
	public int compareTo(Delayed arg0) {
		return 0;
	}

	@Override
	public long getDelay(TimeUnit unit) {
		long x = unit.convert(i - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
		return  x;
	}

	public long getI() {
		return i;
	}

	public void setI(long i) {
		this.i = i + System.currentTimeMillis();
	}

}
