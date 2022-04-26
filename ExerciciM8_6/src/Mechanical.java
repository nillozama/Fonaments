
public class Mechanical extends Worker{
	
	private String hasMechanicalStudies;
	
	public Mechanical(String workerName, String workerLastName, String workerRole, int workerAge, int timeAtTheTeam, String hasMechanicalStudies) {
		
		super(workerName, workerLastName, workerRole, workerAge, timeAtTheTeam);
		this.hasMechanicalStudies=hasMechanicalStudies;
	}
	
	public String showProperties() {
		
		return "\nMecànic:\nNom: "+workerName+".\nCognom: "+workerLastName+".\nEdat: "+workerAge+" anys.\nAnys a l'escuderia: "
		+timeAtTheTeam+" anys.\nEstudis superiors de mecànica: "+hasMechanicalStudies+".\nSou: "+super.salaryCalculation()+" euros.";
	}
}
