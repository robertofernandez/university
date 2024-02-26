package studio.sodhium.academic.utils;

public class LaTexUtils {

    public static String printLaTexEcuation(String ecuation) {
        String clean = escapeLaTexBrackets(ecuation);
        return "\\begin{equation}\n" + clean + "\n\\end{equation}";
    }
    
    public static String escapeLaTexBrackets(String ecuation) {
        String output = ecuation.replace("{", "\\{");
        output = output.replace("}", "\\}");
        return output;
    }
}
