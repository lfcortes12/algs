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
		
		switch (AlgorithmName.valueOf(args[0])) {
		case QUICK_FIND:
			runQuickFind(scanner);
			break;
		default:
			break;
		}
		
		

	}

	private void runQuickFind(Scanner scanner) {
		log.info("Size: ");
		int n = scanner.nextInt();
		final QuickFindUF quickFindUF = new QuickFindUF(n);
		log.info("Array created {}", quickFindUF.toString());
		String line = "";
		while (!line.equalsIgnoreCase("q")) {
			log.info("Nodes to join?");
			int p = scanner.nextInt();
			int q = scanner.nextInt();

			if (quickFindUF.connected(p, q))
				continue;
			quickFindUF.union(p, q);
			log.info("p {} q {}", p, q);
			log.info("Union {}", quickFindUF.toString());
			log.info("To continue press C otherwise Q");
			line = scanner.next();
		}

		log.info("Union {}", quickFindUF.toString());
		scanner.close();
	}

}
