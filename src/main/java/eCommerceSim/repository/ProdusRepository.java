package eCommerceSim.repository;

import eCommerceSim.domain.Produs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdusRepository extends JpaRepository<Produs, Integer> {
    List<Produs> findByCategorie(String categorie);

    Produs findByNumeProdus(String nume);

//    @Query("""
//            SELECT * FROM produs WHERE categorie = :categorie AND pret <= pret
//            """)
//    List<Produs> filtreazaCategorieSiPret(String categorie, double pret);

    @Query("""
            SELECT p FROM Produs p WHERE p.categorie = :categorie AND p.pret <= :pret
            """)
    List<Produs> filtreazaCategorieSiPret(String categorie, Double pret);

}
