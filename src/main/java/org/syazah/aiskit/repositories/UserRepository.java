package org.syazah.aiskit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.syazah.aiskit.models.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
