package hu.forestwolf.controllers;

import hu.forestwolf.domain.Country;
import hu.forestwolf.domain.Wolf;
import hu.forestwolf.service.WolfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WolfController {

    @Autowired
    private WolfService service;

    @GetMapping("/wolfs")
    public List<Wolf> wolfs(){
        return service.getWolfs();
    }

    @GetMapping("/wolfs/{id}")
    public Wolf getWolf(@PathVariable("id") int id){
        return service.getWolf(id);
    }

    @PostMapping("/wolfs")
    @ResponseStatus(HttpStatus.CREATED)
    public Wolf addWolf(@RequestBody Wolf newWolf){
        return service.addWolf(newWolf);
    }

    @PostMapping("/wolfs/{id}")
    public ResponseEntity<Wolf> addWolfUsingId(){
        return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
    }

    @PutMapping("/wolfs")
    public ResponseEntity<Wolf> replaceWolfWithoutId(){
        return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
    }

    @PatchMapping("/wolfs")
    public ResponseEntity<Wolf> updateWolfWithoutId(){
        return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
    }

    @PatchMapping("wolfs/{id}/{rank}")
    public ResponseEntity<Wolf> updateWolf(@PathVariable("id") int id, @PathVariable("rank") int rank){
        Wolf wolf = service.updateWolf(id, rank);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value="/wolfs/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Wolf> replaceWolf(@PathVariable("id") int id, @RequestBody(required = false) Wolf wolf){
        Wolf replacedWolf = service.replaceWolf(id, wolf);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/wolfs")
    public ResponseEntity<Wolf> deleteAllWolfs(){
        return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
    }

    @DeleteMapping("/wolfs/{id}")
    public void deleteWolf(@PathVariable("id") int id){
        service.deleteWolf(id);
    }


}
