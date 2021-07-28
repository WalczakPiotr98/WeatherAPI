import org.javatuples.Triplet;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLConnector {
    public static String get(Triplet<Float , Float, Integer> x) throws Exception {
        float lat = x.getValue0();
        float lon = x.getValue1();
        int num_of_days = x.getValue2();
        URL oracle = new URL("http://api.worldweatheronline.com/premium/v1/weather.ashx?key=c500c3211dd64abfa5f222142211206&q=" + lat + "," + lon + "&num_of_days=" + num_of_days + "&tp=3&format=xml");
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        while ((line = in.readLine()) != null) {
            stringBuilder.append(line);
        }
        String str = stringBuilder.toString();
        in.close();
        return str;
    }
}