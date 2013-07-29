update Location set accuracy = 1
where accuracy is null
	and city_id is null 
	and lat is null
	and lon is null
	and city is null 
	and country is null
	and continent is null
	and location_textual is not null;


update Location set accuracy = 2
where accuracy is null
	and city_id is null 
	and lat is null
	and lon is null
	and city is null 
	and country is null
	and continent is not null;


update Location set accuracy = 3
where accuracy is null
	and city_id is null 
	and lat is null
	and lon is null
	and city is null 
	and country is not null
	and continent is null
	and environment is null;



update Location set accuracy = 4
where accuracy is null
	and city_id is null 
	and lat is null
	and lon is null
	and city is null 
	and country is not null
	and continent is null
	and environment is not null;

update Location set accuracy = 5
where accuracy is null
	and city_id is null 
	and lat is null
	and lon is null
	and city is not null 
	and country is not null
	and continent is null
	and environment is null;

update Location set accuracy = 5
where accuracy is null
	and city_id is null 
	and lat is null
	and lon is null
	and city is null 
	and country is not null
	and continent is null
	and environment is null
	and neighborhood is not null;

update Location set accuracy = 6
where accuracy is null
	and city_id is null 
	and lat is null
	and lon is null
	and city is null 
	and country is null
	and continent is null
	and environment is null
	and neighborhood is null
	and region is not null;


update Location set accuracy = 7
where accuracy is null
	and city_id is null 
	and lat is null
	and lon is null
	and city is null 
	and country is null
	and continent is null
	and environment is not null
	and neighborhood is null
	and region is not null;


update Location set accuracy = 11
where accuracy is null
	and (city_id is not null 
	or city is not null);


update Location set accuracy = 12
where accuracy is null
	and city_id is null 
	and lat is null
	and lon is null
	and city is not null 
	and country is not null
	and continent is null
	and environment is null
	and neighborhood is not null
	and region is null;


update Location set accuracy = 19
where accuracy is null
	and lat is not null
	and lon is not null
	and coordinates_trust = 0;


update Location set accuracy = 20
where accuracy is null
	and lat is not null
	and lon is not null
	and (coordinates_trust = 1 or coordinates_trust is null);
