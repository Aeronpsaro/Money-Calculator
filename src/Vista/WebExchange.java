package Vista;

import Modelo.Coin;
import java.io.IOException;
import static java.lang.Double.parseDouble;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WebExchange {
    private final static String exchangeService = "https://cdn.jsdelivr.net/gh/fawazahmed0/currency-api@1/latest/currencies/";
    
    private static String readWeb(URL url) throws IOException {
        Scanner sc = new Scanner(url.openStream());
        StringBuilder sb = new StringBuilder();
        while (sc.hasNext()) {
            sb.append(sc.next());
        }
        String result = sb.toString();
        return result.replaceAll("<[^>]*>", ""); 
    }
    
    public static double exchangeSearch(Coin from, Coin to) {
        try {
            URL url = new URL(exchangeService+from.getSymbol().toLowerCase()+"/"+to.getSymbol().toLowerCase()+".json");
            String rawExchange = readWeb(url);
            double exchangeRate = parseDouble(rawExchange.split(":")[2].replaceAll("}", ""));
            return exchangeRate;
        } catch (IOException ex) {
            Logger.getLogger(WebExchange.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
}
