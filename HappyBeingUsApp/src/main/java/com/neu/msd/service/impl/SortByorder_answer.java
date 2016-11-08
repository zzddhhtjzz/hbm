package com.neu.msd.service.impl;

import java.util.Comparator;

import com.neu.msd.entities.AdminActivityAnswer;
import com.neu.msd.entities.Answer;

public class SortByorder_answer implements Comparator<Answer> {
	public int compare(Answer tf1, Answer tf2) {
		// TODO Auto-generated method stub
		return (int)(tf1.getOrderNo()-tf2.getOrderNo());
	}

}
