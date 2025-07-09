package org.syazah.aiskit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.syazah.aiskit.models.Question;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, String> {
    @Query(value = "SELECT * FROM question q WHERE q.title REGEXP :pattern OR q.body REGEXP :pattern", nativeQuery = true)
    List<Question> rawFindByTextPattern(@Param("pattern") String pattern);

    @Query(value = "SELECT q.* FROM question q JOIN question_topics qt ON q.id = qt.question_id JOIN topics t ON qt.topic_id = t.id WHERE t.name REGEXP :pattern", nativeQuery = true)
    List<Question> rawFindByTagPattern(@Param("pattern") String pattern);
}
