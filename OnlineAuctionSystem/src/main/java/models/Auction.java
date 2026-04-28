package models;
import utils.InvalidBidException;
public class Auction {
    private String itemName;
    private double currentPrice;
    private String currentWinner = "Không có";
    private AuctionStatus status;
    public Auction(String name, double price) {
        this.itemName = name;
        this.currentPrice = price;
        this.status = AuctionStatus.OPEN;
    }
    public synchronized void placeBid(String bidder, double amount) throws InvalidBidException {
        if (status != AuctionStatus.RUNNING) {
            throw new InvalidBidException("⚠️ Hiện tại không phải thời gian đặt giá (Trạng thái: " + status + ")");
        }
        if (amount <= currentPrice) {
            throw new InvalidBidException("⚠️ Giá " + amount + "$ phải lớn hơn giá hiện tại " + currentPrice + "$");
        }
        this.currentPrice = amount;
        this.currentWinner = bidder;
    }
    public String getItemName() { return itemName; }
    public double getCurrentPrice() { return currentPrice; }
    public String getCurrentWinner() { return currentWinner; }
    public AuctionStatus getStatus() { return status; }
    public void setStatus(AuctionStatus status) { this.status = status; }
    public boolean placeBid(BidTransaction bidTransaction){
        try {
            String bidder = bidTransaction.getBidderName();
            double amount = bidTransaction.getBidAmount();
            
            this.placeBid(bidder, amount);

            return true;

        } catch (InvalidBidException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
