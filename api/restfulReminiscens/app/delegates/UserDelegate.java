package delegates;

import java.util.ArrayList;
import java.util.List;

import pojos.UserBean;
import utils.PlayDozerMapper;

public class UserDelegate {
    
    public static UserDelegate getInstance(){
        return new UserDelegate();
    }

    public List<UserBean> getAll() {
        List<models.User> modelUser = models.User.all();
        List<UserBean> userPojos = new ArrayList<UserBean>();
        for (models.User user : modelUser) {
            UserBean userBean = PlayDozerMapper.getInstance().map(user, UserBean.class);
            userPojos.add(userBean);
        }
        return userPojos;
    }

    public UserBean getUser(Long id) {
        models.User user = models.User.read(id);
        if (user != null) {
        	UserBean userBean = PlayDozerMapper.getInstance().map(user, UserBean.class);
        	return userBean;
        } else {
        	return null; 
        }
    }

    public UserBean getUserByEmail(String email) {
        models.User user = models.User.getByEmail(email);
        if (user != null) {
        	UserBean userBean = PlayDozerMapper.getInstance().map(user, UserBean.class);
        	return userBean;
        } else {
        	return null; 
        }
    }


    public void create(UserBean userBean){
        models.User user = PlayDozerMapper.getInstance().map(userBean, models.User.class);
        models.User.create(user);
        user = models.User.read(user.getUserId());
        PlayDozerMapper.getInstance().map(user,userBean);
    }

    public void update(UserBean bean, Long id) {
        models.User person = PlayDozerMapper.getInstance().map(bean, models.User.class);
        person.update(id);
        person = models.User.read(person.getUserId());
        PlayDozerMapper.getInstance().map(person,bean);
    }

    public void deleteUser(Long id) {
        models.User.delete(id);
    }

	public void deleteUserForce(Long uid) {
        models.User.deleteForce(uid);
	}
}
