package com.ex.training.algs.quickfind;

import java.util.Arrays;

public class QuickFindUF {
	
	private int[] id;

	public QuickFindUF(int size) {
		id = new int[size];
		for (int i = 0; i < id.length; i++) {
			id[i] = i;
		}
	}
	
	public boolean connected(int p, int q) {
		return id[p] == id[q];
	}
	
	public void union(int p, int q) {
		int pValue = id[p];
		int qValue = id[q];
		
		for (int i : id) {
			if(id[i] == pValue) {
				id[i] = qValue;
			}
		}
	}
	
	public String toString() {
		return Arrays.toString(id);
	}

}
