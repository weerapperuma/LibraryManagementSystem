package lk.penguin.service.custom.impl;

import lk.penguin.entity.User;
import lk.penguin.repository.RepositoryFactory;
import lk.penguin.repository.custom.UserRepository;
import lk.penguin.repository.custom.impl.UserRepositoryImpl;
import lk.penguin.service.custom.Pane1Service;
import lk.penguin.util.SessionFactoryConfig;
import org.hibernate.Session;

public class Pane1ServiceImpl implements Pane1Service {
    private Session session;
    UserRepository userRepository= (UserRepositoryImpl) RepositoryFactory.getRepositoryFactory().getRepository(RepositoryFactory.RepositoryType.USER);
    @Override
    public boolean isExistsUser(String text, String text1) {
        session= SessionFactoryConfig.getInstance().getSession();
        try{
            userRepository.setSession(session);
            User user=userRepository.ifExists(text);

            if(user.getUserPassword().equals(text1)){
                return true;
            }
            else {
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        finally {
            session.close();
        }
    }
}
