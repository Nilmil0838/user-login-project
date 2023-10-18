import java.util.HashMap;

public class IDandPasswords {

    HashMap<String, String> userinfo = new HashMap<String, String>();
    HashMap<String, String> admininfo = new HashMap<String, String>();

    IDandPasswords () {

        userinfo.put("user1", "123");
        userinfo.put("user2", "123");
        userinfo.put("user3", "123");
        userinfo.put("user4", "123");

        admininfo.put("admin", "321");

    }

    protected HashMap getUserInfo() {
        return userinfo;
    }

    protected HashMap getAdminInfo() {
        return admininfo;
    }
}
