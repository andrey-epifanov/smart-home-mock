package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication

public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String args[]) throws InterruptedException {
		SpringApplication.run(Application.class);
		Counter counter = new Counter();
		RestTemplate restTemplate = new RestTemplate();
		try{
			String quote = restTemplate.getForObject(
					"http://httpbin.org/get", String.class);
			log.info(quote.toString());}
		catch (Exception e){
			System.out.println("No data");
		}
		try{
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		String data = "Some data";
		HttpEntity<String> entity = new HttpEntity<String>(counter.toString() ,headers);
		String answer = restTemplate.postForObject("http://httpbin.org/get", data, String.class);
			System.out.println(answer);}
		catch (Exception e){
			e.printStackTrace();
		}

//
//		int a = 0;
//		while (true){
//			SpringApplication.run(Application.class);
//			Thread.sleep(5000);
//			a++;
//			if (a ==4) break;
//		}
	}
	
//	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

//	@Bean
//	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
//		return args -> {
////			Counter quote = restTemplate.getForObject(
////					"http://77.244.213.173:8080/smart-home", Counter.class);
//			try{
//			Counter quote = restTemplate.getForObject(
//					"http://httpbin.org/get", Counter.class);
//			log.info(quote.toString());}
//			catch (Exception e){
//				System.out.println("No data");
//			}
//		};
//	}
////	@Bean
//	public String post(Counter counter) throws Exception{
//		RestTemplate restTemplate = new RestTemplate();
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON);
//
//		HttpEntity<String> entity = new HttpEntity<String>(counter.toString(),headers);
//		String answer = restTemplate.postForObject("http://httpbin.org/get", entity, String.class);
//		System.out.println(answer);
//		return answer;
//	}
}