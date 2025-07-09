package org.syazah.aiskit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.syazah.aiskit.models.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, String> {

}
