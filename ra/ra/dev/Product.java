package ra.dev;

import java.util.Scanner;

public class Product {
    // 1. thuoc tinh
    private String productId;
    private String productName;
    private String title;
    private float importPrice;
    private float exportPrice;
    private int quantity;
    private String descriptions;
    private boolean productStatus;
    //2 cac ham tao

    public Product() {

    }

    public Product(String Id, String Name, String title,
                   float importPrice, float exportPrice, int quantity,
                   String descriptions, boolean productStatus) {
        // khoi tao cac thuoc tinh cho doi tuong

        this.productId = Id;
        this.productName = Name;
        this.title = title;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.quantity = quantity;
        this.descriptions = descriptions;
        this.productStatus = productStatus;


    }

    // 3 : cac thuoc tinh
// 3.1 : getter/ setter
    public String getProductId() {
        return this.productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    // 3.2: viet cac huong thuc
    public void inputData() {
        // khoi tao dooi tuong scanner tuwf lowps jajva
        Scanner scanner = new Scanner(System.in);

        System.out.println("nhap vao ma san pham: ");
        this.productId = scanner.nextLine();

        System.out.println("nhap vao ten san pham: ");
        this.productName = scanner.nextLine();

        System.out.println("nhap vao tieu de san pham: ");
        this.title = scanner.nextLine();

        System.out.println("nhap vao gia ban san pham: ");
        this.importPrice = Float.parseFloat(scanner.nextLine());

        System.out.println("nhap vao so luong san pham: ");
        this.quantity = Integer.parseInt(scanner.nextLine());

        System.out.println("nhap vao mo ta san pham: ");
        this.descriptions = scanner.nextLine();

        System.out.println("nhap vao trang thai san pham: ");
        this.productStatus = Boolean.parseBoolean(scanner.nextLine());

    }

    public void calExportPrice() {
        this.exportPrice = this.importPrice*1.2F;
    }

    public void displayData() {
        System.out.printf("%-15s%-30s%-30s%-15f%-15f%-10d%-50s%-10b\n ", this.productId,
                this.productName, this.title, this.importPrice, this.exportPrice, this.quantity, this.descriptions, this.productStatus);


    }
}
