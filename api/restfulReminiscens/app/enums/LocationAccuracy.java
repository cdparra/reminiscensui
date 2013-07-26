package enums;
/**
 * 	1, flickr world-level, if we only have textual description (e.g. it was nearby my hometown)
	2, if we have only continent or environment (e.g. it was in a beach, it was in africa)
	3, flickr country-level, if we have country or city or neighbourhood
	4, if it is 3 + environment 
	5, if we have country + city or neighbourhood
	6, flickr region-level, if we have country + region
	7, if we have 6 + environment
	11, flickr city-level, if we have country + city 
	12, if we have country + city + neighbourhood
	16, flickr street-level, if we have 11 or 12 + street
	17, if we have 7 + environment
	19,  if we have Lat + Lon but coordinates_trust = false
	20, the best, if we have both Lat + Longitude and coordinates_trust = true
 * @author cristhian
 *
 */
public enum LocationAccuracy {
    WORLD, 
    CONTINENT, 
    COUNTRY, 
    COUNTRY_ENVIRONMENT, 
    COUNTRY_CITYORNEIGHBORHOOD, 
    REGION, 
    REGION_ENVIRONMENT, 
    NO1, 
    NO2, 
    NO3,
    CITY,
    COUNTRY_CITY_NEIGHBORHOOD,
    STREET,
    NO4,
    NO5,
    STREET_CITYORCOUNTRY,
    REGION_ENVIRONMENT2,
    NO6,
    LATLON_APPROXIMATE,
    LATLON_EXACT
    
}
