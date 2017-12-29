package printing;

public class BWCartridge implements ICartridge {
	
	@Override
	public String toString(){
		return "Black and White";
	}

	@Override
	public String getFillPercentage() {
		return "50%";
	}
}
