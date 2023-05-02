package co.crisi.controller;

import co.crisi.data.PersonInfo;
import co.crisi.port.api.PersonServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/people")
@RestController
public class PersonController {

    @Autowired
    private PersonServicePort personServicePort;

    @PostMapping
    public ResponseEntity<Long> save(
            @RequestBody
                    PersonInfo personInfo) {
        return ResponseEntity.ok(personServicePort.save(personInfo));
    }

    @DeleteMapping("/{personId}")
    public ResponseEntity<Void> delete(
            @PathVariable(name = "personId")
                    Long id) {
        personServicePort.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{personId}")
    public ResponseEntity<PersonInfo> findById(
            @PathVariable(name = "personId")
                    Long id) {
        return ResponseEntity.ok(personServicePort.findById(id));
    }

    @PutMapping("/{personId}")
    public ResponseEntity<Long> update(
            @PathVariable(name = "personId")
                    Long id,
            @RequestBody
                    PersonInfo newPersonInfo) {
        return ResponseEntity.ok(personServicePort.update(id, newPersonInfo));
    }

}
