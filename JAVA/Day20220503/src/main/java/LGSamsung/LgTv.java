package LGSamsung;

public class LgTv implements TV{

	@Override
	public void PowerOn() {
		System.out.println("lg...on");
	}

	@Override
	public void PowerDown() {
		System.out.println("lg...off");		
	}

	@Override
	public void volumeUp() {
		System.out.println("lgvol...up");		
	}

	@Override
	public void volumeDown() {
		System.out.println("lgvol...down");		
	}

}
