package org.syazah.aiskit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.syazah.aiskit.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
