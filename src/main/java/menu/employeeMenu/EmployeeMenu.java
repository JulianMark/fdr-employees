package menu.employeeMenu;

import model.Employee;

import static menu.employeeMenu.FacerMenu.showFacerMenu;

public class EmployeeMenu {

    public static void showEmployeeMenu (Employee employee){

        if (employee.getIdType() == 1){
            showFacerMenu(employee);
        }
    }
}
