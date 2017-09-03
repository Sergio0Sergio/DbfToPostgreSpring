package ru.habrahabr.sergiosergio;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.springframework.stereotype.Component;

@Component("buffer")
public class Buffer {
	
	public boolean endingFlag = false;
	public BlockingQueue<String> buf = new ArrayBlockingQueue<String>(1000,false);
	 
    

	
		
	

}
