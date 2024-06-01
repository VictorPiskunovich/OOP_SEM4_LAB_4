package model;

public class Movie
{
    private String name;
    private String director;
    private String year;
    private String fees;
    private String genre;
    private String budget;

    public Movie(String name, String director, String year, String fees, String genre, String budget)
    {
        this.name = name;
        this.director = director;
        this.year = year;
        this.fees = fees;
        this.genre = genre;
        this.budget = budget;
    }

    public String getName()
    {
        return name;
    }

    public String getDirector()
    {
        return director;
    }

    public String getYear()
    {
        return year;
    }

    public String getFees()
    {
        return fees;
    }

    public String getGenre()
    {
        return genre;
    }

    public String getBudget()
    {
        return budget;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (!name.equals(movie.name)) return false;
        if (!director.equals(movie.director)) return false;
        if (!year.equals(movie.year)) return false;
        if (!fees.equals(movie.fees)) return false;
        if (!genre.equals(movie.genre)) return false;
        return budget.equals(movie.budget);
    }

    @Override
    public int hashCode()
    {
        int result = name.hashCode();
        result = 31 * result + director.hashCode();
        result = 31 * result + year.hashCode();
        result = 31 * result + fees.hashCode();
        result = 31 * result + genre.hashCode();
        result = 31 * result + budget.hashCode();
        return result;
    }
}
