package pl.wb.demo.security.dao;

import pl.wb.demo.security.entity.Role;

public interface RoleDao {
	Role findRoleByName(String theRoleName);
}
