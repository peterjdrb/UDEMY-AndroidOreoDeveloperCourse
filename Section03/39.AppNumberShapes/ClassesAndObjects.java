public class ClassesAndObjects {
  public static void main(String[] args) {
    
    class Number {
    	private int num;
    	
    	public int getNum() {
    		return this.num;
    	}
    	
    	public void setNum (int enteredNum) {
    		this.num = enteredNum;
    	}
    	
    	public boolean isTriangularNumber() {
    		int currentTriangularNumber = 1;
			int increment = 1;
			
			while (currentTriangularNumber < this.getNum()){
				increment++;
				currentTriangularNumber = currentTriangularNumber + increment;
			}
			
			if(this.getNum() == currentTriangularNumber ) {
    			return true;
    		} else {
    			return false;
    		}
		}
		
		public boolean isSquareNumber() {
    		double square = Math.sqrt(this.getNum());
			
			if( Math.floor(square) == square ) {
    			return true;
    		} else {
    			return false;
    		}
		}
    }
    
    Number num = new Number();
    
    num.setNum(6);
    
    if ( num.isTriangularNumber() ) {
    	System.out.println(num.getNum() + " is a triangular number.");
    } else {
    	System.out.println(num.getNum() + " is not a triangular number.");
    }
	
	if ( num.isSquareNumber() ) {
    	System.out.println(num.getNum() + " is a square number.");
    } else {
    	System.out.println(num.getNum() + " is not a square number.");
    }
	
	num.setNum(10);
    
    if ( num.isTriangularNumber() ) {
    	System.out.println(num.getNum() + " is a triangular number.");
    } else {
    	System.out.println(num.getNum() + " is not a triangular number.");
    }
	
	if ( num.isSquareNumber() ) {
    	System.out.println(num.getNum() + " is a square number.");
    } else {
    	System.out.println(num.getNum() + " is not a square number.");
    }
	
	num.setNum(5);
    
    if ( num.isTriangularNumber() ) {
    	System.out.println(num.getNum() + " is a triangular number.");
    } else {
    	System.out.println(num.getNum() + " is not a triangular number.");
    }
	
	if ( num.isSquareNumber() ) {
    	System.out.println(num.getNum() + " is a square number.");
    } else {
    	System.out.println(num.getNum() + " is not a square number.");
    }
	
	num.setNum(9);
    
    if ( num.isTriangularNumber() ) {
    	System.out.println(num.getNum() + " is a triangular number.");
    } else {
    	System.out.println(num.getNum() + " is not a triangular number.");
    }
	
	if ( num.isSquareNumber() ) {
    	System.out.println(num.getNum() + " is a square number.");
    } else {
    	System.out.println(num.getNum() + " is not a square number.");
    }
	
	num.setNum(36);
    
    if ( num.isTriangularNumber() ) {
    	System.out.println(num.getNum() + " is a triangular number.");
    } else {
    	System.out.println(num.getNum() + " is not a triangular number.");
    }
	
	if ( num.isSquareNumber() ) {
    	System.out.println(num.getNum() + " is a square number.");
    } else {
    	System.out.println(num.getNum() + " is not a square number.");
    }
  }
}
