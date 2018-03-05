package com.sync.pb.domain;


import org.springframework.util.Assert;

/**
 * A Place Name like a city or a town.
 *
 */
public final class PlaceOfInterest {

	private String place;

	public PlaceOfInterest(String place) {
		Assert.notNull(place, "place must not be null");		
		Assert.isTrue(place.trim().length() > 0, "place must not be blank");
		this.place = place;
	}

	@Override
	public int hashCode() {
		return this.place.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null || obj.getClass() != getClass()) {
			return false;
		}
		return this.place.equals(((PlaceOfInterest) obj).place);
	}

	@Override
	public String toString() {
		return this.place;
	}

}