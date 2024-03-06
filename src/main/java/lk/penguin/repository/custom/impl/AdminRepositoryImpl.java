package lk.penguin.repository.custom.impl;

import lk.penguin.entity.Admin;
import lk.penguin.repository.custom.AdminRepository;
import lk.penguin.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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
            Admin admin= (Admin) session.createQuery("FROM admin WHERE admin_loginId = :adminLoginID")
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
}
