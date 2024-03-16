package com.hackathon.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.hotel.entities.ItensServico;
@Repository
public interface IItensServicoRepository extends JpaRepository <ItensServico, Long>{
}
