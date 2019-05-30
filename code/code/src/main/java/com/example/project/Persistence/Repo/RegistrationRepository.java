package com.example.project.Persistence.Repo;

import com.example.project.Persistence.Entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<Registration, Integer> {
}
