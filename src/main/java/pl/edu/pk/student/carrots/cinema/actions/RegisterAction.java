package pl.edu.pk.student.carrots.cinema.actions;
import pl.edu.pk.student.carrots.cinema.models.User;

import java.util.Scanner;
public class RegisterAction implements SelectableAction
{
    @Override
    public String getTitle() {
        return "Zarejstruj się";
    }
    @Override
    public void doAction()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter login: ");
        String login1 = scanner.nextLine();
        System.out.print("Enter password: ");
        String password1 = scanner.nextLine();
        System.out.print("Enter name: ");
        String name1 = scanner.nextLine();
        System.out.print("Enter surname: ");
        String surname1 = scanner.nextLine();
        System.out.print("Enter email: ");
        String email1 = scanner.nextLine();
        System.out.print("Enter phone number: ");
        int phone1 = Integer.parseInt(scanner.nextLine());

        User user1 = new User(login1, password1, name1, surname1, email1, phone1);
        System.out.println("Registered successfully!");

    }
}
