import java.util.*;

class Product {
    int id;
    String name, category;

    Product(int id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Category: " + category);
    }
}

public class ProductSearch {

    // Linear Search by product name
    static int linearSearch(Product[] products, String target) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].name.equalsIgnoreCase(target)) {
                return i;
            }
        }
        return -1;
    }

    // Binary Search by product name
    static int binarySearch(Product[] products, String target) {
        Arrays.sort(products, Comparator.comparing(p -> p.name.toLowerCase()));
        int low = 0, high = products.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = products[mid].name.compareToIgnoreCase(target);
            if (cmp == 0) return mid;
            else if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Shoes", "Footwear"),
            new Product(103, "Watch", "Accessories"),
            new Product(104, "Mobile", "Electronics"),
            new Product(105, "Headphones", "Electronics")
        };

        String target = "Shoes";

        System.out.println("Linear Search:");
        int lin = linearSearch(products, target);
        if (lin != -1) products[lin].display();
        else System.out.println("Product not found");

        System.out.println("\nBinary Search:");
        int bin = binarySearch(products, target);
        if (bin != -1) products[bin].display();
        else System.out.println("Product not found");
    }
}
