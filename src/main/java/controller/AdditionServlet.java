package controller;

import model.Movie;
import model.Movies;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/addition"})
public class AdditionServlet extends HttpServlet
{
    private final Movies movies = new Movies();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        String director = req.getParameter("model");
        String year = req.getParameter("year");
        String fees = req.getParameter("fees");
        String genre = req.getParameter("genre");
        String budget = req.getParameter("budget");

        Movie newMovie = new Movie(name, director, year, fees, genre, budget);

        movies.addMovie(newMovie);

        // обновить страницу для обновления таблицы
        updatePage(req, resp);
    }

    private void updatePage(ServletRequest request, ServletResponse response) throws ServletException, IOException
    {
        RequestDispatcher view = request.getRequestDispatcher("view/index.html");
        view.forward(request, response);
    }
}
