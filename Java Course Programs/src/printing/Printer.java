package printing;

public class Printer<T> implements IMachine{
	
	private String modelNumber;
	private PaperTray paperTray = new PaperTray();
	private Machine machine;
	private T cartridge;
	
	public Printer(boolean isOn, String modelNumber, T cartridge){
		machine = new Machine(isOn);
		this.modelNumber = modelNumber;
		this.cartridge = cartridge;
	}
	
	@Override
	public void TurnOn(){
		System.out.println("Warming up printer.");
		machine.TurnOn();
	}
	
	public <U extends ICartridge> void printUsingCartridge(U cartridge, String message){
		System.out.println(cartridge.toString());
		System.out.println(message);
		System.out.println(cartridge.toString());
	}
	
	public void print(int copies){		
		
		checkCopies(copies);
		
		String onStatus = "";
		if(machine.isOn()){
			onStatus = " is On!";
		}
		else{
			onStatus = " is Off!";
		}
		
		String textToPrint = modelNumber + onStatus;
		
		while(copies > 0 && !paperTray.isEmpty()){
			System.out.println(textToPrint);
			copies--;
			paperTray.usePage();
		}
		
		if(paperTray.isEmpty()){
			System.out.println("Load more paper!");
		}
	}

	private void checkCopies(int copies) {
		if (copies < 0){
			throw new IllegalArgumentException("Can't print less than 0 copies.");
		}
	}
	
	public void printColors(){
		String[] colors = new String[] { "Red", "Blue", "Green", "Yellow", "Orange" };
		
		for( String currentColor : colors ){
			if(currentColor.equals("Green")){
				continue;
			}
			System.out.println(currentColor);
		}
	}
	
	private void print(String text){
		System.out.println(text);
	}
	
	public String getModelNumber(){
		return modelNumber;
	}

	public void loadPaper(int count) {
		paperTray.addPaper(count);
	}

	@Override
	public void TurnOff() {
		machine.TurnOff();
		System.out.println("The machine is off!");
	}

	@Override
	public boolean isOn() {
		return machine.isOn;
	}

	public T getCartridge() {
		return cartridge;
	}
}