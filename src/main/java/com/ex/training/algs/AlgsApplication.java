package com.ex.training.algs;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ex.training.algs.quickfind.QuickFindUF;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class AlgsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		
		SpringApplication.run(AlgsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var scanner = new Scanner(System.in);
		log.info("Size: ");
		int n = scanner.nextInt();
		final QuickFindUF quickFindUF = new QuickFindUF(n);
		log.info("Array created {}", quickFindUF.toString());
		while(scanner.hasNext()) {
			int p = scanner.nextInt();
			int q = scanner.nextInt();
			
			if (quickFindUF.connected(p, q)) continue;
			quickFindUF.union(p, q);
            log.info("p {} q {}", p, q);
		}
		
		
		quickFindUF.union(2, 3);
		log.info("Union {}", quickFindUF.toString());
		scanner.close();
		
	}

}
