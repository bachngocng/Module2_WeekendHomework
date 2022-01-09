package com.codegym;



import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Products[] product = new Products[10];
        List<Products> productsList = new ArrayList<>();
        productsList.add(new Products(1, "IPhone 13 Pro Max", 43000000, "Siêu phẩm nhà Táo"));
        productsList.add(new Products(2, "Samsung Galaxy Z Fold", 41500000, "Siêu phẩm màn gập"));
        productsList.add(new Products(3, "Xiaomi 11T Pro", 13790000, "Điện thoại phân khúc tầm trung"));
        productsList.add(new Products(4, "Oppo Reno6", 12990000, "Điện thoại phân khúc tầm trung"));
        productsList.add(new Products(5, "Realme 8", 7290000, "Điện thoại phân khúc bình dân"));
        // Hiển thị danh sách sản phẩm
        System.out.println("Danh sách sản phẩm: ");
        for (int i = 0; i < productsList.size(); i++) {
            System.out.println(productsList.get(i).toString());
        }

        int choice;
        System.out.println("Danh sách sản phẩm");
        System.out.println("1. Thêm Sản phẩm");
        System.out.println("2. Xóa sản phẩm");
        System.out.println("3. Tìm kiếm sản phẩm");
        System.out.println("4. Sắp xếp sản phẩm");// chưa viết xong
        System.out.println("5. Cập nhật sản phẩm");
        System.out.println("0. Thoát");
        do {
            System.out.println("Nhập lựa chọn của bạn: ");
            choice = Integer.parseInt(sc.nextLine());
            System.out.println(choice + "");
            if (choice > 5) {
                System.out.println("Menu chỉ có 5 lựa chọn");
            }
        }
        while (choice > 5 && choice <0);
        switch (choice) {
            case 1: {
                System.out.println("Nhập tên sản phẩm mới: ");
                String newName = sc.nextLine();
                System.out.println("Nhập giá sản phẩm mới: ");
                long newPrice = Long.parseLong(sc.nextLine());
                System.out.println("Nhập mô tả sản phẩm mới: ");
                String newDescription = sc.nextLine();
                List<Products> newProducts = new ArrayList<>();
                Products newProduct = new Products(6, newName, newPrice, newDescription);
                System.out.println("\nDanh sách sau khi thêm sản phẩm: ");
                newProducts = themSanPham(productsList, 5, newProduct);
                for (int i = 0; i < newProducts.size(); i++) {
                    System.out.println(newProducts.get(i).toString());
                }
                break;
            }
            case 2: {
                // Gọi hàm xóa sản phẩm
                System.out.print("Nhập vị trí sản phẩm muốn xóa: ");
                int index2 = sc.nextInt();
                List<Products> newProduct = new ArrayList<>();
                newProduct = xoaSanPham(productsList, index2 - 1);
                System.out.println("\nMảng sau khi xóa sản phẩm: ");
                for (int i = 0; i < newProduct.size(); i++) {
                    System.out.println(newProduct.get(i).toString());
                }
                break;
            }
            case 3: {
                // Tìm kiếm sản phẩm theo tên
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("Nhập tên sản phẩm muốn tìm");
                String name = scanner1.nextLine();
                int index = timKiemSanPham(productsList, name);
                if (index == -1) {
                    System.out.println("Sản phẩm không có trong danh sách");
                } else {
                    System.out.println(productsList.get(index).toString());
                }
                break;
            }
            case 4: {
                // Gọi hàm sắp xếp tên sản phẩm tử A-Z
                sapXepSanPham(productsList);
                for(Products products : productsList){
                    System.out.println(products);
                }
                break;
            }
            case 5:
                //Goi ham cap nhat gia, ten
                System.out.println("Thứ tự sản phẩm muốn cập nhật:");
                int index = Integer.parseInt(sc.nextLine());
                System.out.println("Nhập tên mới: ");
                String newName = new String(sc.nextLine());

                System.out.println("Nhập giá mới: ");
                Long newPrice = new Long(Long.parseLong(sc.nextLine()));
                List<Products> newDanhSach = updateSanPham(productsList, index, newPrice, newName);

                for(Products products : newDanhSach){
                    System.out.println(products);
                }
        }
    }


    public static List<Products> themSanPham(List<Products> array, int index, Products product) { //hàm thêm sản phẩm
//        Products[] newArr = new Products[array.length + 1];
//        for (int i = 0; i < array.length; i++) {
//            if (i < index) {
//                newArr[i] = array[i];
//            } else if (i == index) {
//                newArr[i] = product ;
//            } else {
//                newArr[i] = array[i - 1];
//            }
//        }
        array.add(product);
        return array;
    }


    public static List<Products> xoaSanPham(List<Products> array, int index) {
        List<Products> newArray = new ArrayList<>();
        System.out.println(array.size() + "");
        for (int i = 0; i < array.size() ; i++) {
            if (i != index) {
                newArray.add(array.get(i));
            }
        }
        return newArray;
    }

    public static int timKiemSanPham(List<Products> arr, String name) {
        int index = -1;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getName().equals(name)) {
                index = i;
            }
        }
        return index;
    }

    public static List<Products> updateSanPham(List<Products> arr, int index, long newPrice, String newName) {
        arr.get(index).setPrice(newPrice);
        arr.get(index).setName(newName);
        return arr;
    }

       public static List sapXepSanPham(List arr) {
        List<Products> ketQua = new ArrayList<>();
        Collections.sort(arr);
        return arr;
    }
}