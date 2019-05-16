package com.example.componentbase;

import com.example.componentbase.empty_service.EmptyAccountService;
import com.example.componentbase.service.IAccountService;

/**
 * ServiceFactory
 * 接收组件中实现的，接口对象的注册，以及向外提供特定组件的接口实现。
 * Created by xwxwaa on 2019/5/9.
 */

public class ServiceFactory {

    private IAccountService iAccountService;

    /**
     * private
     * 禁止外部创建ServicceFactory对象
     */
    private ServiceFactory(){

    }

    /**
     * 通过静态内部类的方式，实现SerrviceFactory的单例。
     */
    private static class Inner{
        private static ServiceFactory serviceFactory = new ServiceFactory();
    }

    public static ServiceFactory getInstance(){
        return Inner.serviceFactory;
    }

    /**
     * 接收Login组件实现的Service实例
     * @param iAccountService
     */
    public void setiAccountService(IAccountService iAccountService){
        this.iAccountService = iAccountService;
    }

    /**
     * 返回Login组件的Service实例
     */
    public IAccountService getiAccountService(){
        if (iAccountService == null){
            // 返回空实现
            iAccountService = new EmptyAccountService();
        }
        return iAccountService;
    }
    
}
