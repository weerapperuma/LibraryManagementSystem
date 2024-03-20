package lk.penguin.service.custom.impl;

import lk.penguin.projection.UserProjection;
import lk.penguin.repository.RepositoryFactory;
import lk.penguin.repository.custom.UserRepository;
import lk.penguin.service.custom.MemberService;
import lk.penguin.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class MemberServiceImpl implements MemberService {
    UserRepository userRepository= (UserRepository) RepositoryFactory.getRepositoryFactory().getRepository(RepositoryFactory.RepositoryType.USER);

    private Session session;

    @Override
    public List<UserProjection> getAllMembers() {
        session= SessionFactoryConfig.getInstance().getSession();
        try {
            userRepository.setSession(session);
            ArrayList<UserProjection>users=userRepository.getAllUserProjection();

            return users;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            session.close();
        }
    }

    @Override
    public boolean delete(int id) {
        session=SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try{
            userRepository.setSession(session);
            userRepository.delete(id);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
