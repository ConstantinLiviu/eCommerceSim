package eCommerceSim.repository;

import eCommerceSim.domain.Client;
import eCommerceSim.domain.CosCumparaturi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CosCumparaturiRepository extends JpaRepository<CosCumparaturi, Integer> {
    CosCumparaturi findByNumeProdus(String nume);

    List<CosCumparaturi> findAllByNumeClient(String numeClient);
}
