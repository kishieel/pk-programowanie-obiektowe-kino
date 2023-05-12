package pl.edu.pk.student.carrots.cinema.models;

public record User(String login, String password, String name, String surname, String email, int phone) {}