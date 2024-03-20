package lk.penguin.repository.custom;

import lk.penguin.entity.User;
import lk.penguin.projection.UserProjection;
import lk.penguin.repository.SuperRepository;
import lk.penguin.util.CrudUtil;

import java.util.ArrayList;

public interface UserRepository extends CrudUtil<User> {
    ArrayList<UserProjection> getAllUserProjection();
}
