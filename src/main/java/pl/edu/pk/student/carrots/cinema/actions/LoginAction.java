package pl.edu.pk.student.carrots.cinema.actions;

import pl.edu.pk.student.carrots.cinema.models.User;
import pl.edu.pk.student.carrots.cinema.repositories.UserRepository;

import java.util.Optional;
import java.util.Scanner;

public class LoginAction extends SelectableAction {
    @Override
    public String getTitle() {
        return "Zaloguj się";
    }

    @Override
    public void doAction() {

        boolean loginExists = false;
        while (!loginExists)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Wprowadz login: ");
            String login1 = scanner.nextLine();
            System.out.print("Wprowadz haslo: ");
            String password1 = scanner.nextLine();
            Login login = new Login(login1, password1);

            if (login.ifLoginTrue(login1, password1))
            {
                loginExists=true;
                System.out.println("Zalogowano się pomyślnie!");
                if (login.isAdmin()) {
                    new AdminHomeAction().doAction();
                } else {
                    new UserHomeAction().doAction();
                }
            }
            else
            {
                System.out.println("Nieprawidłowe dane logowania!");
                new LoginAction().doAction();
            }
        }

    }

    private class Login {
        Optional<User> user;
        UserRepository userRepository = UserRepository.getInstance();

        Login(String login, String password) {
            this.user = userRepository.findByLoginAndPassword(login, password);
        }

        private boolean ifLoginTrue(String login, String password)
        {
            return user.isPresent();
        }

        private boolean isAdmin() {
            return user.get().isAdmin();
        }
    }
}
