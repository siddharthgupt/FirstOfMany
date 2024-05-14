package com.example.firstOfMany.dao;

import com.example.firstOfMany.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Long> {

    public Library findBySection(String section);
}
