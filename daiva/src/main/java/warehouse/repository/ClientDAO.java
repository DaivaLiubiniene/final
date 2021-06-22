package warehouse.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import warehouse.model.Client;

import java.time.LocalDate;

public interface ClientDAO extends JpaRepository<Client, Long> {
    Client findByName(String name);
    Client findBySurname(String surname);
    Client findByBirthdate(LocalDate birthdate);

}
