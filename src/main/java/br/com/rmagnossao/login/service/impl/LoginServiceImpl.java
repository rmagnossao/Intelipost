package br.com.rmagnossao.login.service.impl;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.skife.jdbi.v2.DBI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import br.com.rmagnossao.login.model.Info;
import br.com.rmagnossao.login.repository.InfoRepository;
import br.com.rmagnossao.login.repository.LoginRepository;
import br.com.rmagnossao.login.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{

    
	@Autowired
	DBI dbi;
    
	@Async
	public CompletableFuture<List<Info>> getUserInfo(String user, String pass) throws InterruptedException {
		
		 InfoRepository intoRepository   = dbi.onDemand(InfoRepository.class);
		 LoginRepository loginRepository = dbi.onDemand(LoginRepository.class);
				
		 int id = loginRepository.getInfo(user, pass);
	     List<Info> li =  intoRepository.getInfo(id);
				
		 //Thread.sleep(1000L);
		 //System.out.println(Thread.currentThread());
		 return CompletableFuture.completedFuture(li);
		
	}

}
