package springaop;


public class UserServiceImpl implements UserService{
    @Override
    public int create(User user) {
        System.out.println("user name is " + user.getName());
        System.out.println("method create is executed.......");
        return 1;
    }

    @Override
    public int delete(User user) {
        System.out.println("user name is " + user.getName());
        System.out.println("method delete is executed.......");
        return 1;
    }

    @Override
    public int modify(User user) {
        System.out.println("user name is " + user.getName());
        System.out.println("method modify is executed.......");
        return 1;
    }

    @Override
    public int query() {
        System.out.println("method query is executed.......");
        return 1;
    }
}
