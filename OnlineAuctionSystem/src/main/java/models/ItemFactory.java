package models;

public class ItemFactory {
    public static Item createItem(String type, String name, String desc, double price) {
        if (type == null) return new Item(name, desc, price);

        // Chuyển đổi loại sản phẩm tương ứng
        switch (type.toLowerCase()) {
            case "electronics":
                return new Electronics(name, desc, price);
            case "art":
                return new Art(name, desc, price);
            case "vehicle":
                return new Vehicle(name, desc, price);
            default:
                return new Item(name, desc, price);
        }
    }
}