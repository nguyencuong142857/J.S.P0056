/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessObject;

import entity.SalaryInfomation;
import entity.Worker;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import utils.Validation;

/**
 *
 * @author ngnqu
 */
public class WorkerBO {

    private Map<String, Worker> workerMap = new HashMap<>();
    private List<SalaryInfomation> salaryList = new ArrayList<>();

    public void setSalaryMap(List<SalaryInfomation> salaryMap) {
        this.salaryList = salaryMap;
    }

    public void setWorkerMap(Map<String, Worker> workerMap) {
        this.workerMap = workerMap;
    }

    public boolean isWorkerExist(String code) {
        return workerMap.containsKey(code);
    }

    public void addWorker(Worker worker) {
        String code = worker.getCode();
        if (!isWorkerExist(code)) {
            workerMap.put(code, worker);
            System.out.println("Add worker successfully!!!");
        } else {
            System.out.println("Worker code is exist!!!");
        }
    }

    public void increaseSalary(String code, double newSalary) {
        if (!workerMap.containsKey(code)) {
            System.out.println("Code isn't exist!");
        } else {
            Worker worker = workerMap.get(code);
            double currentSalary = worker.getSalary();

            while (newSalary < currentSalary) {
                System.out.println("New salary cannot be less than current salary!");
                newSalary = Validation.getDouble("Enter Salary: ",
                        "Must be > 0!", "Must be a double!",
                        Double.MIN_VALUE, Double.MAX_VALUE);
            }
            worker.setSalary(newSalary);
            SalaryInfomation salaryInfomation = new SalaryInfomation("UP", WorkerBO.getCurrentDate(), worker.getCode(), worker.getName(), worker.getAge(), worker.getSalary(), worker.getWorkLocation());
            salaryList.add(salaryInfomation);
            System.out.println("Increase Salary Sucessfully!!!");
        }
    }
    
    public void decreaseSalary(String code, double newSalary) {
        if (!workerMap.containsKey(code)) {
            System.out.println("Code isn't exist!");
        } else {
            Worker worker = workerMap.get(code);
            double currentSalary = worker.getSalary();

            while (newSalary > currentSalary) {
                System.out.println("New salary cannot be less than current salary!");
                newSalary = Validation.getDouble("Enter Salary: ",
                        "Must be > 0!", "Must be a double!",
                        Double.MIN_VALUE, Double.MAX_VALUE);
            }
            worker.setSalary(newSalary);
            SalaryInfomation salaryInfomation = new SalaryInfomation("DOWN", WorkerBO.getCurrentDate(), worker.getCode(), worker.getName(), worker.getAge(), worker.getSalary(), worker.getWorkLocation());
            salaryList.add(salaryInfomation);
            System.out.println("Increase Salary Sucessfully!!!");
        }
    }

    public void displaySalaryList() {
        System.out.println("==============================================="
                + "============================");
        System.out.printf("%-10s %-20s %-10s %-10s %-10s %-10s%n",
                "Code", "Name", "Age", "Salary", "Status", "Date");

        for (SalaryInfomation salaryInfo : salaryList) {
            System.out.printf("%-10s %-20s %-10s %-10s %-10s %-10s%n",
                    salaryInfo.getCode(),
                    salaryInfo.getName(),
                    salaryInfo.getAge(),
                    salaryInfo.getSalary(),
                    salaryInfo.getStatus(),
                    salaryInfo.getDate());
        }
        System.out.println("=============================================="
                + "============================");
    }

    public void displayAllWorker() {
        System.out.println("==============================================="
                + "============================");
        System.out.printf("%-10s %-20s %-10s %-10s %-20s%n",
                "Code", "Name", "Age", "Salary", "Work Location");

        for (Worker worker : workerMap.values()) {
            System.out.printf("%-10s %-20s %-10s %-10s %-20s%n",
                    worker.getCode(),
                    worker.getName(),
                    worker.getAge(),
                    worker.getSalary(),
                    worker.getWorkLocation());
        }
        System.out.println("=============================================="
                + "============================");
    }

    //get current date 
    public static String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        return dateFormat.format(calendar.getTime());
    }
}
