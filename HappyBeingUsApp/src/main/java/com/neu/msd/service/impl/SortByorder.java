package com.neu.msd.service.impl;

import java.util.Comparator;

import com.neu.msd.entities.AdminActivityAnswer;

public class SortByorder implements Comparator<AdminActivityAnswer> {
	public int compare(AdminActivityAnswer tf1, AdminActivityAnswer tf2) {
		// TODO Auto-generated method stub
		return (int)(tf1.getActivity().getOrderNo()-tf2.getActivity().getOrderNo());
	}

}
