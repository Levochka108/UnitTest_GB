package seminars.third.hw;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import seminars.third.tdd.User;
import seminars.third.tdd.UserRepository;

import java.util.List;


public class UserRepositoryTest {
    @Test
    public void testLogoutAllNonAdminUsers() {
        User admin1 = new User("admin1", "adminpass1", true);
        User admin2 = new User("admin2", "adminpass2", true);
        User user1 = new User("user1", "userpass1", false);
        User user2 = new User("user2", "userpass2", false);

        UserRepository userRepository = new UserRepository();
        userRepository.addUser(admin1);
        userRepository.addUser(admin2);
        userRepository.addUser(user1);
        userRepository.addUser(user2);

        // Проверяем, что изначально есть 2 админа и 2 пользователей
        assertEquals(4, userRepository.getData().size());

        // Разлогиниваем всех не администраторов
        userRepository.logoutAllNonAdminUsers();

        // Проверяем, что остались только админы
        List<User> remainingUsers = userRepository.getData();
        assertEquals(2, remainingUsers.size());
        assertTrue(remainingUsers.contains(admin1));
        assertTrue(remainingUsers.contains(admin2));
        assertFalse(remainingUsers.contains(user1));
        assertFalse(remainingUsers.contains(user2));
    }
}
