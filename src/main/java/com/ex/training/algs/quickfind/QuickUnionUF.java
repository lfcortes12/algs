package com.ex.training.algs.quickfind;

import java.util.Arrays;

public class QuickUnionUF implements UnionFind {

	private int[] parent;

	public QuickUnionUF(int size) {
		parent = new int[size];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
	}

	public int root(int i) {
		while (i != parent[i]) {
			parent[i] = i;
		}
		return i;
	}

	public int find(int p) {
		while (p != parent[p])
			p = parent[p];
		return p;
	}

	@Override
	public boolean connected(int p, int q) {
		return parent[p] == parent[q];
	}

	@Override
	public void union(int p, int q) {
		int pValue = root(p);
		int qValue = root(q);

		parent[pValue] = qValue;
	}

	public String toString() {
		return Arrays.toString(parent);
	}

}
