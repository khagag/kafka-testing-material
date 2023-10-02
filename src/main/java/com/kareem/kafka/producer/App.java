package com.kareem.kafka.producer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // System.out.println( "Hello World!" );
        KProducer KP = new KProducer();
        KP.sendMessage("Hello World!");
    }
}
