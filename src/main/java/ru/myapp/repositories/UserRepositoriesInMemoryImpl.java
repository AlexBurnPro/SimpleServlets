package ru.myapp.repositories;

import ru.myapp.models.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Users получаются внутри конструктора
 * как только объект будет инициализирован, он будет обладать списком ArrayList<Users>
 * заключаем контракт: нужно добавить User  и отдать коллекцию Users
 */

public class UserRepositoriesInMemoryImpl implements UserRepository{

    private final List<User> users;

    public UserRepositoriesInMemoryImpl() {
        this.users = new ArrayList<>();

        User user = new User("Sunny", "qwerty7", LocalDate.parse("2015-07-14"));
        User user1 = new User("Ringo", "qwerty", LocalDate.parse("2020-07-14"));
        User user2 = new User("Nike", "qwerty1", LocalDate.parse("2010-07-14"));

        users.add(user);
        users.add(user1);
        users.add(user2);
    }

    @Override
    public List<User> findAll() {
        return this.users;
    }

    @Override
    public void save(User user) {
        users.add(user);
    }
}
