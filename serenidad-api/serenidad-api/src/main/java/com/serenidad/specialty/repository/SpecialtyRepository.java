package com.serenidad.specialty.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serenidad.specialty.entity.Specialty;

public interface SpecialtyRepository extends JpaRepository<Specialty, Long> {

	List<Specialty> findByActiveTrueOrderByDisplayOrderAsc();

	Optional<Specialty> findBySlugAndActiveTrue(String slug);
}