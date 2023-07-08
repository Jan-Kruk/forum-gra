package pl.jankruk.it.forum.budowlane;

import pl.jankruk.it.forum.budowlane.entity.MainSection;
import pl.jankruk.it.forum.budowlane.utils.DateUtil;

public class TestAPP {
    public static void main(String[] args) {
        System.out.println(new MainSection("hello"));
        System.out.println(new MainSection("hello"));
        System.out.println(new MainSection("hello"));
        System.out.println(DateUtil.getCurrentDate());
    }
}
