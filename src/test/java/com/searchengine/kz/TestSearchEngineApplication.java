package com.searchengine.kz;

import org.springframework.boot.SpringApplication;

public class TestSearchEngineApplication {

	public static void main(String[] args) {
		SpringApplication.from(SearchEngineApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
