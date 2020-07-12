import dao.UserDao;
import dao.impl.AppUserDao;
import model.AppUser;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
//        Set<AppUser> users = new HashSet<>();
//        AppUser user = new AppUser();
//        boolean remove = users.remove(user);
//        System.out.println(remove);

        UserDao userDao = new AppUserDao();
        AppUser user1 = new AppUser("user1login", "user1name", "user1lastName",
                "user1password", "user1@email.com", new Date());
        userDao.saveUser(user1);

        AppUser user2 = new AppUser();
        user2.setLogin("user2login");
        user2.setName("user2name");
        user2.setLastName("user2lastName");
        user2.setPassword("user2password");
        user2.setEmail("user2@email.com");
        user2.setDateOfRegistartion(new Date());
        userDao.saveUser(user2);


        userDao.follow("user1login", "user2login");
        AppUser user2login = userDao.getUserByLogin("user2login");
        Set<AppUser> followers = user2login.getFollowers();
        userDao.stopFollowing("user1login", "user2login");
        AppUser user2login2 = userDao.getUserByLogin("user2login");
        HashSet<AppUser> followers2 = userDao.getFollowers(user2login2.getLogin());

        System.out.println(followers.size());
        System.out.println(followers2.size());
        userDao.saveUser(user2login2);
//        user1.getFollowers().forEach(System.out::println);




    }
}
