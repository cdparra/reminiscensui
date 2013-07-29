package enums;

import org.codehaus.jackson.annotate.JsonCreator;

/**
 * describes accuracy of the date from 1 to 10
	1, if we only have a textual description (e.g.it was around ten or 15 years ago,when i was on summer vacation)
	2, we have one of the following parts
	decade (e.g. it was int 80s)
	a season (e.g. it was summer)
	month (e.g. it was a july)
	day
	day_name (monday, tuesday, etc.
	day_part (afternoon, morning)
	3, we have decade combined with either of the following list
	season (e.g. it was a summer of the 80s)
	month
	4, we have the year
	5, if we have the year + season
	6, if we have year + month
	7, we have month+day
	8, if we have year + month + day
	9,  year + month + day + day_name
	10,year + month + day + day_name + day_part
	11, extac date and time
 * @author cristhian
 *
 */
public enum FuzzyDateAccuracy {
    NOTAVAILABLE,
	ONLYTEXTUAL, 
    ONEPART, 
    DECADEMONTHORSEASON, 
    YEAR, 
    YEARSEASON, 
    YEARMONTH, 
    MONTHDAY, 
    YEARMONTHDAY, 
    YEARMONTHDAYPARTNAME,
    EXACT
}