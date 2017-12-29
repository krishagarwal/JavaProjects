
public class Screen implements ScreenSpec {
	private String resolution;
	private int refreshrate;
	private int responsetime;
	
	public Screen(String resolution, int refresh, int response) {
		this.resolution = resolution;
	    this.refreshrate = refresh;
	    this.responsetime = response;
	}
	
	public String getResolution() {
		return resolution;
	}
	public int getRefreshRate() {
		return refreshrate;
	}
	public int getResponseTime() {
		return responsetime;
	}
	
	public String toString() {
		return    "Resolution    : "+resolution+"\n"
		        + "Refresh       : "+refreshrate+"\n"
		        + "Response      : "+responsetime+"\n";
	}

}
