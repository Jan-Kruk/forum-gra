package pl.jankruk.it.forum.budowlane.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "mainsection")
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class MainSection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "section_name")
    private String sectionName;

    public MainSection(String sectionName) {
        this.sectionName = sectionName;
    }
}
