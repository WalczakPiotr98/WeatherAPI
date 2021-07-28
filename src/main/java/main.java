import java.util.Scanner;

public class main {
    public static void main(String[] args) throws Exception {
        URLConnector cr = new URLConnector();
        XMLReader xmlR = new XMLReader();
        Input inp = new Input();
        xmlR.parse(cr.get(inp.getInput()));
    }
}
