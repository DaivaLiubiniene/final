package warehouse.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty(message = "Vardas privalomas!")
    @Column
    private String name;

    @NotEmpty(message = "Pavardė privaloma!")
    @Column
    private String surname;

    @NotEmpty(message = "Gimimo data privaloma!")
    @Column
    private LocalDate birthdate;

    @NotEmpty(message = "Telefono numeris privalomas!")
    @Column
    private int phone;

    @Column
    @NotEmpty(message = "Kliento tipas privalomas!")
    private ClientTypes type;

    @OneToMany(mappedBy = "client")
    private List<Inventory> inventoryList;

    public Client(){
    }

    public Client(long id, @NotEmpty(message = "Vardas privalomas!") String name,
                  @NotEmpty(message = "Pavardė privaloma!") String surname,
                  @NotEmpty(message = "Gimimo data privaloma!") LocalDate birthdate,
                  @NotEmpty(message = "Telefono numeris privalomas!") int phone,
                  @NotEmpty(message = "Kliento tipas privalomas!") ClientTypes type,
                  List<Inventory> inventoryList) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.phone = phone;
        this.type = type;
        this.inventoryList = inventoryList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public List<Inventory> getInventoryList() {
        return inventoryList;
    }

    public void setInventoryList(List<Inventory> inventoryList) {
        this.inventoryList = inventoryList;
    }
}
