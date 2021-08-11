package kodlamaio.hmrs;
import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class HmrsApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(HmrsApplication.class, args);

		Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
		"cloud_name", "glpdgn",
		"api_key", "248131818648481",
		"api_secret", "6BnZ9sJLf6Ew6aXmpa_DtCPSy00",
		"secure", true));
		
//		File file = new File("my_image.jpg");
//		Map uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
		
		//System.out.println(uploadResult.values());
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("kodlamaio.hmrs"))
				// .paths(PathSelectors.any())
				.build();
	}

}
