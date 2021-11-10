package com.bfi.marketing.restApi;


import com.bfi.marketing.exceptions.NotFoundException;

import com.bfi.marketing.models.Fete;
import com.bfi.marketing.payload.request.FeteRequest;
import com.bfi.marketing.payload.response.MessageResponse;
import com.bfi.marketing.repository.FeteRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/fete")
public class FeteController {



    @Autowired
    FeteRepository feteRepository;
    @PostMapping("/addfete")
    public ResponseEntity<?> addFete(@Valid @RequestBody FeteRequest feteRequest) {
        Fete f = new Fete(feteRequest.getTitre(),
                          feteRequest.getDate(),
                          feteRequest.getDescription(),
                          feteRequest.getType());
        feteRepository.save(f);
        return ResponseEntity.ok(new MessageResponse("fete registered successfully!"));
    }



    @PutMapping ("/update/{id}")
    public ResponseEntity<?>  updatefete(@Valid @RequestBody FeteRequest feteRequest , @PathVariable(value = "id" ) Long id) throws NotFoundException {
        Optional<Fete> f = Optional.ofNullable(feteRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Fete not Found for this id ::" + id)));
        Fete fe = f.get();
        fe.setTitre(feteRequest.getTitre());
        fe.setDate(feteRequest.getDate());
        fe.setDescription(feteRequest.getDescription());
        fe.setType(feteRequest.getType());


        feteRepository.saveAndFlush(fe) ;
        return new ResponseEntity<>("Fete is successfully updated", HttpStatus.OK);
    }


    @ApiOperation(value = "delete post by Id", response = ResponseEntity.class)
    @DeleteMapping("/delete/{feteId}")
    public ResponseEntity<ApiResponse> deletefete(@PathVariable Long feteId) {

        Optional<Fete> f = feteRepository.findById(feteId);
        if (f.isPresent()) {
            feteRepository.delete(f.get());
            return new ResponseEntity("fete is successfully deleted", HttpStatus.OK);
        } else {
            throw new NotFoundException("fete not found");
        }
    }



    @ApiOperation(value = "Get all parties", response = ResponseEntity.class)
    @GetMapping("/listf")
    public Iterable<Fete> getAllFete() {
        return feteRepository.findAll();
    }



    @GetMapping("/{id}")
    public Optional<Fete> findById(@PathVariable (value = "id") Long id) {

        return feteRepository.findById(id);
    }

    @GetMapping("findMulti/{key}")
    public List<Fete> findMulti(@PathVariable (value = "key") String key) {

        return feteRepository.findMulti(key);

    }









}
