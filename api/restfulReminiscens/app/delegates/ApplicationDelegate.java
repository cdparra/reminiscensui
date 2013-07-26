package delegates;

import java.util.ArrayList;
import java.util.List;

import pojos.CityBean;
import pojos.QuestionBean;
import utils.PlayDozerMapper;

public class ApplicationDelegate {

	public static ApplicationDelegate getInstance() {
		return new ApplicationDelegate();
	}

	public List<CityBean> getCities () {
		List<models.City> modelCities = models.City.all();
		List<CityBean> pojosCities = new ArrayList<CityBean>();
		for (models.City city : modelCities) {
			CityBean cityBean = PlayDozerMapper.getInstance().map(
					city, CityBean.class);
			pojosCities.add(cityBean);
		}
		return pojosCities;
	}
	
	public List<CityBean> getCitiesByCountryId(Long countryId) {
		List<models.City> modelCities = models.City.readByCountry(countryId);
		List<CityBean> pojosCities = new ArrayList<CityBean>();
		for (models.City city : modelCities) {
			CityBean cityBean = PlayDozerMapper.getInstance().map(
					city, CityBean.class);
			pojosCities.add(cityBean);
		}
		return pojosCities;
	}

	public List<CityBean> getCitiesByCountryName(String countryName) {
		List<models.City> modelCities = models.City.readByCountryName(countryName);
		List<CityBean> pojosCities = new ArrayList<CityBean>();
		for (models.City city : modelCities) {
			CityBean cityBean = PlayDozerMapper.getInstance().map(
					city, CityBean.class);
			pojosCities.add(cityBean);
		}
		return pojosCities;
	}
	
	public List<CityBean> getNewCities (Long lastCityId) {
		List<models.City> modelCities = models.City.readNewById(lastCityId);
		List<CityBean> pojosCities = new ArrayList<CityBean>();
		for (models.City city : modelCities) {
			CityBean cityBean = PlayDozerMapper.getInstance().map(
					city, CityBean.class);
			pojosCities.add(cityBean);
		}
		return pojosCities;
	}
	
	public List<CityBean> getCityByName (String cityName) {
		List<models.City> modelCities = models.City.findByName(cityName);
		List<CityBean> pojosCities = new ArrayList<CityBean>();
		for (models.City city : modelCities) {
			CityBean cityBean = PlayDozerMapper.getInstance().map(
					city, CityBean.class);
			pojosCities.add(cityBean);
		}
		return pojosCities;
	}
	
	
}
