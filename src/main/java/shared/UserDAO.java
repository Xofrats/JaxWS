package shared;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)

public interface UserDAO {
   @WebMethod public User create(int cpr, String email, String password);
   @WebMethod public User read(int cpr);
   @WebMethod  public void update(User user);
   @WebMethod  public void delete(User user);


}
