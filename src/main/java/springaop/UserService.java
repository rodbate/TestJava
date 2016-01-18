package springaop;


public interface UserService {

    int create(User user);

    int delete(User user);

    int modify(User user);

    int query();
}
