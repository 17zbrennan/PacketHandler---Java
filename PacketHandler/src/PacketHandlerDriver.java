//CIT360 - 01, Zachary Brennan; Driver Class
import java.util.concurrent.locks.ReentrantLock;
public class PacketHandlerDriver {

	public static void main(String[] args) {
		LinkedList<Packet> bufferList =  new LinkedList<Packet>();
				
				ReentrantLock lock = new ReentrantLock();
				Consumer destination = new Consumer("process", bufferList );
				Producer routerOne = new Producer("One",bufferList, lock);
				Producer routerTwo = new Producer("Two", bufferList, lock);
				Producer routerThree = new Producer("Three", bufferList, lock);
				
				
	}
}

