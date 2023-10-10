/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessObject;

import entity.SalaryInfomation;
import entity.Worker;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ngnqu
 */
public class WorkerBO {

    private Map<String, Worker> workerMap = new HashMap<>();

    private List<SalaryInfomation> salaryMap = new ArrayList<>();

    public List<SalaryInfomation> getSalaryMap() {
        return salaryMap;
    }

    public void setSalaryMap(List<SalaryInfomation> salaryMap) {
        this.salaryMap = salaryMap;
    }

    public void setWorkerMap(Map<String, Worker> workerMap) {
        this.workerMap = workerMap;
    }

    public Map<String, Worker> getWorkerMap() {
        return workerMap;
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

    public void displayAllWorker() {
        System.out.println("==============================================="
                + "====================================================");
        System.out.printf("%-20s %-30s %-10s %-20s %-30s%n",
                "Code", "Name", "Age", "Salary", "Work Location");

        for (Worker worker : workerMap.values()) {
            System.out.printf("%-20s %-30s %-10s %-20.2f %-30s%n",
                    worker.getCode(),
                    worker.getName(),
                    worker.getAge(),
                    worker.getSalary(),
                    worker.getWorkLocation());
        }
        System.out.println("=============================================="
                + "=====================================================");
    }

}
