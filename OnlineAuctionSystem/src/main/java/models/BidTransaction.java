package models;

public class BidTransaction {
    private String bidderName;
    private double bidAmount;

    public BidTransaction(String name, double amount) {
        this.bidderName = name;
        this.bidAmount = amount;
    }

    public String getBidderName() { return bidderName; }
    public double getBidAmount() { return bidAmount; }
}