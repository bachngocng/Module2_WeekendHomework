package com.codegym;

import java.lang.reflect.Array;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Products[] product = new Products[10];
        product[1] = new Products(1, "IPhone 13 Pro Max", 43000000, "Siêu phẩm nhà Táo");
        product[2] = new Products(2, "Samsung Galaxy Z Fold", 41500000, "Siêu phẩm màn gập");
        product[3] = new Products(3, "Xiaomi 11T Pro", 13790000, "Điện thoại phân khúc tầm trung");
        product[4] = new Products(4, "Oppo Reno6", 12990000, "Điện thoại phân khúc tầm trung");
        product[5] = new Products(5, "Realme 8", 7290000, "Điện thoại phân khúc bình dân");
        // Hiển thị danh sách sản phẩm
        System.out.println("Danh sách sản phẩm: ");
        for (int i = 0; i < product.length; i++) {
            System.out.println(product[i].toString());
        }

        int choice;
        System.out.println("Danh sách sản phẩm");
        System.out.println("1. Thêm Sản phẩm");
        System.out.println("2. Xóa sản phẩm");
        System.out.println("3. Tìm kiếm sản phẩm");
        System.out.println("4. Sắp xếp sản phẩm");
        System.out.println("5. Cập nhật sản phẩm");
        System.out.println("0. Thoát");
        System.out.println("Nhập lựa chọn: ");
        do {
            System.out.println("Nhập lựa chọn của bạn: ");
            choice = sc.nextInt();
            if (choice > 5) {
                System.out.println("Menu chỉ có 5 lựa chọn");
            }
        }
        while (choice > 0);
        switch (choice) {
            case 1: {
                System.out.println("Nhập tên sản phẩm mới: ");
                String newName = sc.nextLine();
                System.out.println("Nhập giá sản phẩm mới");
                double newPrice = sc.nextDouble();
                System.out.println("Nhập mô tả sản phẩm mới: ");
                String newDiscription = sc.nextLine();
                Products[] newProducts = new Products[product.length + 1];
                Products newProduct = new Products(6, newName, newPrice, newDiscription);
                System.out.println("\nDanh sách sau khi thêm sản phẩm: ");
                newProducts = themSanPham(product, 5, newProduct);
                for (int i = 0; i < newProducts.length; i++) {
                    System.out.println(newProducts[i].toString());
                    break;
                }
            }
            case 2: {
                // Gọi hàm xóa sản phẩm
                System.out.print("Nhập vị trí sản phẩm muốn xóa: ");
                int index2 = sc.nextInt();
                Products[] newProduct = new Products[4];
                newProduct = xoaSanPham(String []product (), index2 - 1);
                System.out.println("\nMảng sau khi xóa sản phẩm: ");
                for (int i = 0; i < newProduct.length; i++) {
                    System.out.println(newProduct[i].toString());
                }
                break;
            }
            case 3: {
                // Tìm kiếm sản phẩm theo tên
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("Nhập tên sản phẩm muốn tìm");
                String name = scanner1.nextLine();
                int index = timKiemSanPham(product, name);
                if (index == -1) {
                    System.out.println("Sản phẩm không có trong danh sách");
                } else {
                    System.out.println(product[index].toString());
                }
                break;
            }
            case 4: {
                // Gọi hàm sắp xếp tên sản phẩm tử A-Z
                Array.sort(product);
                System.out.println("Mảng sau khi sắp xếp theo thứ tự id: ");
                for (int i = 0; i < product.length; i++) {
                    System.out.println(product[i].toString());
                }
                break;
            }
            case 5:


        }
    }


    public static String[] themSanPham(String[] array, int index, String value) { //hàm thêm sản phẩm
        String[] newArr = new String[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            if (i < index) {
                newArr[i] = array[i];
            } else if (i == index) {
                newArr[i] = value;
            } else {
                newArr[i] = array[i - 1];
            }
        }
        return newArr;
    }


    public static String[] xoaSanPham(String[] array, int index) {
        String[] newArray = new String[array.length - 1];
        for (int i = 0; i < newArray.length; i++) {
            if (i < index) {
                newArray[i] = array[i];
            } else {
                newArray[i] = array[i + 1];
            }
        }
        return newArray;
    }

    public static int timKiemSanPham(Products[] arr, String name) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getName().equals(name)) {
                index = i;
            }
        }
        return index;
    }

    public static Products[] changePrice(Products[] arr, int index, int newPrice) {
        arr[index].setPrice(newPrice);
        return arr;
    }

    public static Products[] changeName(Products[] arr, int index, String newName) {
        arr[index].setName(newName);
        return arr;
    }
}