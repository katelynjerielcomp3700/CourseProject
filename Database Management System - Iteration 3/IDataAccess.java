public interface IDataAccess {
   User loadUser(String username, String password);
   boolean saveUser(User user);
}
