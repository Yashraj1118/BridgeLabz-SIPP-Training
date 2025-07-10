package doublylinkedlist.moviemanagement;

public class Movie {
    public String title;
    public String director;
    public int year;
    public double rating;

    public Movie prev;
    public Movie next;

    public Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }
}
