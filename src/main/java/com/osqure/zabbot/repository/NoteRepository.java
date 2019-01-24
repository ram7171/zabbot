package com.osqure.zabbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.osqure.zabbot.model.TestDB;

@Repository
public interface NoteRepository extends JpaRepository<TestDB, Long> {


}
