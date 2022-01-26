package Vista;

import Modelo.Coin;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BootFile {
    public static List<Coin> initializeCoins(File file) {
        try {
            ArrayList<Coin> coins = new ArrayList<Coin>();
            Scanner coinReader = new Scanner(file);
            while (coinReader.hasNext()) {
                String coin = coinReader.nextLine();
                String[] coinFields = coin.split(", ");
                coins.add(new Coin(coinFields[1],coinFields[0],coinFields[2].charAt(0)));
            }
            coinReader.close();
            return coins;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BootFile.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
