import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Json {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        for (int i = 1; i <= 100000; i++) {
            Employee employee = new Employee(i, "Employee " + i, getRandomDepartment(),getRandomSalary());
            employees.add(employee);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("F:\\Practice\\Json_Gen\\src\\main\\resources\\employees.json"), employees);
            System.out.println("JSON data written to employees.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getRandomDepartment() {
        String[] departments = {"HR", "IT", "Finance", "Sales"};
        return departments[new Random().nextInt(departments.length)];
    }

    private static int getRandomSalary(){
        int[] salary={40000,50000,20000,30000,40000,50000};
        return salary[new Random().nextInt(salary.length)];
    }

    }
