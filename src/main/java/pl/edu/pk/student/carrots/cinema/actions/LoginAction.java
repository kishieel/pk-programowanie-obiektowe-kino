package pl.edu.pk.student.carrots.cinema.actions;

import pl.edu.pk.student.carrots.cinema.utils.IO;

import java.util.List;
import java.util.Scanner;

public class LoginAction implements Action {
    @Override
    public String getTitle() {
        return "Zaloguj się";
    }

    @Override
    public void doAction() {

        boolean loginExists = false;
        while (loginExists==false)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Wprowadz login: ");
            String login1 = scanner.nextLine();
            System.out.print("Wprowadz haslo: ");
            String password1 = scanner.nextLine();
            Login login = new Login(login1, password1);

            if (login.ifLoginTrue(login1, password1) == true)
            {
                loginExists=true;
                System.out.println("Zalogowano się pomyślnie!");
            }
            else
            {
                System.out.println("Nieprawidłowe dane logowania!");
            }
        }
        IO.menu(
                "Witaj w panelu użytkownika. Jak możemy Ci pomóc?",
                List.of(new ListMoviesAction(), new ListSnacksAction(), new LogoutAction())
        );
    }

    private class Login {
        private String login;
        private String password;

        Login(String login, String password) {
            this.login = login;
            this.password = password;
        }

        private boolean ifLoginTrue(String login, String password)
        {
            if (this.login == login && this.password == password)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }
}
