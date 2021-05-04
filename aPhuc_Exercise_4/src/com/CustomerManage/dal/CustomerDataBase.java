package com.CustomerManage.dal;

import com.CustomerManage.model.CustomerObject;

import java.io.*;
import java.util.LinkedList;

public class CustomerDataBase {

    public static LinkedList<CustomerObject> customerLinkedList = new LinkedList<>();

    public void loadFileCustomer() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("CustomerList.csv"));
        String line;
        while ((line = bufferedReader.readLine()) != null) {


            String[] arr = line.split(",");
            if (arr[0].equals("ID")) {
                continue;
            }
//           (int id,String name, String address, String email, int telephone, String gender,  int countToBuy)
            try {
                CustomerObject customerObject = new CustomerObject(Integer.parseInt(arr[0].trim()), arr[1], arr[2],
                        arr[3], Integer.parseInt(arr[4].trim()), arr[5], Integer.parseInt(arr[6].trim()));


                customerLinkedList.add(customerObject);
            } catch (ArrayIndexOutOfBoundsException ignored) {

            }
        }
    }

    public void saveFileCustomer() throws IOException {

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("CustomerList.csv"));
        String CSVHeader = "ID, Khach hang, Dia chi, Email, Sdt,Gioi tinh ,So don da mua\n";
        bufferedWriter.write(CSVHeader);

        for (CustomerObject customer : customerLinkedList) {
            String line = customer.toCSVFormat();
            bufferedWriter.write(line);
        }
        bufferedWriter.close();
    }

    public void readFileCustomer() throws IOException {
        LinkedList<CustomerObject> printCustomerList = new LinkedList<>();

        BufferedReader bufferedReader = new BufferedReader(new FileReader("CustomerList.csv"));
        String line;
        while ((line = bufferedReader.readLine()) != null) {


            String[] arr = line.split(",");
            if (arr[0].equals("ID")) {
                continue;
            }
//           (int id,String name, String address, String email, int telephone, String gender,  int countToBuy)
            try {
                CustomerObject customerObject = new CustomerObject(Integer.parseInt(arr[0].trim()), arr[1], arr[2],
                        arr[3], Integer.parseInt(arr[4].trim()), arr[5], Integer.parseInt(arr[6].trim()));


                printCustomerList.add(customerObject);
            } catch (ArrayIndexOutOfBoundsException ignored) {

            }
        }
        for (CustomerObject customerObject : printCustomerList) {
            System.out.println(customerObject.toString());
        }
        System.out.println();
        System.out.println("                       Tong cong co "+printCustomerList.size()+" khach hang trong he thong.");

        bufferedReader.close();
        System.out.println("                                          --------------");

    }
}
