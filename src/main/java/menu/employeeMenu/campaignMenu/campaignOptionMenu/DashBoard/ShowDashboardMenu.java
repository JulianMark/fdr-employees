package menu.employeeMenu.campaignMenu.campaignOptionMenu.DashBoard;

import model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShowDashboardMenu {

    public static Integer showDashBoardMenuEmployeeList (Integer idCampaign) {

        Scanner sc = new Scanner(System.in);
        Integer result;
        List<Employee> employeesList = new ArrayList<>();
        employeesList.add(new Employee(1,"JUAN","PEREZ",1));
        employeesList.add(new Employee(2,"JUANA","PEREZ",1));
        employeesList.add(new Employee(3,"PEDRO","GOMEZ",1));
        employeesList.add(new Employee(4,"PITA","GOMEZ",1));


        int index = 1;

        System.out.println("Seleccione al empleado por su numero ");
        for (Employee employee: employeesList) {
            System.out.println(index + " - "+ employee.getName() +" "+employee.getLastName());
            index++;
        }
        result = sc.nextInt();

        return employeesList.get(result - 1).getId();
    }
}
