package org.syazah.aiskit.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Question extends ParentModel {

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String body;

    @ManyToMany
    @JoinTable(
            name = "question_topics",
            joinColumns = @JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "topic_id")
    )
    private List<Topics> topic = new ArrayList<>();

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "question")
    private List<Answer> answers = new ArrayList<>();
}
