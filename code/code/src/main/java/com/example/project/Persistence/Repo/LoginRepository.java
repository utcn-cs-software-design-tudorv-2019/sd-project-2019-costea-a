package com.example.project.Persistence.Repo;

import com.example.project.Persistence.Entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Integer> {
}

