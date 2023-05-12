package pl.edu.pk.student.carrots.cinema.models;

public record Movie(String title, String description, Integer duration, Boolean ageRestricted) {
    this.title = title;
    this.description = description;
    this.duration = duration;
    this.ageRestricted = ageRestricted;
}


