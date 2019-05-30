package com.example.project.Persistence.Repo;

import com.example.project.Persistence.Entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Integer> {
}
