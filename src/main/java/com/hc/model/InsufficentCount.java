package com.hc.model;

import java.io.Serializable;

public class InsufficentCount implements Serializable{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Integer dayId;
		private Integer firstCountDiff;
		private Integer secondCountDiff;
		private Integer thirdCountDiff;
		public Integer getDayId() {
			return dayId;
		}
		public void setDayId(Integer dayId) {
			this.dayId = dayId;
		}
		public Integer getFirstCountDiff() {
			return firstCountDiff;
		}
		public void setFirstCountDiff(Integer firstCountDiff) {
			this.firstCountDiff = firstCountDiff;
		}
		public Integer getSecondCountDiff() {
			return secondCountDiff;
		}
		public void setSecondCountDiff(Integer secondCountDiff) {
			this.secondCountDiff = secondCountDiff;
		}
		public Integer getThirdCountDiff() {
			return thirdCountDiff;
		}
		public void setThirdCountDiff(Integer thirdCountDiff) {
			this.thirdCountDiff = thirdCountDiff;
		}
		
		
	}
