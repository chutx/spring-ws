package com.training.architecture.java.springwebapp;

import org.junit.Test;

public class ClassOneTest {

	@Test
	public void test(){
		
		int[] scores = new int[]{100, 1, 100, 100};
		
		boolean result = false;

		for(int i=0; i< scores.length && result == false; i++){
		  if(scores[i] == 100 && (i+1) < scores.length && scores[i+1] == 100){
		      result = true;
		  }
		}

	}
}
