package raovarun.moviedb.model;

//This is the movie class that is used to pass the data around
public class Movie {

/*
 Movie Name
 ISBN13 Number (optional)
 Release Date
 Location (Canadian OR International)
 Genre (Action, Biography, Comedy, Drama, Educational, History, Horror, Musical,
 Mystery, Romance, Sci-Fi, Thriller OR Western)
 Rating (1 to 5 stars)
 Duration (in minutes)
 Price

 */	
	public String movieName = "";
	public String isbnNumber = "0" ;
	public String releaseDate = "2018-01-01";
	public String location = "Canada";
	public String genre = "Action";
	public String rating = "1";
	public String duration = "1";
	public String price = "1";
	
	

	
	public String getcsvFormat(){
		return movieName + "," + isbnNumber + "," + releaseDate + "," + location + "," + genre + "," + rating + "," + duration + "," + price; 
		
	}
	

}
