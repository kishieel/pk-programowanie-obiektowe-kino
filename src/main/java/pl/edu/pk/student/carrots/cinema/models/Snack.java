package pl.edu.pk.student.carrots.cinema.models;

public record Snack(String name, Integer price, Integer quantity) {
    this.name = name;
    this.price = price;
    this.quantity = quantity;
}
