package sheridan.ejava.assignments;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Measurements extends SimpleTagSupport{
	
	private String height="10";
	private String width="10";
	private String depth="18";
	private String measurementType;
	
	//Getters and Setters 
	public String getMeasurementType() {
		return measurementType;
	}
	public void setMeasurementType(String measurementType) {
		this.measurementType = measurementType;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getDepth() {
		return depth;
	}
	public void setDepth(String depth) {
		this.depth = depth;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		
		PageContext context = (PageContext)getJspContext();
		JspWriter writer = context.getOut();
		
		//Check for the type of measurement needed and print out the default values
		if(measurementType.equals("height"))
			writer.println(getHeight());
		else if(measurementType.equals("width"))
			writer.println(getWidth());
		else if(measurementType.equals("depth"))
			writer.println(getDepth());
		
	}

}
