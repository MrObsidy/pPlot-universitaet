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
		if(args.length != 5 && args.length != 1){
			throw new IllegalStateException("Die angegebene Argumentmenge war ungültig. Versuchen sie es mit pplot -help");
		}
				
		if(args[0].equalsIgnoreCase("-help")){
			System.out.println("Benutzung: pplot <p0> <temp in C> <zmax in m> <deltaz in m> <ausgabedatei>");
			System.exit(0);
		}
		
		float p0 = Float.parseFloat(args[0]);
		float t0 = TemperatureHelper.inK(Float.parseFloat(args[1]));
		float dz = Float.parseFloat(args[3]);
		float dm = Float.parseFloat(args[2]);
		
		System.out.println("p0: " + p0);
		System.out.println("t0: " + t0);
		System.out.println("dz: " + dz);
		System.out.println("dmax: " + dm);
		
		ArrayList<String> values = new ArrayList<String>();
		values.add(args[2]);
		values.add(args[3]);
		
		float z = 0;
		while(z <= dm){
			double result = p0 * Math.exp(((-9.81 * z) / (287.085 * t0)));
			values.add(Double.toString(result));
			z += dz;
		}
		WriteHelper.writeArrayToFile(values, args[4]); 
	}
}
