package raovarun.moviedb.controller;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import raovarun.moviedb.model.Movie;


public class MovieDbController {

	@FXML private TextField movieName;  
	@FXML private TextField isbnNumber;  
	@FXML private DatePicker releaseDate;  
	@FXML private ChoiceBox<String> genre;  
	@FXML private TextField duration;  
	@FXML private TextField price;
	@FXML private RadioButton rating1;
	@FXML private RadioButton rating2;
	@FXML private RadioButton rating3;
	@FXML private RadioButton rating4;
	@FXML private RadioButton rating5;
	@FXML private Button saveButton;
	@FXML private RadioButton location1;
	@FXML private RadioButton location2;
	
	
	
	
	private Movie editableMovie;
	
	
	//This method initializes the form fields from the passed in movie object
	 public void setEditableMovie(Movie editableMovie) {
		 this.editableMovie = editableMovie;
		 
		 movieName.setText(editableMovie.movieName);
		 isbnNumber.setText(editableMovie.isbnNumber);
		 
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		 LocalDate localDate = LocalDate.parse(editableMovie.releaseDate, formatter);
		   
		 releaseDate.setValue(localDate);
		 genre.setValue(editableMovie.genre);
		 duration.setText(editableMovie.duration);
		 price.setText(editableMovie.price);
		
		 
		 switch (editableMovie.rating) {
		 case  "1" :
			 rating1.setSelected(true);break;
		 case  "2" :
			 rating2.setSelected(true);break;
			 
		 case  "3" :
			 rating3.setSelected(true);break;
			 
		 case  "4" :
			 rating4.setSelected(true);break;
			 
		 case  "5" :
			 rating5.setSelected(true);break;
			 
		 }
		 
		 switch (editableMovie.location) {
		 case  "Canada" :
			 location1.setSelected(true);break;
		 case  "International" :
			 location2.setSelected(true);break;
		 }
		 
	}
	
	
	//Save Button Handler. Copys the form fields to the movie object
    @FXML protected void handleSaveButtonAction(ActionEvent event) {
    	
    	editableMovie.movieName = movieName.getText();
    	editableMovie.isbnNumber = isbnNumber.getText();
    	editableMovie.releaseDate = releaseDate.getValue().toString();
    	editableMovie.genre = genre.getValue();
    	editableMovie.duration = duration.getText();

    	if (location1.isSelected())
    		editableMovie.location = "Canada";
    	else
    		editableMovie.location = "International";
    	
    	if(rating1.isSelected())
    		editableMovie.rating = "1";
    	else if(rating2.isSelected())
    		editableMovie.rating = "2";
    	else if(rating3.isSelected())
    		editableMovie.rating = "3";
    	else if(rating4.isSelected())
    		editableMovie.rating = "4";
    	else 
    		editableMovie.rating = "5";
    	
        Stage stage = (Stage) saveButton.getScene().getWindow();
        stage.close();
    }

}
