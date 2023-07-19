package cc.robotdreams.university;

import cc.robotdreams.university.base.User;

public class Student extends User
{

    public Student(String username, String password) {
        super(username, password);
    }

    @Override
    final public Type getType() {
        return Type.STUDENT;
    }

}
