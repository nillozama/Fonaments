import java.util.ArrayList;
import java.util.Scanner;

public class App86 {

	static ArrayList<Team> teamList=new ArrayList<Team>();
	
	public static void main(String[] args) {
		
		boolean sortirMenu=false;
		
		do{
			sortirMenu=showMenu(sortirMenu);
			
		}while(!sortirMenu);
	}
	
	public static boolean showMenu(boolean sortirMenu) {

		Team team;
		Car  car;
		Worker worker;
		String name;
		String country;
		String carColor;
		String workerName;
		String workerLastName;
		String workerRole;
		String carId;
		int budge;
		int indexSwitch;
		int workerAge;
		int timeAtTheTeam;
		float carPower;
		float carMaxVelocity;
		float carPrice;

		
		System.out.println("Programa per a gestionar les carreres d'automobilisme.\n \n0- Sortir del programa. \n1- Crear equip. "
				+ "\n2- Veure equip. \n3- Eliminar equip.\n4- Introduir cotxe. \n5- Mostrar cotxe. \n6- Eliminar cotxe."
				+ "\n7- Introduir treballador. \n8- Mostrar treballador. \n9- Eliminar treballador.");
		indexSwitch=requireIntNumber("Quina opció del menú vols triar?");
		
		switch(indexSwitch) {
		
		case 0:

			System.out.println("Gracies per utilitzar l'aplicació. Adeu!!");
			sortirMenu=true;

			break;
			
		case 1:
			
			name=requireString("Introdueix nom de l'equip que vols crear.");

			team=validateNewTeam(name);
			if(team==null) {
				
				country=requireString("Introdueix el país d'origen de l'equip.");
				budge=requireIntNumber("Introdueix el presupost de l'equip.");
				addTeamToList(createTeam(name, country, budge));
			}
			break;
			
		case 2:

			name=requireString("Introdueix el nom de l'equip.");
			team=validateTeam(name);
			if(team!=null) {
				
				showTeam(team);
			}
			break;
			
		case 3:
				
			name=requireString("Introdueix el nom de l'equip.");
			team=validateTeam(name);
			if(team!=null) {
				delateTeam(team);
				System.out.println("S'ha eliminat l'equip.");
			}	
			break;
			
		case 4:

			name=requireString("Introdueix el nom de l'equip.");
			team=validateTeam(name);
			if(team!=null) {
				
				carId=requireString("Introdueix el ID del cotxe. Model i número de cotxe.");
				
				if (team.validateNewCar(carId)==null) {
					carColor=requireString("Introdueix el color del cotxe.");
					carPower=requireFloatNumber("Introdueix la potencia del cotxe en cavalls de potència.");
					carMaxVelocity=requireFloatNumber("Introdueix la velocitat màxima del cotxe en Km/h.");
					carPrice=requireFloatNumber("Introdueix el preu de mercat del cotxe en euros.");
					team.addCar(createCar(carId, carColor, carPower, carMaxVelocity, carPrice));	
				}
			}
			break;
			
		case 5:

			name=requireString("Introdueix el nom de l'equip.");
			team=validateTeam(name);
			if(team!=null) {
				
				carId=requireString("Introdueix el ID del cotxe. Model i número de cotxe.");
				car=team.validateCar(carId);
				if (car!=null) {
					showCar(car);
				}
			}
			break;
			
		case 6:
			
			name=requireString("Introdueix el nom de l'equip.");
			team=validateTeam(name);
			if(team!=null) {
				
				carId=requireString("Introdueix el ID del cotxe. Model i número de cotxe.");
				car=team.validateCar(carId);
				if (car!=null) {
				team.removeCar(car);
				System.out.println("S'ha eliminat el cotxe.");
				}
			}	
			break;
			
		case 7:
			
			name=requireString("Introdueix el nom de l'equip.");
			team=validateTeam(name);
			if(team!=null) {
				
				workerName=requireString("Introdueix nom del treballador.");
				workerLastName=requireString("Introdueix cognom del treballador.");
				name=workerName+" "+workerLastName;
				
				if (team.validateNewWorker(name)==null) {
					workerRole=requireString("Introdueix la funció del trebalaldor. Pilot/Mecanic");
					workerAge=requireIntNumber("Introdueix l'edat del treballador.");
					timeAtTheTeam=requireIntNumber("Introdueix quants anys porta treballant a l'escuderia.");
					worker=createWorker(workerName, workerLastName, workerRole, workerAge, timeAtTheTeam);
					if(worker!=null) {
						team.addWorker(worker);
					}
					else {
						
						System.out.println("No s'ha pogut crear el treballador. Has d'escollir un role de traballador: Pilot o Mecanic.");
					}
				}
			}
			break;
			
		case 8:
			
			name=requireString("Introdueix el nom de l'equip.");
			team=validateTeam(name);
			if(team!=null) {
				
				name=requireString("Introdueix nom i cognom del treballador.");
				worker=team.validateWorker(name);
				
				if (worker!=null) {
					
					showWorker(worker);
				}
			}
			break;
			
		case 9:
			
			name=requireString("Introdueix el nom de l'equip.");
			team=validateTeam(name);
			if(team!=null) {
				
				name=requireString("Introdueix nom i cognom del treballador.");
				worker=team.validateWorker(name);
				
				if (worker!=null) {
					
					team.removeWorker(worker);

					System.out.println("S'ha eliminat el treballador de la llista.");
				}
			}
			break;
			
		default:
			
			System.out.println("Has d'escollir un número de la llista.");
		}
		
		return sortirMenu;
	}
	
