package com.usama.junit_demo;

import java.time.Duration;
import java.time.LocalTime;
import java.time.Period;
import java.util.Collection;
import java.util.Collections;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        LocalTime time1 = LocalTime.now();
        Duration duration = Duration.ofHours(5);
        System.out.println(time1.plus(duration));
        
    }
}
