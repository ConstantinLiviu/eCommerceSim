package eCommerceSim.repository;

import eCommerceSim.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    Client findByNume(String nume);

}
