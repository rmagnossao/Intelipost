package br.com.rmagnossao.login.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.rmagnossao.login.model.Info;
import br.com.rmagnossao.login.service.LoginService;
import lombok.extern.slf4j.Slf4j;;

@RestController
@Slf4j
public class LoginController {
	
	@Autowired
	LoginService userService;
	
	@RequestMapping("/login")
	@ResponseBody
	
	public CompletableFuture<List<Info>> appenderRequest (@RequestParam String user, 
									   @RequestParam String pass) throws InterruptedException, ExecutionException {
		
   
		long start = System.currentTimeMillis();
		CompletableFuture<List<Info>> call1 = userService.getUserInfo(user,pass);
		//CompletableFuture<List<Info>> call2 = userService.getUserInfo(user,pass);
		//CompletableFuture<List<Info>> call3 = userService.getUserInfo(user,pass);
		//CompletableFuture.allOf(call1,call2,call3).join();
		 // Print results, including elapsed time
        log.info("Elapsed time: " + (System.currentTimeMillis() - start));
        log.info("--> " + call1.get().toString());
        //log.info("--> " + call2.get());
        //log.info("--> " + call3.get());
		return call1;
		
		
	}
	
	@RequestMapping("/teste")
	@ResponseBody
	
	public String getTeste() {
		return "Aplicação Ok";
	}
	
	

}
