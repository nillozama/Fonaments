
public class Car {
	
	private String carColour;
	private String carID;
	private float carPower;
	private float carMaxVelocity;
	private float carPrice;
	
	public Car(String carID, String carColour, float carPower, float carMaxVelocity, float carPrice) {
		
		this.carID=carID;
		this.carColour=carColour;
		this.carPower=carPower;
		this.carMaxVelocity=carMaxVelocity;
		this.carPrice=carPrice;
	}
	
	public String getCarID() {
		
		return carID;
	}
	
	public String toString() {
		
		return carID;
	}
	
	public String showProperties() {
		
		return "Les dades del cotxe son:\nID: "+carID+".\nColor: "+carColour+".\nPotència: "+carPower+" cavalls.\nVelocitat màxima: "
		+carMaxVelocity+" Km/h.\nPreu de mercat: "+carPrice+" euros.\n";
	}
}
