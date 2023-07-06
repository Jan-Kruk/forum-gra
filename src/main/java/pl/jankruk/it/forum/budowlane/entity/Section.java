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
    @Column(name = "main_section_id")
    private int mainSectionId;

    public Section(String topic, int mainSectionId) {
        this.topic = topic;
        this.mainSectionId = mainSectionId;
    }
}
