package org.dnyanyog.dao;

import org.dnyanyog.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersDao extends JpaRepository<Users, Integer> {
	public Users findByPassword(String password);

	public Users findByLoginName(String loginName);

	
}