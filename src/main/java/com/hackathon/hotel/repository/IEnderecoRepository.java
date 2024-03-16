package com.hackathon.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.hotel.entities.Endereco;
@Repository
public interface IEnderecoRepository extends JpaRepository <Endereco, Long>{
}