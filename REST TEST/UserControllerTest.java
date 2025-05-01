package com.cts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.cts.controller.UserController;
import com.cts.entity.User;
import com.cts.service.UserService;

/**
 * Unit testing REST controllers with JUnit and Mockito
 * 
 * @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

 */

//Tells JUnit to use Mockito to inject mocks during the test.
@ExtendWith(MockitoExtension.class)
class UserControllerTest {

	/**
	 * mock the UserService, because in a unit test, we don’t want to test the real
	 * service or database — just the controller logic.
	 * 
	 */
	@Mock
	private UserService userService;
	
	
	/**
	 * This injects the mocked userService into a real instance of UserController.
	 * So we are testing the controller in isolation.
	 * 
	 */
	@InjectMocks
	private UserController userController;
	

	/**
	 * create a fake User object to simulate the data that would normally come from
	 * the database.
	 */
	@Test
	void testGetUserById() {
		User mockUser = new User();
		mockUser.setId(1L);
		mockUser.setUsername("shek");
		mockUser.setEmail("shekjava@gmail.com");

		//When someone calls userService.getUserById(1L), return the mock use
		when(userService.getUserById(1L)).thenReturn(mockUser);
		
		//call the actual controller method (as if a user requested /users/1)
		ResponseEntity<User> response = userController.getUserById(1L);
		
		//Verifies that the controller returns HTTP 200 OK.
		assertEquals(200, response.getStatusCodeValue());
		
		//Verifies that the returned user's username is "shek" — what we mocked earlier.
		assertEquals("shek", response.getBody().getUsername());
	}
}
