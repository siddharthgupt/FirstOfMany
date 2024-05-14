package com.example.firstOfMany.service;

import com.example.firstOfMany.dao.LibraryRepository;
import com.example.firstOfMany.model.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {

    @Autowired
    private LibraryRepository libraryRepository;

    public List<Library> findAll(){
        return libraryRepository.findAll();
    }

    public Optional<Library> findById(Long id){
        return libraryRepository.findById(id);
    }

    public Library add(Library library){
        return libraryRepository.save(library);
    }

}
