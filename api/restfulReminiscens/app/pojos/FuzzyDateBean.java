package pojos;

import java.io.Serializable;
import java.text.ParseException;

import org.joda.time.DateTime;
import utils.JodaDateTime;

public class FuzzyDateBean implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 7304578497268955428L;
	
	private Long fuzzyDateId;
	private String textual_date;
	
	@JodaDateTime(format = "yyyy-MM-dd HH:mm:ss")
	private DateTime exactDate;
	
	private Long decade;
	private Long year;
	private String month;
	private String day;
	private Long accuracy;
	private String locale;	

//	Fields in Database not exposed in this API
//	private String season;
//	private String day_name;
//	private String day_part;
//	private String hour;
//	private String minute;
//	private String second;

	/**
	 * @return the fuzzyDateId
	 */
	public Long getFuzzyDateId() {
		return fuzzyDateId;
	}

	/**
	 * @param fuzzyDateId the fuzzyDateId to set
	 */
	public void setFuzzyDateId(Long fuzzyDateId) {
		this.fuzzyDateId = fuzzyDateId;
	}

	/**
	 * @return the textual_date
	 */
	public String getTextual_date() {
		return textual_date;
	}

	/**
	 * @param textual_date the textual_date to set
	 */
	public void setTextual_date(String textual_date) {
		this.textual_date = textual_date;
	}

	/**
	 * @return the exact_date
	 */
	public DateTime getExactDate() {
		return exactDate;
	}
	
	public String getExactDateAsString () {
		return exactDate == null ? null : exactDate.toString("yyyy-MM-dd HH:mm:ss");
	}
	
	/**
	 * @param exact_date the exact_date to set
	 * @throws ParseException 
	 */
	public void setExactDate(DateTime exact_date) throws ParseException {
		this.exactDate = exact_date;
	}

	/**
	 * @return the decade
	 */
	public Long getDecade() {
		return decade;
	}

	/**
	 * @param decade the decade to set
	 */
	public void setDecade(Long decade) {
		this.decade = decade;
	}

	/**
	 * @return the year
	 */
	public Long getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(Long year) {
		this.year = year;
	}

//	/**
//	 * @return the season
//	 */
//	public String getSeason() {
//		return season;
//	}
//
//	/**
//	 * @param season the season to set
//	 */
//	public void setSeason(String season) {
//		this.season = season;
//	}

	/**
	 * @return the month
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * @param month the month to set
	 */
	public void setMonth(String month) {
		this.month = month;
	}

	/**
	 * @return the day
	 */
	public String getDay() {
		return day;
	}

	/**
	 * @param day the day to set
	 */
	public void setDay(String day) {
		this.day = day;
	}

//	/**
//	 * @return the day_name
//	 */
//	public String getDay_name() {
//		return day_name;
//	}
//
//	/**
//	 * @param day_name the day_name to set
//	 */
//	public void setDay_name(String day_name) {
//		this.day_name = day_name;
//	}
//
//	/**
//	 * @return the day_part
//	 */
//	public String getDay_part() {
//		return day_part;
//	}
//
//	/**
//	 * @param day_part the day_part to set
//	 */
//	public void setDay_part(String day_part) {
//		this.day_part = day_part;
//	}
//
//	/**
//	 * @return the hour
//	 */
//	public String getHour() {
//		return hour;
//	}
//
//	/**
//	 * @param hour the hour to set
//	 */
//	public void setHour(String hour) {
//		this.hour = hour;
//	}
//
//	/**
//	 * @return the minute
//	 */
//	public String getMinute() {
//		return minute;
//	}
//
//	/**
//	 * @param minute the minute to set
//	 */
//	public void setMinute(String minute) {
//		this.minute = minute;
//	}
//
//	/**
//	 * @return the second
//	 */
//	public String getSecond() {
//		return second;
//	}
//
//	/**
//	 * @param second the second to set
//	 */
//	public void setSecond(String second) {
//		this.second = second;
//	}

	/**
	 * @return the accuracy
	 */
	public Long getAccuracy() {
		return accuracy;
	}

	/**
	 * @param accuracy the accuracy to set
	 */
	public void setAccuracy(Long accuracy) {
		this.accuracy = accuracy;
	}

	/**
	 * @return the locale
	 */
	public String getLocale() {
		return locale;
	}

	/**
	 * @param locale the locale to set
	 */
	public void setLocale(String locale) {
		this.locale = locale;
	}


}
