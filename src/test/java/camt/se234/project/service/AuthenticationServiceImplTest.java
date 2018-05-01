package camt.se234.project.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;

import camt.se234.project.dao.UserDao;
import camt.se234.project.entity.User;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.nullValue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AuthenticationServiceImplTest {
    UserDao userDao;
    AuthenticationServiceImpl authenticationService;

    @Before
    public void setup() {
        userDao = mock(UserDao.class);
        authenticationService = new AuthenticationServiceImpl();
        authenticationService.setUserDao(userDao);
    }
    @Test
    public void testAuthenicateWithMock() {
        when(userDao.getUser("kuribohw", "12345")).thenReturn(new User("kuribohw", "12345", "student"));
        assertThat(authenticationService.authenticate("kuribohw", "12345"), is(new User("kuribohw", "12345", "student")));
        assertThat(authenticationService.authenticate("kuribohw", "123456"), is(nullValue()));

    }
}
