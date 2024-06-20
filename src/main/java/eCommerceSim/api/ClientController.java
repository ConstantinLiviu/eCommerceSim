package eCommerceSim.api;

import eCommerceSim.domain.Client;
import eCommerceSim.dto.client.ClientDTOContNou;
import eCommerceSim.dto.client.ClientDTOModificaAdresaLivrare;
import eCommerceSim.repository.ClientRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conturi")
public class ClientController {
    ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping("/afiseaza-clienti")
    public List<Client> afiseazaClientii() {
        return clientRepository.findAll();
    }

    @PostMapping("/creeaza-cont")
    Client contNou(@RequestBody ClientDTOContNou contNou) {
        Client clientNou = new Client();

        clientNou.setNume(contNou.getNume());
        clientNou.setAdresaLivrare(contNou.getAdresaLivrare());
        return clientRepository.save(clientNou);
    }

    @PostMapping("/update-adresa-livrare/{id}")
    Client modificaAdresaLivrare(@PathVariable Integer id,
                                 @RequestBody ClientDTOModificaAdresaLivrare adresaLivrareNoua) {
        Client adresaLivrareModificata = clientRepository.findById(id).orElseThrow(()-> new RuntimeException("Contul " +
                "nu exista in baza de date"));

        adresaLivrareModificata.setAdresaLivrare(adresaLivrareNoua.getAdresaLivrare());
        return clientRepository.save(adresaLivrareModificata);
    }

    @DeleteMapping("/sterge-cont/{id}")
    ResponseEntity<String> stergeContul(@PathVariable Integer id) {
        Client contDeSters = clientRepository.findById(id).orElseThrow(()-> new RuntimeException("Contul nu exista in" +
                " baza de date"));
        clientRepository.delete(contDeSters);
        return ResponseEntity.ok("Contul a fost sters!");
    }
}
