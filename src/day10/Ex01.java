package day10;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ex01 {
    public static void main(String[] args) {
        List<Employee> emps = List.of(
                new Employee(1, "Jordan", "Dooray!"),
                new Employee(2, "Dongmyo", "Dooray!"),
                new Employee(3, "Comtin", "Dooray!"),
                new Employee(4, "Manty", "Doorway!"),
                new Employee(5, "Coco", "NHN Edu"),
                new Employee(6, "Kizoo", "NHN Academy"),
                new Employee(7, "Marco", "NHN Academy"));
        // key: departmentName, value: employee count
        Map<String, Integer> empCountByDeptMap = new HashMap<>();
//        for (Employee emp : emps) {
//            Integer empCount = empCountByDeptMap.get(emp.deptName);
//            if (empCount == null) {
//                empCountByDeptMap.put(emp.deptName, 1);
//            } else {
//                empCountByDeptMap.put(emp.deptName, empCount + 1);
//            }
//        }
        for(Employee emp : emps){
            empCountByDeptMap.merge(emp.deptName,1,(o,n)->o+n);
        }
        System.out.println(empCountByDeptMap);
    }


}
