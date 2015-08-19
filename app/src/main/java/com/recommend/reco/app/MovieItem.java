package com.recommend.reco.app;

/**
 * Created by Sumeet on 27-06-2014.
 */
public class MovieItem {

    private String movietitle,movieCategory;
    private int movieImageID;

    public MovieItem(String movietitle,String movieCategory,int movieImageID,double movieRating,int no_of_ratings){
        this.movietitle=movietitle;
        this.movieCategory=movieCategory;
        this.movieImageID=movieImageID;
    }

    public String getMovietitle() {
        return movietitle;
    }

    public void setMovietitle(String movietitle) {
        this.movietitle = movietitle;
    }

    public String getMovieCategory() {
        return movieCategory;
    }

    public void setMovieCategory(String movieCategory) {
        this.movieCategory = movieCategory;
    }

    public int getMovieImageID() {
        return movieImageID;
    }

    public void setMovieImageID(int movieImageID) {
        this.movieImageID = movieImageID;
    }
}
