package eCommerceSim.repository;

import eCommerceSim.domain.Produs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdusRepository extends JpaRepository<Produs, Integer> {
    List<Produs> findByCategorie(String categorie);

    Produs findByNumeProdus(String nume);
}
