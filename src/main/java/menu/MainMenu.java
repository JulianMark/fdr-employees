package menu;

import model.Employee;
import model.http.LoginRequest;
import org.springframework.http.ResponseEntity;

import java.util.Scanner;

import static menu.employeeMenu.login.Login.showLoginMenu;
import static menu.employeeMenu.controller.ControllerEmployeeMenu.controllerEmployeeMenu;
import static supplier.LoginSupplier.loginUser;



public class MainMenu {

    private static Scanner sc;

    public static void showMenu(){
        int response;
        do {
            System.out.println("Seleccione la opcion deseada");
            System.out.println("1. Acceder");
            System.out.println("0. Salir");

            sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response) {
                case 1:
                    LoginRequest loginRequest = showLoginMenu();
                    ResponseEntity<Employee> responseEntity =  loginUser(loginRequest);
                    if(responseEntity.getStatusCode().value() == 200){
                        Employee employee = responseEntity.getBody();
                        controllerEmployeeMenu(employee);
                    }
                    if (responseEntity.getStatusCode().value() == 204){
                        System.out.println("Empleado no encontrado");
                        System.out.println(" ");
                    }
                    if (responseEntity.getStatusCode().value() == 400){
                        response = 1;
                    }
                    if (responseEntity.getStatusCode().value() == 500){
                        System.out.println("Error en el sistema, intente nuevamente más tarde");
                        response = 1;
                    }
                    break;
                case 0:
                    System.out.println("Adios");
                    break;
                default :
                    System.out.println("Ingresa una opcion correcta");
            }
        } while (response !=0);

    }

}
