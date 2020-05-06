package pl.chessWebApp.springsecurity.demo.dao;

import pl.chessWebApp.springsecurity.demo.entity.User;

public interface UserDao {

    User findByUserName (String userName);

    User findByUserEmail (String userName);

    void save (User user);
}
