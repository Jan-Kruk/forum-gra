package pl.jankruk.it.forum.budowlane.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class User {
    private int id;
    private String login;
    private String password;
    private String name;
    private String surname;
    private String email;
    private Role role;


    public enum Role {
        ADMIN,
        USER
    }
}
