package lk.penguin.repository.custom;

import lk.penguin.entity.User;
import lk.penguin.repository.SuperRepository;
import lk.penguin.util.CrudUtil;

public interface MemberRepository extends CrudUtil<User> {
}
