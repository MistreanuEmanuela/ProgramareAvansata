package com.example.demo.repository;

import com.example.demo.Cabinet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;


public interface CabinetRepository extends JpaRepository<Cabinet, Long> {

}