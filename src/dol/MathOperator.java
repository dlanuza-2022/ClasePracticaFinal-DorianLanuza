package dol;

public class MathOperator {
	
	double x, y;

	public MathOperator(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	public MathOperator() {
		super();
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	
	
	
	public double sum() {
		
		return x + y;
	}
	
    public double substraction() {
    	
    	return x - y;
	}

    public double multiplication() {
    	
    	return x * y;
	
    } 

    public double division() {
    	
    	return x / y;
	
    }

	
	

}
