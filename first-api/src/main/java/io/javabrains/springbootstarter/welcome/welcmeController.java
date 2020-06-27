package io.javabrains.springbootstarter.welcome;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class welcmeController {
	
	@RequestMapping("/welcome")
	public String welcome()
	{
		return "welcome";
	}

}
