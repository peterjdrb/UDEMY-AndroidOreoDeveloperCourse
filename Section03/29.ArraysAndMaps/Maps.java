import java.util.*;

public class HelloWorld {
	public static void main(String[] args) {
		
		Map map = new HashMap();
		
		map.put("Father", "Rob");
		map.put("Mother", "Alex");
		
		map.remove("Father");
		
		System.out.println(map.toString());
		System.out.println(map.size());
	}
}