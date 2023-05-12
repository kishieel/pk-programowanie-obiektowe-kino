package pl.edu.pk.student.carrots.cinema.utils;

import pl.edu.pk.student.carrots.cinema.actions.Action;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Function;

public class IO {
    public static void menu(String title, List<Action> actions) {
        System.out.println(title);
        AtomicInteger index = new AtomicInteger(1);
        actions.forEach(action -> System.out.println((index.getAndIncrement()) + ". " + action.getTitle()));

        int opt;
        while (true) {
            System.out.print("Wybierz opcje: ");
            opt = IO.input(Integer.class) - 1;
            if (opt >= 0 && opt < actions.size()) break;
            System.out.println("Nieprawidłowy wybór!");
        }

        actions.get(opt).doAction();
    }

    public static <T> void accept(String title, Function<T> ifYes, Function<T> ifNo) {
        System.out.println(title);
        String opt;
        while (true) {
            opt = IO.input(String.class);
            if (opt.equals("Y") || opt.equals("N")) break;
            System.out.println("Nieprawidłowa opcja, wybierz Y/N!");
        }
        if (opt.equals("Y")) ifYes.apply(null);
        else ifNo.apply(null);
    }

    public static <T> T input(Class<T> type) {
        Scanner in = new Scanner(System.in);
        String opt = in.nextLine();

        if (type.equals(Integer.class)) {
            try {
                return type.cast(Integer.valueOf(opt));
            } catch (Exception e) {
                return type.cast(-1);
            }
        }

        return type.cast(opt);
    }
}
