package pl.jankruk.it.forum.budowlane.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "answer")
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "text")
    private String text;
    @Column(name = "post_id")
    private int postId;
    @Column(name = "answer_user")
    private String answerUser;
    @Column(name = "date")
    private String date;
}
