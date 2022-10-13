public class Data {

    public static void check(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {

        if (checkLogin(login) && checkPassword(password, confirmPassword)) {
            System.out.println("Логин и пароль введены корректно!");
        } else {
            throw new WrongLoginException("Введены некорректные данные!");
        }

    }

    private static boolean checkLogin(String login) throws WrongLoginException {
        boolean checkLog = false;
        if (login.matches("^[a-z0-9_]{1,20}$")) {
            checkLog = true;
        } else {
            throw new WrongLoginException("Неверно введен логин!");
        }
        return checkLog;
    }

    private static boolean checkPassword(String password, String confirmPassword) throws WrongPasswordException {
        boolean checkPass = false;
        if (password.matches("^[a-z0-9_]{1,20}$") && confirmPassword.equals(password)) {
            checkPass = true;
        } else {
            throw new WrongPasswordException("Неверно введен пароль или пароли не совпадают!");
        }
        return checkPass;
    }
}