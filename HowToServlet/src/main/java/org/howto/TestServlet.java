package org.howto;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/testServlet")
public class TestServlet extends HttpServlet {

    private static final long serialVersionUID = -1331165769691641960L;

    private static final Logger logger = LoggerFactory.getLogger(TestServlet.class);

    @Override
    public void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException,
            IOException {
        TestServlet.logger.debug("doGet - enter");
        try (PrintWriter out = response.getWriter()) {
            String simpleParam = request.getParameter("name");
            out.println("Hello World " + simpleParam);
        }
    }

}// class
