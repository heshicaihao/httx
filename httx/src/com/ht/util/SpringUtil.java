package com.ht.util;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * This utility class for Spring must be set as singleton in Spring IoC container so that
 * it can have Spring's ApplicationContext.
 * 
 * @author joezeng
 * @version 1.0
 */

public class SpringUtil implements ApplicationContextAware, ApplicationListener<ApplicationEvent>{
    private static ApplicationContext ctx;
    private static boolean isSpringInitialized = false;
    
    private SpringUtil(){
    }
	
	/**
	 * get Bean from this class's ApplicationContext
     * 
	 * @param beanName
	 * @return bean
	 */
	public static Object getBean(String beanName) {
		return getApplicationContext().getBean(beanName);
	}
    
	public static <X> X getBean(Class<X> type){
		return getApplicationContext().getBean(type);
	}
	
	
    /**
     * Get bean from WebApplicationContext which is get from ServletContext.
     * @param beanName
     * @param sc
     * @return
     */
    public static Object getBean(String beanName, ServletContext sc) {
        ApplicationContext context = 
            WebApplicationContextUtils.getWebApplicationContext(sc);
        return context.getBean(beanName);
    }
    
    /**
     * 
     * setApplicationContext
     * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
     */
    public void setApplicationContext(ApplicationContext _ctx){
        ctx = _ctx;
    }
    
    /**
     * After Spring IoC initialized, set isSpringInitialized as true.
     * 
     * onApplicationEvent
     * @see org.springframework.context.ApplicationListener#onApplicationEvent(org.springframework.context.ApplicationEvent)
     */
    public void onApplicationEvent(ApplicationEvent event){
        if(event instanceof ContextRefreshedEvent){
            isSpringInitialized = true;
        }
    }
    /**
     * If Spring has not been initialized, a IllegalStateException will be thrown out.
     * 
     * @return Spring's ApplicationContext
     */
    public static ApplicationContext getApplicationContext(){
        if(!isSpringInitialized || null == ctx){
            throw new IllegalStateException("Spring has not been initialized!");
        }
        return ctx;
    }
}