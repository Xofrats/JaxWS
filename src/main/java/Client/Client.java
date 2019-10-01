package Client;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import shared.User;
import shared.UserDAO;

public class Client{

    public static void main(String[] args) throws Exception {

        URL url = new URL("http://localhost:9990/ws/User?wsdl");

        //1st argument service URI, refer to wsdl document above
        //2nd argument is service name, refer to wsdl document above
        QName qname = new QName("http://Server/", "UserCRUDService");

        Service service = Service.create(url, qname);

        UserDAO hello = service.getPort(UserDAO.class);

        hello.create(1234, "mail", "pass");
        try {
            System.out.println(hello.read(1233).toString());
        } catch (Exception e){
            System.out.println("No user found");
        }
        System.out.println(hello.read(1234));
        hello.update(new User(1234, "mail", "posse"));
        System.out.println(hello.read(1234));

    }

}