package com.example.demo.logs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
@Repository
public interface DurationRepository extends JpaRepository<Duration, BigInteger>, DurationRepositoryCustom {

}
