package cc.robotdreams.university;

import cc.robotdreams.university.base.User;

import java.util.ArrayList;
import java.util.List;

public class OnlineLesson
{
    private boolean isOnline = false;

    private Teacher _teacher;

    final private List<User> _users = new ArrayList<>();

    final public void addUser(User user) {
        if (user != null) {
            this._users.add(user);
            if (user.getType() == User.Type.TEACHER) {
                this._teacher = (Teacher) user;
                this.isOnline = true;
                System.out.println("Викладач " + user.username + " приєднується до заняття!");
                System.out.println("Урок розпочато!");

            } else if (user.getType() == User.Type.STUDENT) {
                System.out.println("Студент " + user.username + " з id=" +  user.id + " приєднується до заняття!");
                if (isOnline)
                    System.out.println("Заняття вже розпочато. Будь ласка більше не запізнюйтесь");
                else
                    System.out.println("Очікуємо викладача. Будь ласка зачекайте!");
            } else {
                throw new RuntimeException("Unknown type for user id: " + user.id);
            }
        }
    }

    final public List<User> users() {
        return new ArrayList<>(this._users);
    }

}
