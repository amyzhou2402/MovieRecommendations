package com.example.movierecommendations;

import java.util.ArrayList;

public class Movie {
    private int id;
    private String name;
    private int rating;
    private int releaseYear;
    private String description;
    private String imageUrl;


    public Movie(int id, String name, int rating, int releaseYear, String description, String imageUrl) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.releaseYear = releaseYear;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public static ArrayList<Movie> getMovies(){
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(new Movie(1, "Titanic", 1, 1997, "movie desc", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.originalfilmart.com%2Fproducts%2Ftitanic-1997-a&psig=AOvVaw0ijJBy13kZU9orO9PQlwEd&ust=1617024774823000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCMjFxeyM0-8CFQAAAAAdAAAAABAD")); // find a way to store images. link to url
        movies.add(new Movie(2, "The Lion King", 1, 2020, "movie desc", "https://www.bt.com/content/dam/bt/portal/images/articles/tv/tv-films-LionKing-hero.jpg/jcr:content/renditions/landscape-desktop.764.430.jpg"));
        movies.add(new Movie(3, "Avengers Endgame", 1, 2020, "movie desc", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.esquire.com%2Fentertainment%2Fmovies%2Fa26828212%2Fmarvel-avengers-endgame-poster-controversy-change%2F&psig=AOvVaw0oeM5jXT3QLPjbYWbP4yQa&ust=1617024796521000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCJCb1_aM0-8CFQAAAAAdAAAAABAD"));
        movies.add(new Movie(4, "Kimetsu no Yaiba", 5, 2020, "the highest grossing animated movie of all time!", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.imdb.com%2Ftitle%2Ftt11032374%2F&psig=AOvVaw2UDXhql9J4wJmn_YXrx9ZH&ust=1617024813766000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCJi17f6M0-8CFQAAAAAdAAAAABAD"));
        movies.add(new Movie(5, "Dark Knight", 1, 2020, "movie desc", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.limitedruns.com%2Foriginal%2Fmovie-posters%2Faction%2Fdark-knight-3%2F&psig=AOvVaw0CQ-s-qvN3NzQ7s1jizKOX&ust=1617024885724000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCKCfwqGN0-8CFQAAAAAdAAAAABAD"));
        movies.add(new Movie(6, "Lord of the Rings: Return of the King", 1, 2020, "movie desc", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.amazon.com%2FLord-Rings-Return-Movie-Poster%2Fdp%2FB000JW1WJW&psig=AOvVaw0AOI8hdLy7ppbLwMDjtIfr&ust=1617024906132000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCMj786qN0-8CFQAAAAAdAAAAABAD"));
        movies.add(new Movie(7, "Harry Potter: The Philosopher's Stone", 1, 2020, "movie desc", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.ebay.com.au%2Fitm%2FHARRY-POTTER-AND-THE-SORCERERS-STONE-MOVIE-POSTER-INTERNATIONAL-REGULAR-%2F122009198081&psig=AOvVaw37CsB6xG5SSNmYqSVAlI5h&ust=1617024928093000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCLCtxbWN0-8CFQAAAAAdAAAAABAD"));
        movies.add(new Movie(8, "Inception", 1, 2020, "movie desc", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.pinterest.com%2Fpin%2F46936021095824826%2F&psig=AOvVaw3d2cW_Vilb33vUFux-cD3G&ust=1617024959257000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCJjp2sSN0-8CFQAAAAAdAAAAABAL"));
        movies.add(new Movie(9, "Kimi no Na Wa", 1, 2020, "movie desc", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.imdb.com%2Ftitle%2Ftt5311514%2F&psig=AOvVaw0rEN1pDMs3boIodxHQIjjZ&ust=1617024995790000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCJCF5dWN0-8CFQAAAAAdAAAAABAD"));
        movies.add(new Movie(10, "Boku no Hero Academia: Two Heroes", 1, 2018, "movie desc", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.imdb.com%2Ftitle%2Ftt7745068%2F&psig=AOvVaw0rIjXIcJc9UT86r4L5pZ5X&ust=1617025036973000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCMD30emN0-8CFQAAAAAdAAAAABAD"));
        return movies;
    }

    public static Movie getMovie(int id){
        ArrayList<Movie> movies = Movie.getMovies();
        for(final Movie movie : movies){
            if (movie.getId()==(id)){
                return movie;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }
    public String getName() {return name;}
    public int getRating() {
        return rating;
    }
    public int getReleaseYear() {
        return releaseYear;
    }
    public String getDescription() {
        return description;
    }
    public String getImageUrl() {
        return imageUrl;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setRating(int rating) {
            this.rating = rating;
        }
    public void setReleaseYear(int releaseYear) {this.releaseYear = releaseYear;}
    public void setDescription(String description) {
            this.description = description;
        }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
