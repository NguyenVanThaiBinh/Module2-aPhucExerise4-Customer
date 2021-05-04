package com.CustomerManage.model;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerObject {
    Scanner sc = new Scanner(System.in);
    Scanner sc1 = new Scanner(System.in);
    Scanner sc2 = new Scanner(System.in);
    Scanner sc3 = new Scanner(System.in);
    private String name, address, email, gender;
    private int telephone, id, countToBuy;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCountToBuy() {
        return countToBuy;
    }

    public void setCountToBuy(int countToBuy) {
        this.countToBuy = countToBuy;
    }

    public CustomerObject() {
    }

    @Override
    public String toString() {
        return " id=" + id +","+
                " name=" + name +","+
                " address=" + address +","+
                " email=" + email+","+
                " gender=" + gender+","+
                " telephone= 0" + telephone +","+
                " countToBuy= " + countToBuy+" .";
    }

    public CustomerObject(int id, String name, String address, String email, int telephone, String gender, int countToBuy) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.gender = gender;
        this.telephone = telephone;
        this.id = id;
        this.countToBuy = countToBuy;
    }

    public void inputCustomer() {
        System.out.println("Nhập tên:");
        this.name = sc.nextLine();
        System.out.println("Nhập dia chi:");
        this.address = sc1.nextLine();


        String regexEmail ="^\\w[a-z0-9]*@[a-z0-9]*.[a-z0-9]*$";
//        ^\w+ start by  one character
//        [a-z0-9]*  number or character, free length
//        \w     sum with character
//        mail.com$  the last must be 'mail.com$'
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap email:");
        this.email = sc2.nextLine();
        Pattern pattern = Pattern.compile(regexEmail);
        Matcher matcher = pattern.matcher(this.email);

        while(!matcher.find()){

            System.out.println("Please input right format for email!");
            this.email= sc.nextLine();
            matcher = pattern.matcher(this.email);
        }


        Scanner sc1;
        sc1 = new Scanner(System.in);
        String regex = "^0+[1-9]\\d{8}$";
        System.out.println("Nhap sdt khach hang:");

        String telephone = sc1.nextLine();
        Pattern pattern1 = Pattern.compile(regex);
        Matcher matcher1 = pattern1.matcher(telephone);

        while (!matcher1.find()) {

            System.out.println("Lam on nhap cho dung!");
            telephone = sc1.nextLine();
            matcher1 = pattern1.matcher(telephone);
        }
        this.telephone = Integer.parseInt(telephone);


        System.out.println("Nhap gioi tinh");
        this.gender = sc.nextLine();
    }

    public String toCSVFormat() {
        return id + ", " + name + ", " + address + ", " + email + ", " + telephone + ", " + gender + ", "
                + countToBuy + "\n";
    }


}
