public class HelloWorld {
  public static void main(String[] args) {
    
    class Number {
    	private int value;
    	
    	public int getValue() {
    		return this.value;
    	}
    	
    	public void setValue (int num) {
    		this.value = num;
    	}
    	
    	public boolean isPositive() {
    		if(getValue() >= 0 ) {
    			return true;
    		} else {
    			return false;
    		}
	}
    }
    
    Number num = new Number();
    
    num.setValue(0);
    
    if ( num.isPositive() ) {
    	System.out.println(num.getValue() + " is positive.");
    } else {
    	System.out.println(num.getValue() + " is not positive.");
    }    
  }
}
