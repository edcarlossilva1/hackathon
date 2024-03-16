package com.hackathon.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.hotel.entities.Movel;
@Repository
public interface IMovelRepository extends JpaRepository <Movel, Long>{
}
