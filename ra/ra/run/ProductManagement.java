package ra.run;

import ra.dev.Product;

import java.util.Scanner;

public class ProductManagement {
    // khai bao bien toan cuc mang, san pham, va chi so bien cao nhat cua mang san pham
    static Product[] arrProduct = new Product[1000];

    static int index = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("*************MANU************");
            System.out.println("1. nhap thong tin n san pham");
            System.out.println("2. tinh gia ban sp");
            System.out.println("3.hien thi thong tin san pham");
            System.out.println("4. sap xep sp theo gia ban tang dan");
            System.out.println("5: tim kiem sp theo ten sp ");
            System.out.println("6. thong tin so luong sp het hang");
            System.out.println("7. cap nhap trang thai sp");
            System.out.println("8: thoat");
            System.out.println("8: su lua chon cua ban: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    ProductManagement.inputListProduct(scanner);
                    break;
                case 2:
                    ProductManagement.calExportPriceListProduct();
                    break;
                case 3:
                    ProductManagement.displayListProduct();
                    break;
                case 4:
                    ProductManagement.sortListProductByExportPriceASC();
                    break;
                case 5:
                    ProductManagement.searchProductByName(scanner);
                    break;
                case 6:
                    ProductManagement.countProduct();
                    break;
                case 7:
                    ProductManagement.updateStatusProduct(scanner);
                    break;
                case 8:
                    System.exit(0);
                default:
                    System.err.println("vui long nhap tu 1 den 8");
            }


        } while (true);
    }

    public static void inputListProduct(Scanner scanner) {
        System.out.println("nhap vao so sp can nhap thong tin");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            //1.  khoi tao doi tuowng prodct de nhap thong tin;
//            Product pro =  new Product();
//            pro.inputData();
//            arrProduct[index]=pro;
//            index++;
            // cach 2: khoi tao cas phan tu cua mang la mot  doi tuong   product;
            System.out.println("nhap thong tin sp thu " + (i + 1)+ ":\n");
            arrProduct[index] = new Product();
            arrProduct[index].inputData();
            index++;
        }
    }

    public static void calExportPriceListProduct() {
        for (int i = 0; i < index; i++) {
            // tinh gia ban cho tung san pham thu i;
            arrProduct[i].calExportPrice();

        }
        System.out.println("da tinh xong gia ban cua sp");
    }

    public static void displayListProduct() {
        System.out.printf("%-15s%-30s%-30s%-15s%-15s%-10s%-50s%-10s", "Product ID",
                "Product Name: ", "Title: ", "Important Price: ", "Export Price", "Quantity:",
                "Descriptions", "Status: ");
        for (int i = 0; i < index; i++) {
            arrProduct[i].displayData();

        }
    }

    public static void sortListProductByExportPriceASC() {
        for (int i = 0; i < index-1; i++) {
            for (int j = i+1; j < index; j++) {
                if (arrProduct[i].getExportPrice() > arrProduct[j].getExportPrice()) {
                    Product temp = arrProduct[i];
                    arrProduct[i] = arrProduct[j];
                    arrProduct[j] = temp;
                }

            }

        }
        System.out.println(" da xawp xep cac sp theo gia ban tang dan");
    }

    public static void searchProductByName(Scanner scanner) {
        System.out.println("nhap vao ten sap phm can tim: ");
        String strSearch = scanner.nextLine();
        System.out.printf("%-15s%-30s%-30s%-15s%-15s%-10s%-50s%-10s\n", "Product ID",
                "Product Name: ", "Title: ", "Important Price: ", "Export price", "Quantity:",
                "Descriptions", "Status: ");
        for (int i = 0; i < index; i++) {
            if (arrProduct[i].getProductName().startsWith(strSearch)) {
                arrProduct[i].displayData();

            }
        }

    }

    public static void countProduct() {
        int count = 0;
        System.out.printf("%-15s%-30s%-30s%-15s%-15s%-10s%-50s%-10s\n", "Product ID",
                "Product Name: ", "Title: ", "Important Price: ", "export price", "Quantity:",
                "Descriptions", "Status: ");
        for (int i = 0; i < index; i++) {
            if (arrProduct[i].getQuantity() <= 5) {
                count++;
                arrProduct[i].displayData();
            }
        }
        System.out.printf("co %d sp sap het hang\n", count);
    }

    public static void updateStatusProduct(Scanner scanner) {
        String strUpdate = " ";
        System.out.println("nhap vao nhuwng sp can cap nhap trang thai:");
         strUpdate = scanner.nextLine();
        for (int i = 0; i < index; i++) {
            if (arrProduct[i].getProductId().equals(strUpdate)) {
                // cap nhap trang thai cua sp   arrProduct;
                arrProduct[i].setProductStatus(!arrProduct[i].isProductStatus());

            }
        }
        System.out.println("da cap nhap thanh cong trang thai cua san pham");

    }
}

