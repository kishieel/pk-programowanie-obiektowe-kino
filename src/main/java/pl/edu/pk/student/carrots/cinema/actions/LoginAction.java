package pl.edu.pk.student.carrots.cinema.actions;
import java.util.Scanner;
public class LoginAction implements Action
{
    private class Login
    {
        private String login;
        private String password;

        Login(String login, String password)
        {
            this.login = login;
            this.password = password;
        }

        private boolean ifLoginTrue(String login, String password)
        {
            if (this.login==login && this.password==password)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }
    @Override
    public String getTitle() {
        return "Zaloguj się";
    }

    @Override
    public void doAction()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter login: ");
        String login1 = scanner.nextLine();
        System.out.print("Enter password: ");
        String password1 = scanner.nextLine();
        Login login = new Login(login1, password1);

        if (login.ifLoginTrue(login1, password1)==true)
        {
            System.out.println("Login successful!");
        } else
        {
            System.out.println("Invalid login details.");
        }
    }
}
