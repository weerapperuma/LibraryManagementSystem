package lk.penguin.repository.custom;

import lk.penguin.entity.User;
import lk.penguin.repository.SuperRepository;

public interface UserRepository extends SuperRepository {
    boolean save(User user);

    User ifExists(String userId);
}
