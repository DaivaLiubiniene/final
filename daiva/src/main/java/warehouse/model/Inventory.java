package warehouse.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Entity
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty(message = "Pavadinimas privalomas!")
    @Column
    private String name;

    @NotEmpty(message = "Svoris privalomas!")
    @Column
    private long weight;

    @NotEmpty(message = "Sektorius privalomas!")
    @Min(value = 1)
    @Max(value = 40)
    @Column
    private int sector;

    @NotEmpty(message = "Patalpinimo data privaloma!")
    @Column
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Inventory() {
    }

    public Inventory(long id, @NotEmpty(message = "Pavadinimas privalomas!") String name,
                     @NotEmpty(message = "Svoris privalomas!") long weight,
                     @NotEmpty(message = "Sektorius privalomas!") @Min(value = 1) @Max(value = 40) int sector,
                     @NotEmpty(message = "Patalpinimo data privaloma!") LocalDate date, Client client) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.sector = sector;
        this.date = date;
        this.client = client;
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

    public long getWeight() {
        return weight;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }

    public int getSector() {
        return sector;
    }

    public void setSector(int sector) {
        this.sector = sector;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
