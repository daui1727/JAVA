package LGSamsung;

public class SamsungTv implements TV{

	@Override
	public void PowerOn() {
		System.out.println("sam...on");
	}

	@Override
	public void PowerDown() {
		System.out.println("sam...off");
	}

	@Override
	public void volumeUp() {
		System.out.println("samvol...up");		
	}

	@Override
	public void volumeDown() {
		System.out.println("samvol...down");		
	}
	
}
