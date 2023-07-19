package cc.robotdreams;

import cc.robotdreams.university.OnlineLesson;
import cc.robotdreams.university.Student;
import cc.robotdreams.university.Teacher;
import cc.robotdreams.university.base.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new Teacher("teacher", "12345"));
        users.add(new Student("student1","100"));
        users.add(new Student("student2","200"));
        users.add(new Student("student3","300"));
        users.add(new Student("student4","400"));
        users.add(new Student("student5","500"));

        OnlineLesson lesson = new OnlineLesson();

        Scanner sc = new Scanner(System.in);
        // Daemon
        while(true) {
            System.out.print("Enter username: ");
            String username = sc.nextLine();
            System.out.print("Enter password: ");
            String password = sc.nextLine();
            boolean isSuccessLogin = false;
            for (User user : users) {
                if(user.username.equalsIgnoreCase(username)) {
                    if (user.login(password)) {
                        lesson.addUser(user);
                        isSuccessLogin = true;
                        break;
                    } else if (user.isBlocked()) {
                        System.err.println(user.id + " користувача заблоковано!");
                    }
                }
            }
            if (!isSuccessLogin) {
                System.err.println("Не вірний логін чи пароль");
                System.err.flush();
            }

            System.out.println("Для входу натисніть Enter або напишіть exit для виходу з програми: ");

            String keyWord = sc.nextLine();
            if (keyWord.equalsIgnoreCase("exit"))
                break;
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (Throwable e) { /* Ignore */ }
        }

    }
}