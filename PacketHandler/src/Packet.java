//CIT360 - 01, Zachary Brennan; Packet Class
public class Packet implements Comparable<Packet>{
	public String data;
	public int from;
	public int to;
	public String time;
	public int size;
	public Packet(String data, int from, int to, String time, int size) {
		super();
		this.data = data;
		this.from = from;
		this.to = to;
		this.time = time;
		this.size = size;
	}
	
	public String getData() {
		return data;
	}
	public void setDate(String data) {
		this.data = data;
	}
	public int getFrom() {
		return from;
	}
	public void setFrom(int from) {
		this.from = from;
	}
	public int getTo() {
		return to;
	}
	public void setTo(int to) {
		this.to = to;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	} 
	@Override
	public String toString() {
		return "Packet [data=" + data + ", from=" + from + ", to=" + to + ", time=" + time + ", size=" + size + "]";
	}

	@Override
	public int compareTo(Packet o) {
		// TODO Auto-generated method stub
		return 0;
	}	
}
