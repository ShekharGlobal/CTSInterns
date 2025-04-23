package com.cts.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cts.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
	
	//Derived Query Methods
	//Query Generated from method name
	Optional<User> findByUsername(String username);

    List<User> findByEmailContaining(String keyword);

    List<User> findByUsernameAndEmail(String username, String email);

    List<User> findByUsernameStartingWith(String prefix);
    
    
    //Custom Query
    //Using @Query Annotation JPQL or Native SQL)
 // JPQL
    @Query("SELECT u FROM User u WHERE u.email = :email")
    User getUserByEmail(@Param("email") String email);

    //Custom Query
    //Using @Query Annotation  Native SQL)
    @Query(value = "SELECT * FROM user WHERE username LIKE CONCAT('%', :name, '%')", nativeQuery = true)
    List<User> searchByUsername(@Param("name") String name);

    
    //NamedQuery and NamedQueries
    @Query(name = "User.findByEmail")
    User findByEmail(String email);
    
   
   



    
    
}
