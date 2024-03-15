package lk.penguin.service;

import lk.penguin.service.custom.impl.*;

public class ServiceFactory {
    private static ServiceFactory serviceFactory;
    private ServiceFactory(){}

    public static ServiceFactory getServiceFactory() {
        return serviceFactory==null
                ?serviceFactory=new ServiceFactory()
                :serviceFactory;
    }
    public enum ServiceType{
        WELCOME,BOOKS,MEMBER,BRANCH,PANE1,CREATESIGNUP
    }

    public SuperService getService(ServiceType serviceType){
        switch (serviceType) {
            case WELCOME :
                return new WelcomeServiceImpl();
            case BOOKS:
                return new BookManageServiceImpl();
            case MEMBER:
                return new MemberServiceImpl();
            case BRANCH:
                return new BranchServiceImpl();
            case PANE1:
                return new Pane1ServiceImpl();
            case CREATESIGNUP:
                return new CreateSignUpServiceImpl();
            default:
                return null;
        }
    }
}
