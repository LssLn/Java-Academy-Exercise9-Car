package car;

import java.util.Random;
import java.util.Scanner;


public class car_main {
	
	public static void menu() {
		System.out.println("\n\n--MENU'--\n");
		System.out.println("10] Menu'\n");
		System.out.println("1] Guida\n");
		System.out.println("2] Fai Gas\n");
		System.out.println("3] Vedi quanto Gas rimane\n");
		System.out.println("4] Vedi la resa della macchina\n");
		System.out.println("0] Esci\n");
		System.out.println("--> Digita un numero: ");
	}
	public static void main(String[] args) {
		Random random = new Random();
		
		double litri = random.nextDouble();
		double km = 1.0;
		double resa = litri/km;
		
		Car car = new Car(resa);
		
		System.out.println("MACCHINA\nPer iniziare a guidare, devi fare gas."
				+ "\nIl modello da te acquistato ha una resa di " +
				resa+" per KM.\n"+"Quanto vuoi mettere nel distributore?"
						+ "\nI tagli disponibili sono multipli di 5.\n");
		
		Scanner scanner = new Scanner(System.in);
		double ricarica=0;
		
		do {
			ricarica = scanner.nextInt();
			if(!(ricarica % 5 ==0) ) {
				System.out.println("Il distributore non accetta monete."
						+ "\nI tagli disponibili sono multipli di 5.");
			}
		}while(!(ricarica % 5 ==0));
		
		//ho la ricarica
		
		car.addCarburante(ricarica);
		
		System.out.println("Macchina pronta: il credito è: "
				+car.getCarburante()+" L.\n");
		//menù
		int scelta=0;
		menu();

		do {
			scelta=scanner.nextInt();
			
			switch(scelta) {
			case 10:
				menu();
				break;
			case 1:
				System.out.println("\nQuanti KM devi guidare?: ");
				//int numminuti = random.nextInt(300);
				double km_da_fare = scanner.nextDouble();
				car.drive(km_da_fare);
				break;
			case 2:
				System.out.println("\nQuanto vuoi mettere nel distributore?"
						+ "\nI tagli disponibili sono multipli di 5.\n");
				do {
					ricarica = scanner.nextInt();
					if(!(ricarica % 5 ==0) ) {
						System.out.println("Il distributore non accetta monete."
								+ "\nI tagli disponibili sono multipli di 5.\n");
					}
				}while(!(ricarica % 5 ==0));
				car.addCarburante(ricarica);
				System.out.println("\nLa ricarica di "+ricarica+" EUR è stata fatta."
						+ "\nCarburante: "+car.getCarburante()+".\n");
				break;
			case 3:
				System.out.println("\nCarburante: "+car.getCarburante()+".\n");
				break;
			case 4:
				System.out.println("\nLa resa della macchina è "+resa+".\n");
				break;
			
			case 0:
				System.out.println("\nAlla prossima.\n");
				break;
			default:
				System.out.println(scelta+"\n non è un opzione.\n");
			}
		}while(scelta!=0);
		
		
	}
}
