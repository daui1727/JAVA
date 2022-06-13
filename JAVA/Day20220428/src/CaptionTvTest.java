class Tv{
	private boolean power;   // 전원상태(on/off)
	private int channel;   // 채널
	
	public boolean isPower() {
		return power;
	}
	public void setPower(boolean power) {
		this.power = power;
	}
	public int getChannel() {
		return channel;
	}
	public void setChannel(int channel) {
		this.channel = channel;
	}
	void power() {power = !power;}
	void channelUp() {++channel;}
	void channelDown() {--channel;}
}

class CaptionTv extends Tv{
	private boolean caption;    // 캡션상태(on/off)
	
	public boolean isCaption() {
		return caption;
	}


	public void setCaption(boolean caption) {
		this.caption = caption;
	}

	void displayCaption(String text) {
		if(caption) {  // 캡션 상태가 on(true)일 때만 text를 보여준다.
			System.out.println(text);
		}
	}
}


public class CaptionTvTest {

	public static void main(String[] args) {
		
		CaptionTv ctv = new CaptionTv();
		ctv.setChannel(10);
		ctv.channelUp();
		System.out.println(ctv.getChannel());
		
		ctv.displayCaption("Hello, World");
		ctv.setCaption(true);
		ctv.displayCaption("Hello, World");
		
	}

}
