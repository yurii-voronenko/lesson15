package cc.robotdreams.university;

import cc.robotdreams.university.base.User;

public class Teacher extends User
{

    public Teacher(String username, String password) {
        super(username, password);
    }

    @Override
    final public Type getType() {
        return Type.TEACHER;
    }
}
