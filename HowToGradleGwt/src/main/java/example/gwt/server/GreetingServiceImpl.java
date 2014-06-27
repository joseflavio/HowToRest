package example.gwt.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import example.gwt.client.GreetingService;
import example.gwt.shared.FieldVerifier;

/**
 * The server-side implementation of the RPC service.
 */
public class GreetingServiceImpl extends RemoteServiceServlet implements GreetingService {

    private static final long serialVersionUID = 5673733253602190120L;

    private static String escapeHtml(final String html) {
        if (html == null) {
            return null;
        }
        return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;");
    }

    @Override
    public String greetServer(final String input) throws IllegalArgumentException {
        // Verify that the input is valid.
        if (!FieldVerifier.isValidName(input)) {
            // If the input is not valid, throw an IllegalArgumentException back
            // to
            // the client.
            throw new IllegalArgumentException("Name must be at least 4 characters long");
        }

        String serverInfo = getServletContext().getServerInfo();
        String userAgent = getThreadLocalRequest().getHeader("User-Agent");

        // Escape data from the client to avoid cross-site script
        // vulnerabilities.
        String output = escapeHtml(input);
        userAgent = escapeHtml(userAgent);

        return "Hello, " + output + "!<br><br>I am running " + serverInfo + ".<br><br>It looks like you are using:<br>"
                + userAgent + " - Hello Hot deploy!";
    }
}
