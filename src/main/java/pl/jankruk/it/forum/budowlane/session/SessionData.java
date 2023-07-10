package pl.jankruk.it.forum.budowlane.session;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import pl.jankruk.it.forum.budowlane.entity.User;

@NoArgsConstructor
@Getter
@Setter
@Component
@SessionScope
public class SessionData {
    private User user = null;

    public boolean isLogged() {
        return this.user != null;
    }

    public boolean isAdmin() {
        if(this.user == null) {
            return false;
        }

        return User.Role.valueOf(this.user.getRole()) == User.Role.ADMIN;
    }
    public String getName(){
        if (isLogged()){
        return this.user.getName();
        }
        return null;
    }
    public int getId(){
        if (isLogged()){
            return this.user.getId();
        }
        return 0;
    }
    public String getDate(){
        if (isLogged()){
            return this.user.getCreationDate();
        }
        return null;
    }
}
