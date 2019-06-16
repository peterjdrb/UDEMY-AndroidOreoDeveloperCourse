import java.util.*;

public class HelloWorld {
	public static void main(String[] args) {
		
		List countries = new ArrayList();
		
		countries.add("England");
		countries.add("Scotland");
		countries.add("Wales");
		
		countries.remove(0);
		countries.add("Northern Island");
		
		System.out.println(countries.toString());
		System.out.println(countries.size());
	}
}