package lk.penguin.repository.custom.impl;

import lk.penguin.entity.Admin;
import lk.penguin.repository.custom.AdminRepository;
import lk.penguin.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class AdminRepositoryImpl implements AdminRepository {
    private Session session;

    public AdminRepositoryImpl(){
        session= SessionFactoryConfig.getInstance().getSession();
    }
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
    public Long save(Admin entity) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean update(Admin entity) {
        return false;
    }

    @Override
    public void setSession(Session session) {

    }
}
