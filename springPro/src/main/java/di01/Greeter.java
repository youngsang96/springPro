package di01;

public class Greeter {
	private String format;
	
	public Greeter() {
		System.out.println("---생성자 Greeter---");
	}
	public void setFormat(String format) {
		System.out.println(format);
		this.format=format;
	}
	
	public String greet(String guest) {
		
		return String.format(format, guest);
	}
}
