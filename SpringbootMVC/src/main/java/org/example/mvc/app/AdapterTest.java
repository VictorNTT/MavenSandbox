package org.example.mvc.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class AdapterTest implements CommandLineRunner {
    @Autowired
    private ConfigManager configManager;
    @Override
    public void run(String... args) throws Exception {
        System.out.println("ApdapterTest.run()");
        System.out.println("ApdapterTest.run() appConfig " + configManager.appConfig());
        System.out.println("ApdapterTest.run() mailConfig " + configManager.mailConfig());
        System.out.println("ApdapterTest.run() item " + configManager.item());
    }
}
