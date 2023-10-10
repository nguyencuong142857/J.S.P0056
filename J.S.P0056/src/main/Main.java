/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import businessObject.WorkerBO;
import constans.Constant;
import entity.Worker;
import java.util.Scanner;
import utils.Validation;

/**
 *
 * @author ngnqu
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        WorkerBO workerBO = new WorkerBO();

        while (true) {
            System.out.println("======== Worker Management ========");
            System.out.println("1. Add Worker");
            System.out.println("2. Up salary");
            System.out.println("3. Down salary");
            System.out.println("4. Display Information salary");
            System.out.println("5. Display All Worker");
            System.out.println("6. Exit");
            int choice = Validation.getInt("Enter (1 to 6): ", "Out of range!",
                    "Must be a integer!", 1, 6);
            switch (choice) {
                case 1:
                    while (true) {
                        String code = Validation.getStringWithRegex(
                                "Enter Code: ", "messageErrorInvalid",
                                Constant.REGEX_CODE);
                        String name = Validation.getStringWithRegex(
                                "Enter Name: ",
                                "messageErrorInvalid",
                                Constant.REGEX_NAME);
                        int age = Validation.getInt("Enter Age: ",
                                "Must be 18 to 50!", "Must be a integer!",
                                18, 50);
                        double salary = Validation.getDouble("Enter Salary: ",
                                "Must be > 0!", "Must be a double!",
                                Double.MIN_VALUE, Double.MAX_VALUE);
                        String workLocation = Validation.getStringWithRegex(
                                "Enter Work Location: ", "messageErrorInvalid",
                                Constant.REGEX_WOKR_LOCATION);
                        Worker worker = new Worker(code, name, age, salary,
                                workLocation);
                        workerBO.addWorker(worker);
                        String choiceYorN = Validation.getStringWithRegex(
                                "Do you want to continue? (Y/N): ",
                                "messageErrorInvalid",
                                Constant.REGEX_YES_OR_NO);
                        if (choiceYorN.equalsIgnoreCase("N")) {
                            break; // Kết thúc vòng lặp nếu người dùng chọn "N" hoặc "n"
                        }
                    }
                    break;
                case 2:

                case 3:
                case 4:
                case 5:
                    workerBO.displayAllWorker();
                    break;
                case 6:
                    System.out.println("Thanks you!!!");
                    scanner.close();
                    System.exit(0);
            }
        }
    }

}
