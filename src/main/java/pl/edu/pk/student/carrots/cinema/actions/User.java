package pl.edu.pk.student.carrots.cinema.actions;

public class User
{
    private String login;
    private String password;
    private String name;
    private String surname;
    private String email;
    private int phone;

    User(String login, String password, String name, String surname, String email, int phone)
    {
        this.login = login;
        this.password = password;
        this.name=name;
        this.surname=surname;
        this.email=email;
        this.phone=phone;
    }
}
