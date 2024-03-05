package lk.penguin.repository.custom;

import lk.penguin.entity.Admin;
import lk.penguin.repository.SuperRepository;

public interface AdminRepository extends SuperRepository {
    Admin ifExists(String userId);
}
