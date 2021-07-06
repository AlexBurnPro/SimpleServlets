package ru.myapp.repositories;

import ru.myapp.models.User;
import ru.myapp.storage.Storage;

import java.util.List;

/**
 * список Users хранится в Storage (класс сингльтон)
 * объект сингльтон обладает списком ArrayList<Users>
 * контракт: добавить User, авторизация и отдать коллекцию Users
 */

public class UserRepositoriesImpl implements UserRepository{

    @Override
    public List<User> findAll() {
        return Storage.getStorage().getUsers();
    }

    @Override
    public void save(User user) {
        Storage.getStorage().getUsers().add(user);
    }

    /**
     * авторизация
     */
    @Override
    public boolean isExist(String name, String password) {
        for(User user : Storage.getStorage().getUsers()){
            if(user.getName().equals(name) && user.getPassword().equals(password)) return true;
        }
        return false;
    }
}
