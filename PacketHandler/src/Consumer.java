//CIT360 - 01, Zachary Brennan; Looks through the linked list and deals with packets
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.sun.javafx.logging.Logger;

public class Consumer implements Runnable{
	private String name;
	private Thread thread;
	public LinkedList<Packet> buffer;
	long startTime;
	File log;
	PrintWriter logger;
	DateTimeFormatter dateSent = DateTimeFormatter.ofPattern("yyyy/MM/dd"); 
	Date date = new Date();
	public Consumer(String name,LinkedList<Packet> buffer) {
		this.name = name;
		this.buffer = buffer;
		thread = new Thread(this, name);
		startTime = System.nanoTime();
		thread.start(); 
	}
	
	public void run() {
		try {
			logger = new PrintWriter("PacketLog.log");
			while( (System.nanoTime() - startTime) / 1000000000.0 <  16) {
				if(buffer.size() > 0) {
					if(buffer.getFirst().getTo() >= 0 && buffer.getFirst().getTo() <= 99 ){
						System.out.println("Destination " + buffer.getFirst().getTo()+": " +buffer.getFirst());
						logger.println("From: "+ buffer.getFirst().getFrom()+
								", Destination: "+buffer.getFirst().getTo()+ ", Date Sent: "+ date);
						buffer.removeFirst();
					}else {
						logger.println("From: "+ buffer.getFirst().getFrom()+
								", Destination: "+buffer.getFirst().getTo()+ ", Date Sent: "+ date);
						buffer.removeFirst();
					}
				}
				
				Thread.sleep((int)(Math.random()*500));		
			}
		} catch(InterruptedException | FileNotFoundException z) {
			
		}
		logger.close();
	
	}
}

