package Server;

import javax.xml.ws.Endpoint;
import Server.UserCRUD;

public class UserPublisher {
        public static void main(String[] args) {
            Endpoint.publish("http://localhost:9990/ws/User", new UserCRUD());
        }


}
