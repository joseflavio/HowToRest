package example.gwt.shared;

public class FieldVerifier {

    public static boolean isValidName(final String name) {
        if (name == null) {
            return false;
        }
        return name.length() > 3;
    }

}
