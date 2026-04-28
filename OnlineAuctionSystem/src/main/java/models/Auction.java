package models;
import utils.InvalidBidException;
public class Auction {
    private String itemName;
    private double currentPrice;
    private String currentWinner = "Không có";
    private AuctionStatus status; // OPEN, RUNNING, FINISHED, PAID, CANCELED
    public Auction(String name, double price) {
        this.itemName = name;
        this.currentPrice = price;
        this.status = AuctionStatus.OPEN; // Mới tạo là OPEN
    }
    public synchronized void placeBid(String bidder, double amount) throws InvalidBidException {
        // RÀO CHẮN 1: Chỉ cho đặt giá khi đang RUNNING
        if (status != AuctionStatus.RUNNING) {
            throw new InvalidBidException("⚠️ Hiện tại không phải thời gian đặt giá (Trạng thái: " + status + ")");
        }
        // RÀO CHẮN 2: Giá phải cao hơn giá hiện tại
        if (amount <= currentPrice) {
            throw new InvalidBidException("⚠️ Giá " + amount + "$ phải lớn hơn giá hiện tại " + currentPrice + "$");
        }
        this.currentPrice = amount;
        this.currentWinner = bidder;
    }
    // Getters & Setters
    public String getItemName() { return itemName; }
    public double getCurrentPrice() { return currentPrice; }
    public String getCurrentWinner() { return currentWinner; }
    public AuctionStatus getStatus() { return status; }
    public void setStatus(AuctionStatus status) { this.status = status; }
    public boolean placeBid(BidTransaction bidTransaction){
        try {
            // 1. Lấy thông tin từ đối tượng bidTransaction
            // (Lưu ý: Bạn có thể cần sửa getUsername() hoặc getId() tùy vào cách bạn viết class User)
            String bidder = bidTransaction.getBidderName();
            double amount = bidTransaction.getBidAmount();

            // 2. Gọi lại hàm placeBid (String, double) ở dòng 13
            this.placeBid(bidder, amount);

            // 3. Nếu hàm trên chạy mượt mà (không văng lỗi), nghĩa là đặt giá thành công -> trả về true
            return true;

        } catch (InvalidBidException e) {
            // 4. Nếu bắt được lỗi InvalidBidException (giá thấp hơn, sai thời gian...) -> đặt giá thất bại -> trả về false
            System.out.println(e.getMessage()); // In ra lỗi để dễ debug (tùy chọn)
            return false;
        }
    }
}