package dynamicproxy;


import springaop.MyLogHandler;
import springaop.User;
import springaop.UserService;
import springaop.UserServiceImpl;

public class Test {

    public static void main(String[] args) {

        User user = new User();
        user.setName("james");
        user.setAge(11);

        MyLogHandler handler = new MyLogHandler();

        UserService userService = (UserService)handler.createProxy(new UserServiceImpl());

        userService.create(user);

        userService.delete(user);

    }
}
