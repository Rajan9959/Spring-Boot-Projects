package com.music.playMe;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class PlaymeApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(PlaymeApplication.class, args);
		System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
	}
}
