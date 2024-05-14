package com.example.firstOfMany.controller;

import com.example.firstOfMany.model.Library;
import com.example.firstOfMany.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/library")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @GetMapping
    public ResponseEntity<List<Library>> getAllSection(){
        List<Library> repositoryAll = libraryService.findAll();
        return new ResponseEntity<>(repositoryAll, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Library> getStudentById(@PathVariable Long id) {
        Optional<Library> lib = libraryService.findById(id);
        return lib.map(library -> new ResponseEntity<>(library, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Library> createNewStudent(@RequestBody Library libBody) {
        Library libResult = libraryService.add(libBody);
        return new ResponseEntity<>(libResult, HttpStatus.CREATED);
    }
}
