package com.bfi.marketing.restApi;

import com.bfi.marketing.exceptions.NotFoundException;
import com.bfi.marketing.models.Evenement;
import com.bfi.marketing.models.Fete;
import com.bfi.marketing.models.publication;
import com.bfi.marketing.payload.request.EvenementRequest;
import com.bfi.marketing.payload.request.FeteRequest;
import com.bfi.marketing.payload.request.PublicationRequest;
import com.bfi.marketing.payload.response.MessageResponse;
import com.bfi.marketing.repository.FeteRepository;
import com.bfi.marketing.repository.PublicationRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/publication")
public class PublicationController {

    @Autowired
    PublicationRepository pubRepository;
    @PostMapping("/addpub")
    public ResponseEntity<?> addpub(@Valid @RequestBody PublicationRequest pubRequest) {
        publication p = new publication(pubRequest.getDate(),pubRequest.getPlateform(),
                                        pubRequest.getIdEvent(),
                                        pubRequest.getIdFete());
        pubRepository.save(p);
        return ResponseEntity.ok(new MessageResponse("post registered successfully!"));
    }


    @PutMapping ("/update/{id}")
    public ResponseEntity<?>  updatepub(@Valid @RequestBody PublicationRequest pubRequest , @PathVariable(value = "id" ) Long id) throws NotFoundException {
        Optional<publication> p = Optional.ofNullable(pubRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Post not Found for this id ::" + id)));
        publication pub = p.get();
        pub.setDate(pubRequest.getDate());
        pub.setPlateform(pubRequest.getPlateform());
        pub.setIdEvent(pubRequest.getIdEvent());
        pub.setIdFete(pubRequest.getIdFete());


        pubRepository.saveAndFlush(pub) ;
        return new ResponseEntity<>("Post is successfully updated", HttpStatus.OK);
    }


    @ApiOperation(value = "delete post by Id", response = ResponseEntity.class)
    @DeleteMapping("/delete/{pubId}")
    public ResponseEntity<ApiResponse> deletePost(@PathVariable Long pubId) {

        Optional<publication> p = pubRepository.findById(pubId);
        if (p.isPresent()) {
            pubRepository.delete(p.get());
            return new ResponseEntity("Post is successfully deleted", HttpStatus.OK);
        } else {
            throw new NotFoundException("Post not found");
        }
    }


}
