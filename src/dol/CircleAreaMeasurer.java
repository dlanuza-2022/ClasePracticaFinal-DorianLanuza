package dol;

public class CircleAreaMeasurer {

	double radium;

	public CircleAreaMeasurer(double radium) {
		super();
		this.radium = radium;
	}

	public CircleAreaMeasurer() {
		super();
	}

	public double getRadium() {
		return radium;
	}

	public void setRadium(double radium) {
		this.radium = radium;
	}
	
	
	
	public double calculateRadium() {
		
		return Math.PI * radium * radium;
	}
	
	
	
	
}
