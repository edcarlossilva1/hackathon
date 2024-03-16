package com.hackathon.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.hotel.entities.Servico;
@Repository
public interface IServicoRepository extends JpaRepository <Servico, Long>{
}
