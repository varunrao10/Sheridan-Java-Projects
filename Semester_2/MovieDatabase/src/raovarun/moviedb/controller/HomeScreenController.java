package raovarun.moviedb.controller;
//imports
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import raovarun.moviedb.model.Movie;


public class HomeScreenController implements Initializable {

	// Private and Protected
	@FXML private ListView<String> movieListView;
	protected List<Movie> movieList = new ArrayList<>();
	protected ObservableList<String> movieObservableList = FXCollections.observableArrayList();
	private Path mFile;
	
    @FXML protected void OpenMovieFile(ActionEvent event) {
    	//Gets the values from the file and initializes the movie list
    	CreateMovies();
    	
    	//Creates observablelist from the movie list
    	for(int i = 0; i < movieList.size(); i++) {
    		movieObservableList.add(movieList.get(i).movieName);
    	}
    	
    	//adds the observablelist to the listview on the UI
    	movieListView.setItems(movieObservableList);
    }
    
    //Allows you to delete a movie that is selected on the screen
    @FXML protected void DeleteMovie(ActionEvent event) {
    	String sItem = movieListView.getSelectionModel().getSelectedItem();
    	for(int i = 0; i < movieList.size(); i++) {
    		if(sItem.equals(movieList.get(i).movieName) ) {
    			movieList.remove(i);
    			movieObservableList.remove(i);
    		}
    		
    	}
	    
    }
    
    @FXML protected void CreateMovie(ActionEvent event) {
    	try {
	    	Movie movieToCreate = new Movie();
	    	
	    	Stage createStage = new Stage();
	    	FXMLLoader mLoader = new FXMLLoader(getClass().getResource("/MovieDb.fxml"));
			GridPane root = (GridPane) mLoader.load();
			
			MovieDbController mController = mLoader.getController();
			
			//pass the movie to edit to the moviecontroller
			mController.setEditableMovie(movieToCreate);
			
			Scene scene = new Scene(root,600,600);
			scene.getStylesheets().add(getClass().getResource("/application.css").toExternalForm());
			
			createStage.setScene(scene);
			createStage.showAndWait();
			
			movieList.add(movieToCreate);
			
			// refresh the listview to reflect the changed movie values
			movieListView.getItems().clear();
			
	    	movieObservableList.removeAll();
	    	
	    	for(int j = 0; j < movieList.size(); j++) {
	    		
	    		movieObservableList.add(movieList.get(j).movieName);
	    	}
	    	
	    	movieListView.setItems(movieObservableList);
		
			createStage.close();
    	} //try
    	
	    catch(IOException e) {
	    	System.out.println(e.getMessage());
	    }
    }
    
    
    //Allows you to edit a movie that is selected on the screen
    @FXML protected void EditMovie(ActionEvent event) {
    	
    	Movie movieToEdit;
    	
	    try {
	    	// First get the name of the movie selected in the listview
	    	String sItem = movieListView.getSelectionModel().getSelectedItem();
	    	
	    	// Iterate through the movielist to get the movie item selected
	    	for(int i = 0; i < movieList.size(); i++) {
	    		
	    		if(movieList.get(i).movieName.equals(sItem)) {
	    			movieToEdit = movieList.get(i);
	    			 
			    	Stage editStage = new Stage();
			    	FXMLLoader mLoader = new FXMLLoader(getClass().getResource("/MovieDb.fxml"));
					GridPane root = (GridPane) mLoader.load();
					
					MovieDbController mController = mLoader.getController();
					
					//pass the movie to edit to the moviecontroller
					mController.setEditableMovie(movieToEdit);
					
					Scene scene = new Scene(root,600,600);
					scene.getStylesheets().add(getClass().getResource("/application.css").toExternalForm());
					
					editStage.setScene(scene);
					editStage.showAndWait();
					
					// refresh the listview to reflect the changed movie values
					movieListView.getItems().clear();
					
			    	movieObservableList.removeAll();
			    	
			    	for(int j = 0; j < movieList.size(); j++) {
			    		
			    		movieObservableList.add(movieList.get(j).movieName);
			    	}
			    	
			    	movieListView.setItems(movieObservableList);
				
					editStage.close();
	    		} //if
	    	
	    	} //for
		
	} //try
	catch(Exception e) {e.printStackTrace();}
	    
    }

    // Saves the movie list to the file again
    @FXML protected void SaveMovies(ActionEvent event) {
    	try {
    	List<String> data = new ArrayList<>();
    	data.add("movieName,isbnNumber,releaseDate,location,genre,rating,duration,price");
    	for(int i = 0; i < movieList.size(); i++) {
    		data.add(movieList.get(i).getcsvFormat());
    	}
    	
    	Files.write(mFile,data, Charset.defaultCharset());
    	}catch(IOException e) {
    		System.out.println(e.getMessage());
    	}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		//Initialize the class variable for the movie file
		mFile = Paths.get("resources/movie.csv");
		
	}
	
	
	//Create a list movies from the file
	private void CreateMovies() {
		
		try {
			
			List<String> fLines = Files.readAllLines(mFile);
			
			for (int i = 1; i < fLines.size();i++) {
				String currentLine = fLines.get(i);
				List<String> cols = Arrays.asList(currentLine.split(","));
				System.out.println(cols);
				Movie m = new Movie();
				m.movieName = cols.get(0);
				m.isbnNumber = cols.get(1);
				m.releaseDate = cols.get(2);
				m.location = cols.get(3);
				m.genre = cols.get(4);
				m.rating = cols.get(5);
				m.duration = cols.get(6);
				m.price = cols.get(7);
				movieList.add(m);
			}
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
