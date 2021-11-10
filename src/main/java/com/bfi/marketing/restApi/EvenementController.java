package com.bfi.marketing.restApi;


import com.bfi.marketing.exceptions.NotFoundException;
import com.bfi.marketing.models.Evenement;
import com.bfi.marketing.models.Fete;
import com.bfi.marketing.payload.request.EvenementRequest;
import com.bfi.marketing.payload.response.MessageResponse;
import com.bfi.marketing.repository.EvenementRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/event")
public class EvenementController {



    @Autowired
    EvenementRepository eventRepository;
    @PostMapping("/addevent")
    public ResponseEntity<?> addEvent(@Valid @RequestBody EvenementRequest eventRequest) {
        Evenement er = new Evenement(eventRequest.getTitre(),eventRequest.getDate(),eventRequest.getDescription());
        eventRepository.save(er);
        return ResponseEntity.ok(new MessageResponse("event registered successfully!"));
    }




    @PutMapping ("/update/{id}")
    public ResponseEntity<?>  updateevent(@Valid @RequestBody EvenementRequest eventRequest ,@PathVariable(value = "id" ) Long id) throws NotFoundException{
        Optional<Evenement> e = Optional.ofNullable(eventRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Person not Found for this id ::" + id)));
        Evenement ev = e.get();
        ev.setTitre(eventRequest.getTitre());
        ev.setDate(eventRequest.getDate());
        ev.setDescription(eventRequest.getDescription());

        eventRepository.saveAndFlush(ev) ;
        return new ResponseEntity<>("Event is successfully updated", HttpStatus.OK);
    }


    @ApiOperation(value = "delete event by Id", response = ResponseEntity.class)
    @DeleteMapping("/delete/{eventId}")
    public ResponseEntity<ApiResponse> deleteEvent(@PathVariable Long eventId) {

        Optional<Evenement> e = eventRepository.findById(eventId);
        if (e.isPresent()) {
            eventRepository.delete(e.get());
            return new ResponseEntity("The eval is successfully deleted", HttpStatus.OK);
        } else {
            throw new NotFoundException("event not found");
        }
    }


    @ApiOperation(value = "Get all events", response = ResponseEntity.class)
    @GetMapping("/listEvent")
    public Iterable<Evenement> getAllEvent() {
        return eventRepository.findAll();
    }



    @GetMapping("/{id}")
    public Optional<Evenement> findById(@PathVariable (value = "id") Long id) {

        return eventRepository.findById(id);
    }

    @GetMapping("findTitre/{titre}")
    public List<Evenement> findByTitre(@PathVariable (value = "titre") String titre) {

        return eventRepository.findByTitre(titre);

    }

    @GetMapping("findDate/{date}")
    public List<Evenement> findByDate(@PathVariable (value = "date") String date) {

        return eventRepository.findByDate(date);

    }


}
