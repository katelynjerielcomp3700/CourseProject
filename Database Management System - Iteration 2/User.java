public class User {
   private int userID;
   private String userName;
   private String password;
   private String displayName;
   private int isManager;
   
   public int getUserID() {
      return userID;
   }
   
   public void setUserID(int userID) {
      this.userID = userID;
   }
   
   public String getUserName() {
      return userName;
   }
   
   public void setUserName(String userName) {
      this.userName = userName;
   }
   
   public String getPassword() {
      return password;
   }
   
   public void setPassword(String password) {
      this.password = password;
   }
   
   public String getDisplayName() {
      return displayName;
   }
   
   public void setDisplayName(String displayName) {
      this.displayName = displayName;
   }
   
   public int getManagerStatus() {
      return isManager;
   }
   
   public void setManagerStatus(int isManager) {
      this.isManager = isManager;
   }
}