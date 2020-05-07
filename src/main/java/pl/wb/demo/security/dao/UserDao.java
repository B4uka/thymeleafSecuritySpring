package pl.wb.demo.security.dao;

import pl.wb.demo.security.entity.User;

public interface UserDao {

    User findByUserName (String userName);

    User findByUserEmail (String userName);

    void save (User user);
}
