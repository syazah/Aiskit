package org.syazah.aiskit.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Answer extends ParentModel {

    @Column(nullable = false)
    private String text;

    @ManyToOne
    private User user;

    @ManyToOne
    private Question question;
}
