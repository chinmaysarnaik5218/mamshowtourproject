package com.fis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fis.db.Tourdata;
import com.fis.entity.Tour;

import java.util.List;
@Component
public class Tourservice {
	@Autowired
	Tourdata tourdata;
	private static final int GST = 12;
	
	public Tour get(String tourid) {
		return tourdata.findById(tourid).orElseThrow(()-> new RuntimeException("no tour with"+ tourid));
	}

	public Tour create(Tour tour) {
		return tourdata.save(tour);
		
	}
	
	
	public double calculate(String packid, int nosdays) {
		Tour tour = get(packid);
		double packagefare = tour.getFare() * nosdays;

		double discountfare = packagefare - (packagefare * getDiscount(nosdays) / 100);

		double totalcost = discountfare + (discountfare * GST / 100);

		return totalcost;
	}

	public int getDiscount(int nosdays) {
		int discount = 0;
		if (nosdays > 5 && nosdays <= 8) {
			discount = 3;
		} else if (nosdays > 8 && nosdays <= 10) {
			discount = 5;
		} else if (nosdays > 10) {
			discount = 7;
		}
		return discount;
	}

	public List<Tour> getAll() {
		return tourdata.findAll();
	}

}
