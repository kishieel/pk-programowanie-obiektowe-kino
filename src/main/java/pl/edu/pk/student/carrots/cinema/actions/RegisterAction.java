package pl.edu.pk.student.carrots.cinema.actions;
import pl.edu.pk.student.carrots.cinema.models.User;
import pl.edu.pk.student.carrots.cinema.repositories.UserRepository;

import java.util.Scanner;
public class RegisterAction extends SelectableAction
{
    UserRepository userRepository = UserRepository.getInstance();

    @Override
    public String getTitle() {
        return "Zarejstruj się";
    }
    @Override
    public void doAction()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Wprowadz login: ");
        String login = scanner.nextLine();
        System.out.print("Wprowadz haslo: ");
        String password = scanner.nextLine();
        System.out.print("Wprowadz imie: ");
        String name = scanner.nextLine();
        System.out.print("Wprowadz nazwisko: ");
        String surname = scanner.nextLine();
        System.out.print("Wprowadz email: ");
        String email = scanner.nextLine();
        System.out.print("Wprowadz numer telefonu: ");
        int phone = Integer.parseInt(scanner.nextLine());

        User user = new User(login, password, name, surname, email, phone, false);
        userRepository.add(user);

        System.out.println("Zarejestrowano się pomyślnie!");
        new UserHomeAction().doAction();
    }
}
