package yongs.temp.inf;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import yongs.temp.vo.User;

@WebService(targetNamespace = "http://ws.yongs.temp.com")
public interface UserService {
    @WebMethod
    String getUserName(@WebParam(name = "userId") int userId);

    @WebMethod
    User getUser(@WebParam(name = "userId") int userId);

    @WebMethod
    List<User> getUserList(@WebParam(name = "userId") int userId);
}
