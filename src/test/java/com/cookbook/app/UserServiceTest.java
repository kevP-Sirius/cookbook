package com.cookbook.app;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.junit.Assert.assertEquals;

import com.cookbook.app.Entity.User;
import com.cookbook.app.Repository.UserRepository;
import com.cookbook.app.Service.User.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void testCreateUser() {
        // Given
        User expectedUser = new User("John", "Doe", "johndoe@example.com");
        when(userRepository.save(expectedUser)).thenReturn(expectedUser);

        // When
        User actualUser = userService.createUser(expectedUser);

        // Then
        verify(userRepository).save(expectedUser);
        assertEquals(expectedUser, actualUser);
    }
}
