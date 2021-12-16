package car;

/*
 * Progettare e realizzare una classe Car(automobile) con le proprietà seguenti.
Un’automobile ha una determinata resa del carburante (misurata in miglia/galloni
o in litri/chilometri: scegliete il sistema che preferite) e una certa quantità
di carburante nel serbatoio. La resa è specificata dal costruttore e il livello
iniziale del carburante è a zero. Fornire questi metodi: un metodo drive per
simulare il percorso di un’automobile per una certa distanza, riducendo il
livello di carburante nel serbatoio; un metodo getGas, per ispezionare il
livello corrente del carburante; un metodo addGas per far rifornimento.
 * */
public class Car {
	private double resa; //L/KM
	private double carburante;
	
	public Car(double resa) {
		this.resa = resa; //fatta random dividendo L per KM
		this.carburante=0.0;
	}

	public Car() { }
	
	public void drive(double km) {
		if(this.carburante<= 0.0) {
			System.out.println("Carburante finito, ricarica\n\n");
		}else {
			double carburante_usato = resa*km; // resa=l/km --> l=km*resa
			this.carburante -= carburante_usato;
			System.out.println("\nSei arrivato a destinazione. "
					+ "Hai compiuto "+km+" km di distanza."
					+ "\nIl carburante rimasto è "+this.getCarburante());
		}
	}

	public double getCarburante() {
		return carburante;
	}

	public void addCarburante(double carburante) {
		this.carburante += carburante;
	}
		
}
