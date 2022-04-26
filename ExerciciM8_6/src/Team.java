import java.util.ArrayList;
public class Team {

	private ArrayList<Car> carsList;
	private ArrayList<Worker> workersList;
	private String teamName;
	private String countryOfOrigin;
	private float teamBudget;
	
	
	public Team(String teamName, String countryOfOrigin, int teamBudget) {
		
		workersList= new ArrayList<Worker>();
		carsList=new ArrayList<Car>();
		this.teamName=teamName;
		this.countryOfOrigin=countryOfOrigin;
		this.teamBudget=teamBudget;
	}
	
	public String getTeamName() {
		
		return teamName;
	}

	public void addWorker(Worker worker){
		

		workersList.add(worker);
	}
	
	public void removeWorker(Worker worker ) {
		
		workersList.remove(worker);
	}
	
	public int findWorkerInList(String fullName) {
		
		int index=-1;;
		int i=0;
		
		if(workersList.size()>0) {
			do {	
					
				if(fullName.equalsIgnoreCase(workersList.get(i).getWorkerFullName())) {
				
					index=i;
				}
			
				i++;
			
			}while (i<workersList.size()&&!(fullName==(workersList.get(i-1).getWorkerFullName())));
		}
		return index;
	}
	
	public Worker validateNewWorker(String name) {
		
		Worker worker=null;
		String message="";
		int index;
		
		index=findWorkerInList(name);
		
		if(index!=-1) {
		
			message="El treballador "+name+"  ja existeix a la base de dades.";
			worker=workersList.get(index);
		}
		
		System.out.println(message);
		return worker;
	}
	
	public Worker validateWorker(String name) {
		
		Worker worker=null;
		String mensaje="El treballador no existeix a la base de dades.";
		int index;
		
		index=findWorkerInList(name);
		
		if(index!=-1) {
			
			worker=workersList.get(index);
			mensaje="";
		}
		
		System.out.println(mensaje);
		return worker;
	}
	
	public void addCar(Car car){
		
		carsList.add(car);
	}
	
	public void removeCar(Car car) {
		
		carsList.remove(car);
	}
	
	public Car validateNewCar(String id) {
		
		Car car=null;
		String message="";
		int index;
		
		index=findCarInList(id);
		
		if(index!=-1) {
		
			message="El cotxe "+id+"  ja existeix a la base de dades.";
			car=carsList.get(index);
		}
		
		System.out.println(message);
		return car;
	}
	public int findCarInList(String id) {
		
		int index=-1;;
		int i=0;
		
		if(carsList.size()>0) {
			do {	
					
				if(id.equalsIgnoreCase(carsList.get(i).getCarID())) {
				
					index=i;
				}
			
				i++;
			
			}while (i<carsList.size()&&!(id==(carsList.get(i-1).getCarID())));
		}
		return index;
	}
	
	public Car validateCar(String id) {
		
		Car car=null;
		String mensaje="El cotxe no existeix a la base de dades.";
		int index;
		
		index=findCarInList(id);
		
		if(index!=-1) {
			
			car=carsList.get(index);
			mensaje="";
		}
		
		System.out.println(mensaje);
		return car;
	}
	
	public String toString() {
		
		return "Les dades de l'escuderia son:\nNom: "+teamName+".\nPaís d'origen: "
		+countryOfOrigin+".\nPresupost: "+teamBudget+".\nCotxes: "+carsList+".\nTreballadors: "+workersList+".\n";
	}
}
