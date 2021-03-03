package com.company;
import com.company.controller.EmployeeController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MyApplication {
    private final EmployeeController controller;
    private final Scanner scanner;

    public MyApplication(EmployeeController controller){
        this.controller = controller;
        scanner = new Scanner(System.in);
    }
    public void start(){
        while (true){
            System.out.println();
            System.out.println("Welcome to My Application");
            System.out.println("Select option: (1-3)");
            System.out.println("1. Create employee");
            System.out.println("2. Get medicine by id");
            System.out.println("3. Remove employee");
            System.out.println("0. Exit");
            System.out.println();
            try{
                System.out.println("Enter the option: (1-3)");
                int option = scanner.nextInt();
                if(option==1){
                    createEmployeeMenu();
                }
                else if(option==2){
                    getEmployeeByIdMenu();
                }
                else if(option==3){
                    removeEmployeeByIdMenu();
                }
                else {
                    break;
                }
            }catch (InputMismatchException e){
                System.out.println("Input must be integer");
                scanner.nextLine();
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
            System.out.println("***************************************");
        }
    }
    public void getEmployeeByIdMenu(){
        System.out.println("Please enter id:");
        int id = scanner.nextInt();
        String response = controller.getEmployee(id);
        System.out.println(response);
    }

    public void createEmployeeMenu(){
        System.out.println("Please enter name:");
        String name = scanner.next();
        System.out.println("Please enter surname:");
        String surname = scanner.next();
        System.out.println("Please enter status");
        String status = scanner.next();
        System.out.println("Please enter hobby:");
        String hobby = scanner.next();
        System.out.println("Please enter level:");
        String level = scanner.next();
        String response = controller.createEmployee(name, surname, status, hobby, level);
        System.out.println(response);
    }
    public void removeEmployeeByIdMenu() {
        System.out.println("Please enter id: ");
        int id = scanner.nextInt();
        String response = controller.getEmployee(id);
        System.out.println(response);
    }
}
