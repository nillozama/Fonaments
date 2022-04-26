
public class Pilot extends Worker{

	private float height;
	private float weight;
	
	public Pilot(String workerName, String workerLastName, String workerRole, int workerAge, int timeAtTheTeam, float height, float weight) {
		
		super(workerName, workerLastName, workerRole, workerAge, timeAtTheTeam);
		this.height=height;
		this.weight=weight;
	}
	
	public String showProperties() {
		
		return "\nPilot:\nNom: "+workerName+".\nCognom: "+workerLastName+".\nEdat: "+workerAge+" anys.\nAnys a l'escuderia: "
		+timeAtTheTeam+" anys.\nAlçada: "+height+" cm.\nPes: "+weight+" Kg.\nSou: "+super.salaryCalculation()+" euros.";
	}
}
