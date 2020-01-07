//CIT360 - 01, Zachary Brennan; Creates and Places packets into linked list

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;



public class Producer implements Runnable {
	private String name;
	private Thread thread;
	public LinkedList<Packet> buffer;
	private long startTime;
	ReentrantLock lock;
	
	DateTimeFormatter date = DateTimeFormatter.ofPattern("mm:ss:SS");  
	 
	   
	
	public Producer(String name,LinkedList<Packet> buffer,ReentrantLock lock) {
		this.name = name;
		this.lock = lock;
		this.buffer = buffer;
		thread = new Thread(this, name);
		startTime = System.nanoTime();
		thread.start(); 
	}


	public void run() {
	
		try {
			int from = (int)(Math.random()*255)+1;
			while( (System.nanoTime() - startTime) / 1000000000.0 <  15) {
				lock.lock();
				//Array
				String[] alph = {"Two","Plus","Two","Is","Not","Five","The","Cow","Is","Cool","Turtles","Are","Fast"};
				
				//Int Variables
				int range = (alph.length-1)-0 +1;
				int size = (int)(Math.random() * 4) +1;
				
				int to = 0;
				
				//String Variables
				String data = "";
				
				to = (int) (Math.random()*255)+1;
				for(int i = 0; i < size; i++) {
					data += alph[(int)(Math.random()* range)] + " ";
						
				}
				int counter = 0;
				int fileSize = data.length();
				LocalDateTime time = LocalDateTime.now();  
				Packet packet = new Packet(data,from,to,date.format(time),fileSize);
				buffer.insertLast(packet);
				lock.unlock();
				Thread.sleep((int)(Math.random()*3000));		
			}
		} catch(InterruptedException z) {
			z.printStackTrace();
		}
	
		
	}
}
