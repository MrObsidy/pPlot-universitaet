package synoptik;

public class Synoptik {
	public strictfp static void main(String[] args) {
		int wellenzahl = 2;
		double windgeschwindigkeit_u = 10;
		int grad60umfang = 11765000;
		double beta = 1.5 * 0.00000000001;
		
		//System.out.println(beta);
		
		while(wellenzahl <= 10) {
			float wellenlaenge = grad60umfang / wellenzahl;
			//System.out.println("WL" + wellenlaenge);
			float ergebnis = (float) (windgeschwindigkeit_u - (wellenlaenge * wellenlaenge * beta) / (4 * Math.PI * Math.PI));
			System.out.println("Wellenzahl " + wellenzahl + ": " + ergebnis);
			wellenzahl++;
		}
	}
}
