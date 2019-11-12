package alexander.pplot;

public class TemperatureHelper {
	public static float inK(float inC){
		//kleiner Sicherheitscheck, kann ja sein, dass jemand Blödsinn eingibt
		if(inC - 273.15 < 0){
			return 0;
		}
		return (float) (inC - 273.15);
	}
	
	public static float inC(float inK){
		return (float) (inK + 273.15);
	}
}
