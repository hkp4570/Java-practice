package atmsystem;

import java.util.HashMap;

public class AtmDao {
    private FileLoaderAndCommit flac = new FileLoaderAndCommit("src\\atmsystem\\User.txt");

    private HashMap<String, User> userBox = flac.loadFile();

    public User selectOne(String name){
        return userBox.get(name);
    }

    public void update(User user){
        userBox.put(user.getName(), user);
        flac.commit(userBox);
    }
}
