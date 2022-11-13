//package TrelloClone.db;
//import TrelloClone.model.Task;
//import TrelloClone.repo.TaskRepository;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.sql.Timestamp;
//
//@Configuration
//class LoadDatabase {
//
//    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
//
//    @Bean
//    CommandLineRunner initDatabase(TaskRepository repository) {
//
//        return args -> {
//            log.info("Preloading " + repository.save(new Task("Todo", "", "", "", new Timestamp(System.currentTimeMillis()))));
//        };
//    }
//}
