package lk.penguin.repository;

import lk.penguin.repository.custom.impl.AdminRepositoryImpl;
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
        ADMIN
    }
    public SuperRepository getRepository(RepositoryType repositoryType){
        switch (repositoryType){
            case ADMIN:
                return new AdminRepositoryImpl();
            default:
                return null;
        }
    }
}
