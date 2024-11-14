import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Garment {
    public String id;
    public String name;
    public String description;
    public String size;
    public String color;
    public double price;
    public int stockQuantity;

    public Garment(String id, String name, String description, String size, String color, double price, int stockQuantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.size = size;
        this.color = color;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    Garment() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    void updateStock(int quantity) {
        this.stockQuantity = quantity;
    }

    double calculateDiscountPrice(double discountPercentage) {
        double discount = price * (discountPercentage / 100);
        return price - discount;
    }
}

class Fabric {
    public String id;
    public String type;
    public String color;
    public double pricePerMeter;

    public Fabric(String id, String type, String color, double pricePerMeter) {
        this.id = id;
        this.type = type;
        this.color = color;
        this.pricePerMeter = pricePerMeter;
    }

    double calculateCost(double meters) {
        return pricePerMeter * meters;
    }
}

class Supplier {
    public String id;
    public String name;
    public String contactInfo;
    private List<Fabric> suppliedFabrics = new ArrayList<>();

    public Supplier(String id, String name, String contactInfo) {
        this.id = id;
        this.name = name;
        this.contactInfo = contactInfo;
    }

    void addFabric(Fabric fabric) {
        suppliedFabrics.add(fabric);
    }

    List<Fabric> getSuppliedFabrics() {
        return suppliedFabrics;
    }
}

class Order {
    public String orderId;
    public Date orderDate;
    private List<Garment> garments = new ArrayList<>();
    private double totalAmount;

    public Order(String orderId, Date orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    void addGarment(Garment garment) {
        garments.add(garment);
    }

    double calculateTotalAmount() {
        totalAmount = 0;
        for (Garment g : garments) {
            totalAmount += g.price;
        }
        return totalAmount;
    }

    void printOrderDetails() {
        System.out.println("--------------------------");
        System.out.println("Order Details");
        System.out.println("--------------------------");
        for (Garment g : garments) {
            System.out.println("Name: " + g.name);
            System.out.println("Price: " + g.price);
            System.out.println("Description: " + g.description);
            System.out.println("--------------------------");
        }
    }
}

class Customer {
    public String customerId;
    public String name;
    public String email;
    public String phone;

    public Customer(String customerId, String name, String email, String phone) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    void placeOrder(Order order) {
        order.printOrderDetails();
        System.out.println("Order Placed");
    }
}

class Inventory {
    private List<Garment> garments = new ArrayList<>();

    public Inventory() {
    }

    void addGarment(Garment garment) {
        garments.add(garment);
    }

    void removeGarment(String id) {
        garments.removeIf(g -> g.id.equals(id));
    }

    Garment findGarment(String id) {
        for (Garment g : garments) {
            if (g.id.equals(id)) {
                return g;
            }
        }
        return null;
    }
}

public class OopLabTask3 {

    public static void main(String[] args) {
        Garment g1 = new Garment();
        g1.name = "Silk";
        g1.description = "Good Product";
        g1.price= 600;
        double x = g1.calculateDiscountPrice(10);
        System.out.println(x);

    }

}