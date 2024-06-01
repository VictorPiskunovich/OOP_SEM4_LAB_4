package model;

import controller.AdditionServlet;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Movies
{
    public void addMovie(Movie movie) throws IOException
    {
        JSONObject movieJson = new JSONObject();

        movieJson.put("name", movie.getName());
        movieJson.put("model", movie.getDirector());
        movieJson.put("year", movie.getYear());
        movieJson.put("fees", movie.getFees());
        movieJson.put("genre", movie.getGenre());
        movieJson.put("budget", movie.getBudget());

        // путь к файлу JSON
        String jsonPath = getJsonPath();

        // содержимое JSON
        String jsonContent = new String(Files.readAllBytes(Path.of(jsonPath)));

        // создаем JSONArray из строки JSON
        JSONArray jsonArray = new JSONArray(jsonContent);
        jsonArray.put(movieJson);

        // обновить локально
        try (FileWriter writer = new FileWriter(jsonPath))
        {
            writer.write(jsonArray.toString(4));
        }

        // обновить на сервере
        try (FileWriter writer = new FileWriter("movies.json"))
        {
            writer.write(jsonArray.toString(4));
        }
    }

    private String getJsonPath()
    {
        String parentPath;
        try
        {
            parentPath = new File(AdditionServlet.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParent();
        }
        catch (URISyntaxException e)
        {
            throw new RuntimeException(e);
        }

        return parentPath + File.separator + "src" + File.separator + "main" + File.separator + "webapp" + File.separator + "movies.json";
    }
}
