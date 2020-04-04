package com.learning.higashino.repositories;


import com.learning.higashino.components.Sample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleRepository extends JpaRepository<Sample, Integer> {
}
