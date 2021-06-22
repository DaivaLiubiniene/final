package warehouse.DTO;

import warehouse.model.ClientTypes;
import warehouse.model.Inventory;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;

public class ClientDTO {

    private String name;
    private String surname;
    private LocalDate birthdate;
    private int phone;
    private ClientTypes type;

    public ClientDTO(){
    }

    public ClientDTO(String name, String surname, LocalDate birthdate, int phone, ClientTypes type) {
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.phone = phone;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public ClientTypes getType() {
        return type;
    }

    public void setType(ClientTypes type) {
        this.type = type;
    }
}
