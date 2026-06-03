package com.bbanas.genochronica.person;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("SELECT p FROM Person p WHERE p.firstName LIKE %:name% OR p.middleName LIKE %:name% OR p.lastName LIKE %:name%")
    Page<Person> findByName(String name, Pageable pageable);
}