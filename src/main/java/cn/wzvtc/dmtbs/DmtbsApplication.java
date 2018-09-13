package cn.wzvtc.dmtbs;

import cn.wzvtc.dmtbs.repository.PersistRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = PersistRepositoryImpl.class)
public class DmtbsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DmtbsApplication.class, args);
    }
}
