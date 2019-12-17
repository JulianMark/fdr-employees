import model.Employee;
import org.json.JSONException;

import java.net.URISyntaxException;

import static menu.MainMenu.showMenu;
import static menu.employeeMenu.FacerMenu.showFacerMenu;

public class Main  {

    public static void main(String[] args) throws JSONException, URISyntaxException {
        //showMenu();
        Employee employee = new Employee(1,"JULIAN", "MARK",1);
        showFacerMenu(employee);
    }
}
