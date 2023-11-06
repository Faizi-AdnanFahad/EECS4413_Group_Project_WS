//package projectPackage;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//class LoadDatabase {
//
//	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
//
//	@Bean
//	CommandLineRunner initDatabase(ItemRepository itemRepository) {
//
//		return args -> {
//			itemRepository.save(new Item("Toyota", "Used Vehicle", "Corolla", 23, 10000, 120000, 3));
//
//			itemRepository.findAll().forEach(employee -> log.info("Preloaded " + employee));
//
//
//		};
//	}
//}