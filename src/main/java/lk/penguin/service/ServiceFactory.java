package lk.penguin.service;

import lk.penguin.service.custom.impl.BookManageServiceImpl;
import lk.penguin.service.custom.impl.WelcomeServiceImpl;

public class ServiceFactory {
    private static ServiceFactory serviceFactory;
    private ServiceFactory(){}

    public static ServiceFactory getServiceFactory() {
        return serviceFactory==null
                ?serviceFactory=new ServiceFactory()
                :serviceFactory;
    }
    public enum ServiceType{
        WELCOME,BOOKS
    }

    public SuperService getService(ServiceType serviceType){
        switch (serviceType) {
            case WELCOME :
                return new WelcomeServiceImpl();
            case BOOKS:
                return new BookManageServiceImpl();
            default:
                return null;
        }
    }
}
