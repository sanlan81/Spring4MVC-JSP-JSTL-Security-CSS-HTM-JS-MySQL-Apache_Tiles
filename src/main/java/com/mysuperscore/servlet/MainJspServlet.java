/*
package com.mysuperscore.servlet;

import com.mysuperscore.dao.SongDAO;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("")
public class MainJspServlet extends HttpServlet {
    private SongDAO songDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {

        super.init(config);

        ApplicationContext ac = (ApplicationContext) config.getServletContext().getAttribute("applicationContext");
        songDAO = (SongDAO)ac.getBean("SongDAO");
        songDAO.createTable();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("songs", songDAO.findAll());
        getServletContext().getRequestDispatcher("/pages/index.jsp").forward(req, resp);
    }
}
*/
