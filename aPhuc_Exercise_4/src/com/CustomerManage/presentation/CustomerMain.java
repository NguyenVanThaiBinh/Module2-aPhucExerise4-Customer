package com.CustomerManage.presentation;

import com.CustomerManage.service.CustomerService;

import java.io.IOException;
import java.util.Scanner;

public class CustomerMain {
    public static void main(String[] args) {

        CustomerService customerService = new CustomerService();
        Scanner sc= new Scanner(System.in);

        try {
            customerService.loadFileCustomer();
        } catch (IOException e) {
            System.err.println("Customer Manager File is Empty!");
        }
        int choose;


        do{
            showMenu();
            choose = sc.nextInt();
            switch (choose){
                case 1:
                    try {
                        customerService.addCustomer();
                    } catch (IOException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        customerService.editCustomer();
                    } catch (IOException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        customerService.sortCustomerByCountToBuy();
                    } catch (IOException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        customerService.showAllCustomer();
                    } catch (IOException e) {
                        System.err.println("Customer Manager File is Empty!");
                    }
                    break;
                case 5:
                    try {
                        customerService.increaseCustomerBought();
                    } catch (IOException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 6:
                    customerService.searchCustomer();
                    break;
                case 7:
                    try {
                        customerService.deleteCustomer();
                    } catch (IOException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 0:
                    System.out.println("He thong Quan ly khach hang vua shutdown.");
                    break;
                default:
                    System.out.println("Moi nhap lai!");
                    System.out.println("------------");
                    break;
            }
        }while (choose !=0);


    }
    public  static void showMenu(){
        System.out.println(
                """
                        Chao mung ban den voi he thong quan ly khach hang
                        Bấm 1 để nhập khách hang
                        Bấm 2 để sua chua khach hang
                        Bam 3 sap xep theo so luong don hang da mua
                        Bam 4 de in toan bo danh sach khach hang
                        Bam 5 de tang so don hang cho khach
                        Bam 6 de tim kiem khac hang
                        Bam 7 de xoa khac hang
                        Bam 0 de thoat
                        ==========================================

                        """);
    }
}
