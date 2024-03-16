package com.hackathon.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.hotel.entities.Localidade;
@Repository
	public interface ILocalidadeRepository extends JpaRepository <Localidade, Long>{
}
