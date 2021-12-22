package Modelo;

import moneycalculator.WebExchange;

public class Money {
    private final double ammount;
    private final Coin coin;
    
    public Money(double newAmmount, Coin newCoin) {
        ammount = newAmmount;
        coin = newCoin;
    }
    
    public Money exchange(Coin to) {
        if (to==null) return this;
        double exchangeRate = WebExchange.exchangeSearch(this.coin, to);
        Money result = new Money(ammount*exchangeRate, to);
        return result;
    }
    
    @Override
    public String toString() {
        String ammountString = Double.toString(ammount);
        ammountString = ammountString.substring(0, Math.min(9, ammountString.length()));
        return ammountString+coin.getCharSymbol();
    }
}
