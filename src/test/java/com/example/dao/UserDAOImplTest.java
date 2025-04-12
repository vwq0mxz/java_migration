package com.example.dao;

import com.example.model.User;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class UserDAOImplTest {
    private UserDAO userDAO;

    @Before
    public void setUp() {
        userDAO = new UserDAOImpl();
    }

    @Test
    public void testCreateUser() {
        User user = new User(null, "John Doe", "john@example.com");
        User created = userDAO.create(user);
        
        assertNotNull(created.getId());
        assertEquals("John Doe", created.getName());
        assertEquals("john@example.com", created.getEmail());
    }

    @Test
    public void testReadUser() {
        // Create a user first
        User user = new User(null, "Jane Doe", "jane@example.com");
        User created = userDAO.create(user);

        // Read the user
        User read = userDAO.read(created.getId());
        assertNotNull(read);
        assertEquals(created.getId(), read.getId());
        assertEquals("Jane Doe", read.getName());
        assertEquals("jane@example.com", read.getEmail());
    }

    @Test
    public void testReadAllUsers() {
        // Create multiple users
        userDAO.create(new User(null, "User1", "user1@example.com"));
        userDAO.create(new User(null, "User2", "user2@example.com"));

        List<User> users = userDAO.readAll();
        assertNotNull(users);
        assertTrue(users.size() >= 2);
    }

    @Test
    public void testUpdateUser() {
        // Create a user first
        User user = new User(null, "Old Name", "old@example.com");
        User created = userDAO.create(user);

        // Update the user
        created.setName("New Name");
        created.setEmail("new@example.com");
        User updated = userDAO.update(created);

        assertNotNull(updated);
        assertEquals("New Name", updated.getName());
        assertEquals("new@example.com", updated.getEmail());

        // Verify the update by reading
        User read = userDAO.read(updated.getId());
        assertEquals("New Name", read.getName());
        assertEquals("new@example.com", read.getEmail());
    }

    @Test
    public void testDeleteUser() {
        // Create a user first
        User user = new User(null, "To Delete", "delete@example.com");
        User created = userDAO.create(user);

        // Delete the user
        boolean deleted = userDAO.delete(created.getId());
        assertTrue(deleted);

        // Verify deletion
        User read = userDAO.read(created.getId());
        assertNull(read);
    }
}