package com.douby.javaspi;

import java.util.ServiceLoader;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        ServiceLoader<Driver> serviceLoader = ServiceLoader.load(Driver.class);

        for (Driver driver : serviceLoader){
            System.out.println(driver.connection());
        }
    }
}
