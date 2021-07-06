package ru.myapp.storage;

import ru.myapp.models.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*
 * класс - сингльтон (приватный конструктор и статический метод для получения экземпляра класса)
 * один объект в котором хранятся все пользователи, типа базы данных только в памяти
 */

public class Storage {

    private static final Storage storage;
    private List<User> users;

    static{
        storage = new Storage();
    }

    private Storage(){
        /*
         * хранилище
         */
        users = new ArrayList<>();
        User user = new User("Sunny", "qwerty7", LocalDate.parse("2015-07-14"));
        User user1 = new User("Ringo", "qwerty", LocalDate.parse("2020-07-14"));
        User user2 = new User("Nike", "qwerty1", LocalDate.parse("2010-07-14"));

        users.add(user);
        users.add(user1);
        users.add(user2);
    }

    public static Storage getStorage(){
        return storage;
    }

    public List<User> getUsers(){
        return users;
    }
}