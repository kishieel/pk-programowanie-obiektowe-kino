package pl.edu.pk.student.carrots.cinema.utils;

import pl.edu.pk.student.carrots.cinema.actions.Action;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class IO {
    public static void menu(String title, List<Action> actions) {
        System.out.println(title);
        AtomicInteger index = new AtomicInteger(1);
        actions.forEach(action -> System.out.println((index.getAndIncrement()) + ". " + action.getTitle()));

        while (true) {
            System.out.print("Wybierz opcje: ");
            int opt = IO.input(Integer.class);
            if (opt - 1 >= 0 && opt - 1 < actions.size()) break;
            System.out.println("Nieprawidłowy wybór!");
        }
    }

    public static <T> T input(Class<T> type) {
        Scanner in = new Scanner(System.in);
        String opt = in.nextLine();

        if (type.equals(Integer.class)) {
            try {
                return type.cast(Integer.parseInt(opt));
            }   catch (Exception e) {
                return type.cast(-1);
            }
        }

        return type.cast(opt);
    }
}
