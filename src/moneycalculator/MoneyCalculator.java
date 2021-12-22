package moneycalculator;

import GUI.GUIPanel;
import Modelo.Coin;
import Modelo.Money;
import java.io.File;
import java.util.List;

public class MoneyCalculator {
    private Coin source;
    private Coin destination;
    private double initAmmount;
    private final List<Coin> coins;
    private final File coinsFile = new File("coins.txt");

    public List<Coin> getCoins() {
        return coins;
    }
    
    public MoneyCalculator() {
        coins = BootFile.initializeCoins(coinsFile);
    }

    public Coin getSource() {
        return source;
    }

    public void setSource(Coin source) {
        this.source = source;
    }

    public Coin getDestination() {
        return destination;
    }

    public void setDestination(Coin destination) {
        this.destination = destination;
    }

    public double getInitAmmount() {
        return initAmmount;
    }

    public void setInitAmmount(double initAmmount) {
        this.initAmmount = initAmmount;
    }

    public Money getFinalAmmount() {
        Money from = new Money(initAmmount, source);
        if (source == destination) return from;
        Money to = from.exchange(destination);
        return to;
    }

    public static void main(String[] args) {
        MoneyCalculator control = new MoneyCalculator();
        GUIPanel gui = new GUIPanel(control);
        gui.setVisible(true);
    }
}
