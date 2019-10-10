package com.ex.training.algs;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ex.training.algs.quickfind.QuickFindUF;
import com.ex.training.algs.quickfind.QuickUnionUF;
import com.ex.training.algs.quickfind.UnionFind;

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
			runUnionFind(scanner, buildAlgorithm(scanner, AlgorithmName.QUICK_FIND));
			break;

		case QUICK_UNION:
			runUnionFind(scanner, buildAlgorithm(scanner, AlgorithmName.QUICK_UNION));
			break;
		default:
			break;
		}

		scanner.close();

	}

	private UnionFind buildAlgorithm(Scanner scanner, AlgorithmName algorithmName) {
		log.info("Size: ");

		int n = scanner.nextInt();
		UnionFind unionFind = null;
		switch (algorithmName) {
		case QUICK_FIND:
			unionFind = new QuickFindUF(n);
			break;

		case QUICK_UNION:
			unionFind = new QuickUnionUF(n);
			break;
		default:
			log.info("Unsupported operation");
			break;
		}

		log.info("Array created {}", unionFind);
		return unionFind;
	}

	private void runUnionFind(Scanner scanner, UnionFind unionFind) {
		if (null != unionFind) {
			String line = "";
			while (!line.equalsIgnoreCase("q")) {
				log.info("Nodes to join?");
				int p = scanner.nextInt();
				int q = scanner.nextInt();

				if (unionFind.connected(p, q)) {
					log.info("{} and {} Already connected!!!", p, q);
					continue;
				}
				unionFind.union(p, q);
				log.info("p {} q {}", p, q);
				log.info("Union {}", unionFind.toString());
				log.info("To continue press C otherwise Q");
				line = scanner.next();
			}
			log.info("Union {}", unionFind.toString());
		}
	}

}
