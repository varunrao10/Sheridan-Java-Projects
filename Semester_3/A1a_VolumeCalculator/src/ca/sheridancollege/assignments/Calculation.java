package ca.sheridancollege.assignments;

public class Calculation {

	public String CalculateVolume(String h,String w,String d) {
		int volume = Integer.parseInt(h) * Integer.parseInt(w) * Integer.parseInt(d);
		return "height= "+ h + "&width="+ w + "&depth=" +d + "&volume="+volume;
	}
	
	
}
