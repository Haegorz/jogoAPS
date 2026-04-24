package APS;

import java.util.Scanner;

public class inputTradutor {

    public String inputHandler(Scanner sc) {

        String line = sc.nextLine().toLowerCase();

        if (line.equals("n")) return "NORTE";
        if (line.equals("s")) return "SUL";
        if (line.equals("l")) return "LESTE";
        if (line.equals("o")) return "OESTE";

        if (line.equals("norte")) return "NORTE";
        if (line.equals("sul")) return "SUL";
        if (line.equals("leste")) return "LESTE";
        if (line.equals("oeste")) return "OESTE";

        return line.toUpperCase();
    }
}