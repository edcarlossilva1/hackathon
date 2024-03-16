package com.hackathon.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.hotel.entities.Predio;
@Repository
public interface IPredioRepository extends JpaRepository <Predio, Long>{
}
