package ru.myapp.repositories;

import ru.myapp.models.User;

import java.util.List;

/**
 * интерфейс задает поведение, обязательное для класса реализующего интерфейс
 * каждый класс может доставать пользователей откуда угодно (из БД, диска, получать внешним файлом)
 * но класс должен отдать их как List<User> т.е в виде коллекции List
 */

public interface UserRepository {
    List<User> findAll();
    void save(User user);
}
