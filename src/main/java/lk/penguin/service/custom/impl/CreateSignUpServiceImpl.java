package lk.penguin.service.custom.impl;

import lk.penguin.dto.UserDto;
import lk.penguin.repository.RepositoryFactory;
import lk.penguin.repository.custom.UserRepository;
import lk.penguin.repository.custom.impl.UserRepositoryImpl;
import lk.penguin.service.custom.CreateSignUpService;
import lk.penguin.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CreateSignUpServiceImpl implements CreateSignUpService {
    UserRepository userRepository= (UserRepositoryImpl) RepositoryFactory.getRepositoryFactory().getRepository(RepositoryFactory.RepositoryType.USER);
    private Session session;
    @Override
    public int saveNewUser(UserDto userDto) {
        session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            userRepository.setSession(session);
            int save = userRepository.save(userDto.toEntity());
            transaction.commit();
            return save;
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
            return 0;
        }
    }
}
