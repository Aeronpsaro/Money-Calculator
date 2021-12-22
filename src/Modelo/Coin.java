package Modelo;

public class Coin {
    private final String name;
    private final String symbol;
    private final char charSymbol;
    
    public Coin(String newName, String newSymbol, char newCharSymbol) {
        name = newName;
        symbol = newSymbol;
        charSymbol = newCharSymbol;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public char getCharSymbol() {
        return charSymbol;
    }
    
    @Override
    public String toString() {
        return name+" "+charSymbol;
    }   
    
}
