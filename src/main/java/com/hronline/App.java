package com.hronline;

import com.hronline.entity.CorpIndustry;
import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.massindexing.MassIndexer;
import org.hibernate.search.mapper.orm.session.SearchSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;

@SpringBootApplication
@ComponentScan("com.hronline.*")
public class App extends SpringBootServletInitializer implements CommandLineRunner {
    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(App.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            SearchSession searchSession = Search.session( entityManager );

            MassIndexer indexer = searchSession.massIndexer( CorpIndustry.class )
                    .threadsToLoadObjects( 7 );

            indexer.startAndWait();
        } finally {
            if (entityManager != null)
                entityManager.close();
        }
    }
}