package wheretolunch;

import wheretolunch.model.User;

import static wheretolunch.model.BaseEntity.START_SEQ;

public class UserTestData {

    public static final int USER_ID = START_SEQ;

    public static final User USER = new User(USER_ID, "user@yandex.ru", "User","password");
    public static final User USER_NEW = new User("new@gmail.com", "newName","newPass");

}
