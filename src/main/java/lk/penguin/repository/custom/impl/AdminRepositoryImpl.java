package lk.penguin.repository.custom.impl;

import lk.penguin.dto.BranchDto;
import lk.penguin.entity.Admin;
import lk.penguin.repository.custom.AdminRepository;
import lk.penguin.util.SessionFactoryConfig;
import org.hibernate.Session;

import java.util.ArrayList;

public class AdminRepositoryImpl implements AdminRepository {
    private Session session;

    @Override
    public Admin ifExists(String userId) {
        try{
            Integer adminId = Integer.valueOf(userId);
            //Admin admin = session.get(Admin.class, adminId);
            Admin admin= (Admin) session.createQuery("FROM Admin WHERE adminLoginID = :adminLoginID")
                    .setParameter("adminLoginID",adminId)
                    .uniqueResult();


            //System.out.println(admin.getAdminName());
            if(admin==null){
                System.out.println("admin is null");
                return null;
            }
            return admin;
        }
        catch(Exception e){
            e.printStackTrace();
            throw e;
        }

    }

    @Override
    public ArrayList<Admin> getAll() {
        return null;
    }

    @Override
    public int save(Admin entity) {
        return -1;
    }

    @Override
    public void delete(int id){}

    @Override
    public void update(Admin entity) {
    }

    @Override
    public void setSession(Session session) {
        this.session=session;
    }
}
