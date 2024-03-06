package lk.penguin.service.custom.impl;

import lk.penguin.dto.UserDTO;
import lk.penguin.entity.Admin;
import lk.penguin.entity.User;
import lk.penguin.repository.RepositoryFactory;
import lk.penguin.repository.custom.AdminRepository;
import lk.penguin.repository.custom.UserRepository;
import lk.penguin.service.custom.WelcomeService;

public class WelcomeServiceImpl implements WelcomeService {

    AdminRepository adminRepository= (AdminRepository) RepositoryFactory.getRepositoryFactory().getRepository(RepositoryFactory.RepositoryType.ADMIN);
    UserRepository userRepository= (UserRepository) RepositoryFactory.getRepositoryFactory().getRepository(RepositoryFactory.RepositoryType.USER);
    @Override
    public boolean chekAdmin(String userId, String password) {
        Admin admin=adminRepository.ifExists(userId);
        if(admin!=null){
            return admin.getPassword().equals(password);
        }
        return false;
    }

    @Override
    public boolean chekMember(String userId, String password) {

        return false;
    }

    @Override
    public boolean saveUser(UserDTO userDTO) {
        User user=new User(
                userDTO.getUserId(),
                userDTO.getUserName(),
                userDTO.getUserEmail(),
                userDTO.getUserPassword());
        if(userRepository.save(user)){
            return true;
        }
        return false;
    }


}
