/*
package com.mysuperscore.servlet;


import com.mysuperscore.dao.SongDAO;
import com.mysuperscore.model.Song;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/insert")
public class InsertJspServlet extends HttpServlet {
    private SongDAO songDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        ApplicationContext ac = (ApplicationContext) config.getServletContext().getAttribute("applicationContext");
        songDAO = (SongDAO) ac.getBean("SongDAO");
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Song song = new Song();
        song.setTitle(req.getParameter("title"));
        song.setComposer(req.getParameter("composer"));
        song.setAlbum(req.getParameter("album"));
        song.setDescription(req.getParameter("description"));
        song.setNumberOfPages(Integer.parseInt(req.getParameter("numberOfPages")));

        songDAO.create(song);

        resp.sendRedirect("/");

    }
}
*/
