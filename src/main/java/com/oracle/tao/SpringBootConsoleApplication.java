package com.oracle.tao;



import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//public class SpringBootConsoleApplication implements CommandLineRunner {
public class SpringBootConsoleApplication{


    public static void main(String[] args) throws Exception {

        //启动方式1
//        SpringApplication app = new SpringApplication(SpringBootConsoleApplication.class);
//
//        app.setWebApplicationType(WebApplicationType.NONE);
//        app.setBannerMode(Banner.Mode.OFF);
//        app.run(args);

         //启动方式2
        SpringApplication.run(SpringBootConsoleApplication.class, args);

    }


//    @Override
//    public void run(String... args) throws Exception {
//        System.out.println("test");
//
//     //   test.send();
//
////        while (true){
////
////        }
//    }
}
