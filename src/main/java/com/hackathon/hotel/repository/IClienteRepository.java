package com.hackathon.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.hotel.entities.Cliente;
@Repository
public interface IClienteRepository extends JpaRepository <Cliente, Long>{
}
