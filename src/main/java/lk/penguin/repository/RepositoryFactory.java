package lk.penguin.repository;

import lk.penguin.repository.custom.impl.*;
import org.apache.commons.beanutils.PropertyUtilsBean;

public class RepositoryFactory {
    public static RepositoryFactory repositoryFactory;
    private RepositoryFactory(){}

    public static RepositoryFactory getRepositoryFactory() {
        return repositoryFactory==null
                ?repositoryFactory=new RepositoryFactory()
                :repositoryFactory;
    }
    public enum RepositoryType{
        ADMIN,USER,BOOKS,BRANCH,TRANSACTION
    }
    public SuperRepository getRepository(RepositoryType repositoryType){
        switch (repositoryType){
            case ADMIN:
                return new AdminRepositoryImpl();
            case USER:
                return new UserRepositoryImpl();
            case BOOKS:
                return new BooksRepositoryImpl();
            case BRANCH:
                return new BranchRepositoryImpl();
            case TRANSACTION:
                return new TransactionRepositoryImpl();
            default:
                return null;
        }
    }
}
