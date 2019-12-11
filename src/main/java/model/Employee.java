package model;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Employee {

    private Integer id;
    private String name;
    private String lastName;
    private Integer idType;
    private String nickname;
    private String password;
    private Integer donations;
    private float hoursWorked;
    private float errorMessage;

    public Employee(Integer id, String name, String lastName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
    }
}
