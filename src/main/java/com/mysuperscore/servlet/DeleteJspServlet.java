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

@WebServlet("/delete")
public class DeleteJspServlet extends HttpServlet {
    private SongDAO songDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        ApplicationContext ac = (ApplicationContext) config.getServletContext().getAttribute("applicationContext");
        songDAO = (SongDAO) ac.getBean("SongDAO");
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Song song = songDAO.find(Integer.valueOf(req.getParameter("id")));
        if (song != null) {
            songDAO.delete(song);
        }

        resp.sendRedirect("/");
    }
}
