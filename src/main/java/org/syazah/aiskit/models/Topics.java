package org.syazah.aiskit.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Topics extends ParentModel {
    @Column(nullable = false)
    private String name;
}
