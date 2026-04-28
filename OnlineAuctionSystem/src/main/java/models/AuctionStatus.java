package models;

// Enum định nghĩa các trạng thái của phiên đấu giá (Theo yêu cầu mục 3.1.4)
public enum AuctionStatus {
    OPEN,      // Mới mở
    RUNNING,   // Đang diễn ra
    FINISHED,  // Đã kết thúc
    PAID,      // Đã thanh toán
    CANCELED   // Đã hủy
}