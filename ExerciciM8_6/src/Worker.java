
public class Worker {

		protected String workerName;
		protected String workerLastName;
		protected String workerRole;
		protected int workerAge;
		protected int timeAtTheTeam;

		public Worker(String workerName, String workerLastName, String workerRole, int workerAge, int timeAtTheTeam) {
			
			this.workerName=workerName;
			this.workerLastName=workerLastName;
			this.workerRole=workerRole;
			this.workerAge=workerAge;
			this.timeAtTheTeam=timeAtTheTeam;
		}
		
		public String getWorkerFullName() {
			
			return (workerName+" "+workerLastName);
		}
		
		public String getWorkerRole() {
			
			return workerRole;
		}
		
		public float salaryCalculation() {
			
			float workerBaseSalary=50000;
			float loyaltyBonusPerYear=10000;
			float dangerBonus;
			float totalSalary;
			
			if(workerRole.equalsIgnoreCase("pilot")) {
				
				dangerBonus=50000;
			}
			else {
				dangerBonus=0;
			}

			totalSalary=workerBaseSalary+loyaltyBonusPerYear*timeAtTheTeam+dangerBonus;
			return totalSalary;
		}
		
		public String toString() {
			
			return workerName+" "+workerLastName;
		}
}
