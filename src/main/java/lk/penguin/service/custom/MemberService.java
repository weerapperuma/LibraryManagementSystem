package lk.penguin.service.custom;

import lk.penguin.projection.UserProjection;
import lk.penguin.service.SuperService;

import java.util.List;

public interface MemberService extends SuperService {
    List<UserProjection> getAllMembers();

    boolean delete(int id);
}
