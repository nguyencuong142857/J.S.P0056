package businessObject;

import entity.SalaryInfomation;
import java.util.HashMap;
import java.util.Map;

public class SalaryBO {

    private Map<String, SalaryInfomation> salaryMap = new HashMap<>();

    public Map<String, SalaryInfomation> getSalaryMap() {
        return salaryMap;
    }

    public void setSalaryMap(Map<String, SalaryInfomation> salaryMap) {
        this.salaryMap = salaryMap;
    }
}
