package br.com.rmagnossao.login.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import br.com.rmagnossao.login.model.Info;

public interface LoginService {
	
	CompletableFuture<List<Info>> getUserInfo(String user, String pass) throws InterruptedException;


}
