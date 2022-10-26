package TrelloClone.db;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

//    @Bean
//    CommandLineRunner initDatabase(TaskRepository repository) {
//
//        return args -> {
//            log.info("Preloading " + repository.save(new Task("Todo", "", "", "", new Timestamp(System.currentTimeMillis()))));
//        };
//    }
}
