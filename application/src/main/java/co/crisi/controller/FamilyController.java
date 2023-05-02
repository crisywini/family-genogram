package co.crisi.controller;

import co.crisi.data.PersonInfo;
import co.crisi.port.api.PersonServicePort;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/people/family")
@RestController
@AllArgsConstructor
public class FamilyController {

    @Autowired
    private PersonServicePort personServicePort;

    @GetMapping("/mother/{personId}")
    public ResponseEntity<PersonInfo> findMother(
            @PathVariable(name = "personId")
                    Long id) {
        return ResponseEntity.ok(personServicePort.findOnlyMotherFamily(id));
    }

    @GetMapping("/father/{personId}")
    public ResponseEntity<PersonInfo> findFather(
            @PathVariable(name = "personId")
                    Long id) {
        return ResponseEntity.ok(personServicePort.findOnlyFatherFamily(id));
    }

    @GetMapping("/children/{personId}")
    public ResponseEntity<List<PersonInfo>> findChildren(
            @PathVariable(name = "personId")
                    Long id) {
        return ResponseEntity.ok(personServicePort.findChildren(id));
    }

    @GetMapping("/parents/{personId}")
    public ResponseEntity<List<PersonInfo>> findParents(
            @PathVariable(name = "personId")
                    Long id) {
        return ResponseEntity.ok(personServicePort.findParents(id));
    }

}
