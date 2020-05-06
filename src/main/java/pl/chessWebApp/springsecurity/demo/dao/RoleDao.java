package pl.chessWebApp.springsecurity.demo.dao;

import pl.chessWebApp.springsecurity.demo.entity.Role;

public interface RoleDao {
	Role findRoleByName(String theRoleName);
}
