package com.servlet;

import com.pojo.People;
import com.service.PeopleService;
import com.service.impl.PeopleServiceImpl;
import com.sun.org.apache.regexp.internal.RE;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowServlet",urlPatterns = "/show")
public class ShowServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PeopleService peopleService=new PeopleServiceImpl();
        List<People> list = peopleService.show();
        req.setAttribute("list",list);
        req.getRequestDispatcher("/index.jsp").forward(req,resp);

    }
}
