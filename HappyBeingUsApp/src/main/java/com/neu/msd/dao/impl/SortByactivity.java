package com.neu.msd.dao.impl;

import java.util.Comparator;

import com.neu.msd.entities.Activity;


public class SortByactivity implements Comparator<Activity> {
	public int compare( Activity tf1,  Activity tf2) {
		// TODO Auto-generated method stub
		return (int)(tf1.getOrderNo()-tf2.getOrderNo());
	}

}
