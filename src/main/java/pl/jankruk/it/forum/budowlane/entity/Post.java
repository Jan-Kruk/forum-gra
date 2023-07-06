package pl.jankruk.it.forum.budowlane.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "post")
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "topic")
    private String topic;
    @Column(name = "text")
    private String text;
    @Column(name = "user_id")
    private int userID;
    @Column(name = "section_id")
    private int sectionId;
    @Column(name = "date")
    private String date;

    public Post(String topic, String text, int userID, int sectionId, String date) {
        this.topic = topic;
        this.text = text;
        this.userID = userID;
        this.sectionId = sectionId;
        this.date = date;
    }
}
