package com.epam.lab;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Servlet extends HttpServlet {
    // private String name = "world";
    // private String title = "I'm teapot";

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("start");
        super.init(config);

    // String name = config.getInitParameter("name");
    // if (name != null) {
    // this.name = name;
    // }
    // String title = config.getServletContext().getInitParameter("title");
    // if (title != null) {
    // this.title = title;
    // }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ajaxIsTrue(resp,req);
        resp.getWriter().println("doGet");
        Cookie counterCookie = checkCookie(req);
        counterCookie = addCiickie(counterCookie);
        resp.addCookie(counterCookie);
        resp.getWriter().write(counterCookie.getValue());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ajaxIsTrue(resp,req);

        resp.getWriter().println("doPost");
        Cookie counterCookie = checkCookie(req);
        counterCookie = addCiickie(counterCookie);
        resp.addCookie(counterCookie);
        resp.getWriter().write(counterCookie.getValue());
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ajaxIsTrue(resp,req);
        resp.getWriter().println("doDelete");
        Cookie counterCookie = checkCookie(req);
        // уменьшаем количество
        if (counterCookie != null) {
            int number = Integer.parseInt(counterCookie.getValue()) - 1;
            counterCookie.setValue(Integer.toString(number));
        } else {
            counterCookie = new Cookie("counter", "1");
        }
        resp.addCookie(counterCookie);
        resp.getWriter().write(counterCookie.getValue());


    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ajaxIsTrue(resp,req);
        resp.getWriter().println("doPut");
        Cookie counterCookie = checkCookie(req);
        counterCookie = addCiickie(counterCookie);
        resp.addCookie(counterCookie);
        resp.getWriter().write(counterCookie.getValue());
    }

    private Cookie checkCookie(HttpServletRequest req) {
        Cookie[] requestCookies = req.getCookies();
        Cookie counterCookie = null;
        for (Cookie cookie : requestCookies) {
            if (cookie.getName().equals("counter")) {
                counterCookie = cookie;
                break;
            }
        }
        return counterCookie;
    }

    private Cookie addCiickie(Cookie addC) {
        if (addC != null) {
            int number = Integer.parseInt(addC.getValue()) + 1;
            addC.setValue(Integer.toString(number));
        } else {
            addC = new Cookie("counter", "0");
        }
        return addC;
    }
    private HttpServletResponse ajaxIsTrue(HttpServletResponse resp,HttpServletRequest req) throws ServletException,IOException{
        boolean ajax = "XMLHttpRequest".equals(req.getHeader("X-Requested-With"));
        if (ajax) {
            resp.getWriter().println("it is ajax"+"<br>");
        } else {
            resp.getWriter().println("greet"+"<br>");
            RequestDispatcher rd = req.getRequestDispatcher("WEB-INF\\jsp\\greet.jsp");
            rd.forward(req, resp);
        }
          return resp;
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("destroy method");
    }
}