	public static Team createTeam(String teamName, String countryOfOrigin, int teamBudge) {
		
		Team team=new Team(teamName, countryOfOrigin, teamBudge);
		return team;
	}
	
	public static void showTeam(Team team) {
		
		System.out.println(team); 
	}
	
	public static void delateTeam(Team team) {
		
		teamList.remove(team);
	}
	
	public static Worker createWorker(String workerName, String workerLastName, String workerRole, int workerAge, int timeAtTheTeam){
		
		Worker worker=null;
		
		/*switch(workerRole){
		
			case "Pilot":
				worker=createPilot(workerName, workerLastName, workerRole, workerAge, timeAtTheTeam, requireFloatNumber("Introdueix l'alçada del pilot en centímetres."), requireFloatNumber("Introdueix el pes del pilot en Kg."));
				break;
				
			case "Mecanic":
				worker=createMechanical(workerName, workerLastName, workerRole, workerAge, timeAtTheTeam, requireString("Té estudis superiors de mecànica? SI/NO"));
				break;
				
			default:
				System.out.println("No s'ha pogut crear el treballador. Has d'escollir un role del traballador: Pilot o Mecanic.");
				
		}*/
		
		if(workerRole.equalsIgnoreCase("Pilot")){
			
			worker=createPilot(workerName, workerLastName, workerRole, workerAge, timeAtTheTeam, requireFloatNumber("Introdueix l'alçada del pilot en centímetres."), requireFloatNumber("Introdueix el pes del pilot en Kg."));
		}
		
		else if(workerRole.equalsIgnoreCase("Mecanic")){
			
			worker=createMechanical(workerName, workerLastName, workerRole, workerAge, timeAtTheTeam, requireString("Té estudis superiors de mecànica? SI/NO"));
		}

		return worker;
	}
	public static Pilot createPilot(String workerName, String workerLastName, String workerRole, int workerAge, int timeAtTheTeam, float height, float weight){
		
		Pilot pilot=new Pilot(workerName, workerLastName, workerRole, workerAge, timeAtTheTeam, height, weight);
		
		return pilot;
	}
	
	public static Mechanical createMechanical(String workerName, String workerLastName, String workerRole, int workerAge, int timeAtTheTeam, String hasStudies){
		
		Mechanical mechanical=new Mechanical(workerName, workerLastName, workerRole, workerAge, timeAtTheTeam, hasStudies);
		
		return mechanical;
	}
	
	public static Car createCar(String carID, String carColor, float carPower, float carMaxVelocity, float carPrice) {
		
		Car car=new Car(carID, carColor, carPower, carMaxVelocity, carPrice);
		
		return car;	
	}
	
	public static void showCar(Car car) {
		
		System.out.println(car.showProperties());
	}
	
	public static void showWorker(Worker worker) {
		
		/*switch(worker.getWorkerRole()){
		
		case "Pilot":
			Pilot pilot=(Pilot) worker;
			System.out.println(pilot.showProperties());;
			break;
			
		case "Mecanic":
			Mechanical mechanical=(Mechanical) worker;
			System.out.println(mechanical.showProperties());
			break;
			
		default:
			
			System.out.println("La funció del treballador no es va introduir correctament. Pilot/Mecanic.");
		}*/
		
		if(worker.getWorkerRole().equalsIgnoreCase("Pilot")) {
			
			Pilot pilot=(Pilot) worker;
			System.out.println(pilot.showProperties());;
		}
		
		else {
			
			Mechanical mechanical=(Mechanical) worker;
			System.out.println(mechanical.showProperties());
		}
	}
	
	public static int findListedTeams(String name) {
		
		int index=-1;
		int i=0;
		
		if(teamList.size()>0) {
			do {	
					
				if(name.equalsIgnoreCase(teamList.get(i).getTeamName())) {
				
					index=i;
				}
			
				i++;
			
			}while (i<teamList.size()&&!(name.equals(teamList.get(i-1).getTeamName())));
		}
		return index;
	}

	public static Team validateNewTeam(String name) {
		
		Team team=null;
		String message="";
		int index;
		
		index=findListedTeams(name);
		
		if(index!=-1) {
		
			message="L'equip "+name+"  ja existeix a la base de dades.";
			team=teamList.get(index);
		}
		
		System.out.println(message);
		return team;
	}

	public static Team validateTeam(String name) {
		
		Team team=null;

		String message="L'equip "+name+" no es troba a la base de dades.";
		int index;
		
		index=findListedTeams(name);
		
		if(index!=-1) {
			
			team=teamList.get(index);
			message="";	
		}
		
		System.out.println(message);
		return team;
	}
	
	public static void addTeamToList(Team team) {
		
		teamList.add(team);
	}
	
	public static int requireIntNumber(String message) {
		
		Scanner sc=new Scanner(System.in);
		int num;
		
		System.out.println(message);
		num=sc.nextInt();
		
		return num;
	}
	
	public static float requireFloatNumber(String message) {
		
		Scanner sc=new Scanner(System.in);
		float num;
		
		System.out.println(message);
		num=sc.nextFloat();
		
		return num;
	}
	
	public static String requireString(String message) {
		
		Scanner sc=new Scanner(System.in);
		String string;
		
		System.out.println(message);
		string=sc.nextLine();
		
		return string;
	}
}
