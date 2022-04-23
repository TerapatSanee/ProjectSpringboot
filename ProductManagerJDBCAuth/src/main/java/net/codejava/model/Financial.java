package net.codejava.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Financial {
	
	private Long fi_id;
	private float total_price;
	
	public Financial() {
	}

	public Financial(Long fi_id, float total_price) {
		this.fi_id = fi_id;
		this.total_price = total_price;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getFi_id() {
		return fi_id;
	}

	public void setFi_id(Long fi_id) {
		this.fi_id = fi_id;
	}

	public float getTotal_price() {
		return total_price;
	}

	public void setTotal_price(float total_price) {
		this.total_price = total_price;
	}
	
	
}
