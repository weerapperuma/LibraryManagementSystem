package lk.penguin.service.custom.impl;

import lk.penguin.dto.BranchDto;
import lk.penguin.entity.Branch;
import lk.penguin.repository.RepositoryFactory;
import lk.penguin.repository.custom.BranchRepository;
import lk.penguin.repository.custom.impl.BranchRepositoryImpl;
import lk.penguin.service.custom.BranchService;
import lk.penguin.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class BranchServiceImpl implements BranchService {
    private Session session;

    private final BranchRepository branchRepository= (BranchRepositoryImpl) RepositoryFactory.getRepositoryFactory().getRepository(RepositoryFactory.RepositoryType.BRANCH);
    @Override
    public int save(BranchDto branchDto) {
        session= SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            branchRepository.setSession(session);
            int id=branchRepository.save(branchDto.toEntity());
            transaction.commit();
            return id;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
            return -1;
        }
        finally {
            session.close();
        }
    }

    @Override
    public boolean update(BranchDto branchDto) {
        session= SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            branchRepository.setSession(session);
            branchRepository.update(branchDto.toEntity());
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
            return false;
        }
        finally {
            session.close();
        }
    }

    @Override
    public List<BranchDto> getAllBranches() {
        session=SessionFactoryConfig.getInstance().getSession();
        try {
            branchRepository.setSession(session);
            List<Branch>branches=branchRepository.getAll();
            List<BranchDto>branchDtos=new ArrayList<>();
            for(Branch branch:branches){
                branchDtos.add(branch.toDto());
            }
            return branchDtos;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            session.close();
        }
    }
    public BranchDto getBranchDetails(int id){
        session=SessionFactoryConfig.getInstance().getSession();
        try {
            branchRepository.setSession(session);
            Branch branch=branchRepository.get(id);
            return branch.toDto();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            session.close();
        }
    }

    @Override
    public boolean deleteBranch(int id) {

        BranchDto branchDetails = getBranchDetails(id);
        session=SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            branchRepository.setSession(session);
            branchRepository.delete(branchDetails.toEntity());
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
            return false;
        }finally {
            session.close();
        }
    }
}
