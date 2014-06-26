package example.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hello extends HttpServlet {

    private static final long serialVersionUID = 5673733253605290120L;

    private static final Logger logger = LoggerFactory.getLogger(Hello.class);

    private static final String message = "Hello world1234";

    @Override
    public void destroy() {
        // do nothing.
    }

    @Override
    public void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException,
            IOException {

        logger.trace("doGet - enter");

        // Set response content type
        response.setContentType("text/html");

        // Actual logic goes here.
        try (PrintWriter out = response.getWriter()) {
            out.println("<h1>" + message + "</h1>");
        }
    }

}// class
