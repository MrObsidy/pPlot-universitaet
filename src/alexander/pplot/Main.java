package alexander.pplot;

import java.util.ArrayList;

public class Main {
	
	/**
	 * Hauptmethode. Wird am Start des Programms gestartet.
	 * 
	 * 
	 * Dieses Programm gibt alle Luftdrücke in einer Textdatei aus, wobei z = LinienZahl - 2 ist. In Zeile 1 und 2 sind delta Z und z max vermerkt.
	 * Dieses Programm selbst stellt nichts dar, sondern bereitet nur die daten vor. 
	 * 
	 * @param args
	 */
	public static void main(String[] args){
		System.out.println("Starten von pPlot.");
		if(args.length != 5 || args.length != 1){
			throw new IllegalStateException("Die angegebene Argumentmenge war nicht 5. Versuchen sie es mit pplot -help");
		}
		
		if(args[0] == "-help"){
			System.out.println("Benutzung: pplot <p0> <temp in C> <zmax> <deltaz> <ausgabedatei>");
			System.exit(0);
		}
		
		float p0 = Float.parseFloat(args[0]);
		float t0 = TemperatureHelper.inK(Float.parseFloat(args[1]));
		float dz = Float.parseFloat(args[2]);
		
		ArrayList<String> values = new ArrayList<String>();
		values.add(args[3]);
		values.add(args[4]);
		
		float z = 0;
		while(z <= 10000){
			double result = p0 * Math.exp((-1) * ((9.81 * z) / (287.085 * t0)));
			values.add(Double.toString(result));
			z += dz;
		}
	}
}
