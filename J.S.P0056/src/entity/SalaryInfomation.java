/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author ngnqu
 */
public class SalaryInfomation extends Worker {

    private String status;
    private Date date;

    public SalaryInfomation() {
    }

    public SalaryInfomation(String status, Date date) {
        this.status = status;
        this.date = date;
    }

    public SalaryInfomation(String status, Date date, String code, String name, int age, double salary, String workLocation) {
        super(code, name, age, salary, workLocation);
        this.status = status;
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
