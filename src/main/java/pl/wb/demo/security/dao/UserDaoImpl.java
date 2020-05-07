package pl.wb.demo.security.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.wb.demo.security.entity.User;

import javax.persistence.EntityManager;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public User findByUserEmail (String theUserEmail) {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // now retrieve/read from database using email
        Query<User> theQuery = currentSession.createQuery("from User where email=:uEmail", User.class);
        theQuery.setParameter("uEmail", theUserEmail);

        User theUser = null;
        try {
            theUser = theQuery.getSingleResult();
        } catch (Exception e) {
            theUser = null;
        }

        return theUser;
    }

    @Override
    public User findByUserName (String theUserName) {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // now retrieve/read from database using username
        Query<User> theQuery = currentSession.createQuery("from User where userName=:uName", User.class);
        theQuery.setParameter("uName", theUserName);

        User theUser = null;
        try {
            theUser = theQuery.getSingleResult();
        } catch (Exception e) {
            theUser = null;
        }

        return theUser;
    }

    @Override
    public void save (User theUser) {
        // get current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create the user ... finally LOL
        currentSession.saveOrUpdate(theUser);
    }
}
