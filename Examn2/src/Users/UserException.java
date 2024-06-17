package Users;

//Custom exception for user validation errors
class UserException extends Exception {
 public UserException(String message) {
     super(message);
 }
}