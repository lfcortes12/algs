package com.ex.training.algs.quickfind;

import java.util.Arrays;

public class QuickFindUF implements UnionFind {

	private int[] id;

	public QuickFindUF(int size) {
		id = new int[size];
		for (int i = 0; i < id.length; i++) {
			id[i] = i;
		}
	}

	@Override
	public boolean connected(int p, int q) {
		return id[p] == id[q];
	}

	@Override
	public void union(int p, int q) {
		int pValue = id[p];
		int qValue = id[q];

		for (int i = 0; i < id.length; i++) {
			if (id[i] == pValue) {
				id[i] = qValue;
			}
		}
	}

	public String toString() {
		return Arrays.toString(id);
	}

}
