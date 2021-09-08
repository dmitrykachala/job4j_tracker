package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        for (User user : users) {
            if (user.getUsername().equals(login)) {
                return user;
            }
        }
        throw new UserNotFoundException("User is not found");
    }

    public static boolean validate(User user) throws UserInvalidException {
        if ((!user.isValid()) || (user.getUsername().length() < 3)) {
            throw new UserInvalidException("The user " + user.getUsername() + " is not valid.");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("PetrArsentev", false)
        };
        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException ui) {
            System.out.println("User is not valid.");
            ui.printStackTrace();
        } catch (UserNotFoundException unf) {
            System.out.println("User is not found.");
            unf.printStackTrace();
        }
    }
}
