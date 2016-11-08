package com.neu.msd.dao.impl;

import java.util.Comparator;

import com.neu.msd.entities.ActivityContainer;


public class SortBycontainer implements Comparator<ActivityContainer> {
	public int compare( ActivityContainer tf1,  ActivityContainer tf2) {
		// TODO Auto-generated method stub
		return (int)(tf1.getOrderNo()-tf2.getOrderNo());
	}

}
