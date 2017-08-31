package ru.habrahabr.sergiosergio;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.springframework.stereotype.Component;

@Component("buffer")
public class Buffer {
	
	private boolean endingFlag = false;
	private BlockingQueue<String> buf = null;
    	
	public Buffer() {
		
		buf = new ArrayBlockingQueue<String>(1000,false) {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
		};
		
	}

	public BlockingQueue<String> getBuf() {
		return buf;
	}

	public boolean isEndingFlag() {
		return endingFlag;
	}

	public void setEndingFlag(boolean endingFlag) {
		this.endingFlag = endingFlag;
	}

		
	

}
