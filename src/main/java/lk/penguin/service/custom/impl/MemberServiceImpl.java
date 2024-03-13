package lk.penguin.service.custom.impl;

import lk.penguin.dto.UserDto;
import lk.penguin.entity.User;
import lk.penguin.repository.RepositoryFactory;
import lk.penguin.repository.custom.UserRepository;
import lk.penguin.repository.custom.impl.UserRepositoryImpl;
import lk.penguin.service.custom.MemberService;

import java.util.ArrayList;
import java.util.List;

public class MemberServiceImpl implements MemberService {
    UserRepository userRepository= (UserRepository) RepositoryFactory.getRepositoryFactory().getRepository(RepositoryFactory.RepositoryType.USER);

    @Override
    public List<UserDto> getAllMembers() {
        ArrayList<User>users=userRepository.getAll();
        ArrayList<UserDto>userDtos=new ArrayList<>();
        for (User user:users){
            userDtos.add(user.toDto());
        }
        return userDtos;
    }
}
