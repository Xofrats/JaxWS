package Server;

import shared.User;
import shared.UserDAO;

import javax.jws.WebService;
import java.util.ArrayList;

@WebService(endpointInterface = "shared.UserDAO")
public class UserCRUD implements UserDAO {

    ArrayList<User> users = new ArrayList<User>();

    public User create(int cpr, String email, String password) {
        User user = new User(cpr, email, password);
        users.add(user);
        return user;
    }

    public User read(int cpr) {
        for (User user : users) {
            if(user.getId()==cpr){
                return user;
            }
        }
        return null;
    }

    public void update(User newOne) {
        for (User user : users) {
            int id1 = user.getId();
            int id2 = newOne.getId();
            System.out.println("ID 1: " + id1);
            System.out.println("ID 2: " + id2);
            if(user.getId() == newOne.getId()){
                System.out.println("gik ind i if");
                user.setEmail(newOne.getEmail());
                user.setPassword(newOne.getPassword());
            }
        }
    }

    public void delete(User user) {
        for (User list : users) {
            if(list.getId() == user.getId()){
                users.remove(list);
            }
        }
    }

    public String getHelloWorldAsString(String name) {
        return "Testing " + name;
    }
}
