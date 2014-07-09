package org.howto;

import java.io.BufferedReader;
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
public final class TestServlet extends HttpServlet {

    private static final long serialVersionUID = -1331165769691641960L;

    private static final Logger logger = LoggerFactory.getLogger(TestServlet.class);

    @Override
    public void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException,
            IOException {

        logger.debug("doGet - enter");

        try (final PrintWriter out = response.getWriter()) {
            String simpleParam = request.getParameter("value");
            out.println("Hello Get World " + simpleParam);
        }

    }

    @Override
    public void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException,
            IOException {

        logger.debug("doPost - enter");

        String content = new String();
        try (final BufferedReader requestReader = request.getReader()) {
            String line = null;
            while ((line = requestReader.readLine()) != null) {
                content += line;
                content += "\n";
            }
        }

        logger.debug("content=" + content);

        try (final PrintWriter out = response.getWriter()) {
            out.println("Hello Post World " + content);
        }

    }

}// class
