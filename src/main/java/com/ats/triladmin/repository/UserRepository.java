package com.ats.triladmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ats.triladmin.model.User;



@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUsername(String username);

	User save(User user);

	User findByUsernameAndDelStatus(String username, int i);

	List<User> findByDelStatus(int delStatus);

	@Transactional
	@Modifying
	@Query("UPDATE User SET role_id=:roleId WHERE usr_id=:id")
	int updateRoleIdByEmpId(@Param("id") int id, @Param("roleId") int roleId);

	@Transactional
	@Modifying
	@Query("UPDATE User SET token=:token WHERE usr_id=:id")
	int updateUserToken(@Param("id") int userId, @Param("token") String token);

	@Query(value = "select token from m_user where del_status=0", nativeQuery = true)
	List<String> findTokens();

	@Query(value = "select token from m_user where usr_id not in (:usrId) AND del_status=0", nativeQuery = true)
	List<String> findTokensNotIn(@Param("usrId") int frId);

	@Query(value = "select * from m_user where usr_id=:id", nativeQuery = true)
	User findById(@Param("id") int userId);

	@Transactional
	@Modifying
	@Query("UPDATE User SET password=:password,usertype=:usertype,deptId=:deptId WHERE id=:userId")
	int updateUser(@Param("userId") Long id, @Param("password") String password, @Param("usertype") int usertype,
			@Param("deptId") int deptId);
	
	@Transactional
	@Modifying
	@Query("UPDATE User SET del_status=:delStatus WHERE usr_id=:userId")
	int delteUser(@Param("userId") int id, @Param("delStatus") int delStatus);

}