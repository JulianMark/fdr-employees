package menu.employeeMenu;

import model.Employee;

import static menu.employeeMenu.login.facer.FacerMenu.showFacerMenu;
import static menu.employeeMenu.login.teamLeader.TeamLeaderMenu.showTeamLeaderMenu;

public class EmployeeMenu {

    public static void showEmployeeMenu (Employee employee){

        if (employee.getIdType() == 1){
            showFacerMenu(employee);
        } if (employee.getIdType() == 2) {
            showTeamLeaderMenu(employee);
        }
    }
}
