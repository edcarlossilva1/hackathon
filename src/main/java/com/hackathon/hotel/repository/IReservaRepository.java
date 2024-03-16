package com.hackathon.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.hotel.entities.Quarto;
@Repository
public interface IReservaRepository extends JpaRepository <Quarto, Long>{
}
