package pl.jankruk.it.forum.budowlane.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "section")
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "topic")
    private String topic;

    public Section(String topic) {
        this.topic = topic;
    }
}
