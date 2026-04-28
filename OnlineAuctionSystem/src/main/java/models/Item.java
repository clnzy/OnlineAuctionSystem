package models;

public class Item {
    protected String name;
    protected String description;
    protected double startingPrice;

    public Item() {}

    public Item(String name, String description, double startingPrice) {
        this.name = name;
        this.description = description;
        this.startingPrice = startingPrice;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public double getStartingPrice() { return startingPrice; }
}

class Electronics extends Item {
    public Electronics(String n, String d, double p) { super(n, d, p); }
}

class Art extends Item {
    public Art(String n, String d, double p) { super(n, d, p); }
}

class Vehicle extends Item {
    public Vehicle(String n, String d, double p) { super(n, d, p); }
}
