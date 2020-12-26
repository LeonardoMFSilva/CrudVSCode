package org.generation.Controller;

import java.util.List;

import org.generation.Models.shoes;
import org.generation.Repositories.shoesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/shoes")
@CrossOrigin (origins = "*", allowedHeaders = "*")
public class ShoesController {

    @Autowired
    private shoesRepository repository;

    @GetMapping
    public ResponseEntity <List<shoes>> getAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<shoes> getById(@PathVariable long id){
        return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/shoes/{shoes}")
    public ResponseEntity<List<shoes>> getByName(@PathVariable String shoeName){
        return ResponseEntity.ok(repository.findAllByNameContainingIgnoreCase(shoeName));
    }
    
    @GetMapping("/year/{year}")
    public ResponseEntity<List<shoes>> getByYear(@PathVariable String launchYear){
        return ResponseEntity.ok(repository.findAllByYearContainingIgnoreCase(launchYear));
    }

    @GetMapping("/model/{model}")
    public ResponseEntity<List<shoes>> getByModel(@PathVariable String shoeModel){
        return ResponseEntity.ok(repository.findAllByModelContainingIgnoreCase(shoeModel));
    }

    @GetMapping("/size/{size}")
    public ResponseEntity<List<shoes>> getByYear(@PathVariable int size){
        return ResponseEntity.ok(repository.findAllBySize(size));
    }

    @PostMapping
    public ResponseEntity<shoes> postShoe(@RequestBody shoes Shoe){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(Shoe));
    }

    @PutMapping
    public ResponseEntity<shoes> editShoe(@RequestBody shoes Shoe){
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(Shoe));
    }

    @DeleteMapping ("/{id}")
    public void deleteById(@PathVariable long id){
        repository.deleteById(id);
    }
    
}
