
public class EX01 {

	public static void main(String[] args) {
		
		MyTv2 t = new MyTv2();
		
		t.setChannel(10);
		System.out.println("CH : " + t.getChannel());
		t.setChannel(20);
		System.out.println("VOL : " + t.getChannel());
		
		t.gotoPrevChannel();
		System.out.println("CH : " + t.getChannel());
		t.gotoPrevChannel();
		System.out.println("CH : " + t.getChannel());
		
	}

}

class MyTv2{
	
	boolean isPowerOn;
	int channel;
	int volume;
	
	int prev;
	
	
	public int getChannel() {
		return channel;
	}
	public void setChannel(int channel) {
		prev = this.channel;
		this.channel = channel;
	}
	
	void gotoPrevChannel() {
		setChannel(prev);
	}
	
	
	
}
