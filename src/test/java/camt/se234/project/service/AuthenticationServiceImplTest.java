package camt.se234.project.service;

import camt.se234.project.dao.UserDao;
import org.junit.Before;

import static org.mockito.Mockito.mock;

public class AuthenticationServiceImplTest {
    UserDao userDao;
    AuthenticationServiceImpl authenticationService;

    @Before
    public void setup() {
        userDao = mock(UserDao.class);
        authenticationService = new AuthenticationServiceImpl();
        authenticationService.setUserDao(userDao);
    }
}
