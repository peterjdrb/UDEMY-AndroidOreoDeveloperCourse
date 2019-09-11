import java.util.*;

public class HelloWorld {
	public static void main(String[] args) {
	
		List<String> familyMembers = new ArrayList<String>();
		
		familyMembers.add("Albert");
		familyMembers.add("Bert");
		familyMembers.add("Charles");
		familyMembers.add("David");
		
		for (String name : familyMembers) {
			System.out.println(name);
		}
		
		System.out.println("------------------");
		
		int i = 1;
		
		while (i <= 10) {
			System.out.println(i);
			i++;
		}
	}
}
