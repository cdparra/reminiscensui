-- Select all information about famous person
select fp.firstname, 
	fp.lastname, 
	fp.fullname, 
	bc.city_name, 
	bd.textual_date,
	bd.exact_date, 
	bd.decade, 
	bd.year, 
	bd.month,
	bd.day 
from Famous_Person fp, Fuzzy_Date bd, City bc
where fp.famous_id = 404 
	and fp.birthdate_fuzzy_id = bd.fuzzy_date_id 
	and fp.birthplace_id = bc.city_id;
	
	
	
-- Famous people indexed information
SELECT ci.decade,
	ci.year,
	cc.city_name,
	ci.distance,
	fp.fullname, 
	fc.city_name
FROM reminiscensdb.Context_Index ci, City cc, Famous_Person fp, City fc
where ci.city_id = cc.city_id
	and ci.famous_id = fp.famous_id
	and fc.city_id = fp.birthplace_id;
	
	
	
	
	---- public mementos
	
	SELECT 
	ci.context_index_id as 'public_memento',
	ci.decade,
	ci.year,
	cc.city_name,
	ci.distance,
	ci.category,
	if(fp.fullname is not null,fp.fullname,
		if(m.headline is not null, m.headline, 
			if(w.title is not null, w.title, e.headline))) as 'headline',

	if(fp.famous_for is not null,fp.famous_for,
		if(m.text is not null, m.text, 
			if(w.author is not null, w.author, e.text))) as 'text',

	if(fp.source is not null,fp.source,
		if(m.source is not null, m.source, 
			if(w.source is not null, w.source, e.source))) as 'source',
	if(fp.source_url is not null,fp.source_url,
		if(m.source_url is not null, m.source_url, 
			if(w.source_url is not null, w.source_url, e.source_url))) as 'source_url',

	if(fp.picture_url is not null,fp.picture_url,
		if(m.media_url is not null, m.media_url, 
			if(w.resource_url is not null, w.resource_url, e.resource_url))) as 'resource_url',
	fp.famous_id,
	m.media_id,
	w.work_id,
	e.event_id


FROM 
	Context_Index ci
	left outer join Famous_Person fp on fp.famous_id = ci.famous_id
	left outer join Media m on ci.media_id = m.media_id
	left outer join Works w on ci.work_id = w.work_id 
	left outer join Event e on ci.event_id = e.event_id
	join City cc on ci.city_id = cc.city_id
order by ci.decade asc, ci.distance asc;



-- full context for a person
SELECT 
	ci.context_index_id as 'public_memento',
	ci.decade,
	ci.year,
	cc.city_name,
	ci.distance,
	ci.category,
	if(fp.fullname is not null,fp.fullname,
		if(m.headline is not null, m.headline, 
			if(w.title is not null, w.title, e.headline))) as 'headline',

	if(fp.famous_for is not null,fp.famous_for,
		if(m.text is not null, m.text, 
			if(w.author is not null, w.author, e.text))) as 'text',

	if(fp.source is not null,fp.source,
		if(m.source is not null, m.source, 
			if(w.source is not null, w.source, e.source))) as 'source',
	if(fp.source_url is not null,fp.source_url,
		if(m.source_url is not null, m.source_url, 
			if(w.source_url is not null, w.source_url, e.source_url))) as 'source_url',

	if(fp.picture_url is not null,fp.picture_url,
		if(m.media_url is not null, m.media_url, 
			if(w.resource_url is not null, w.resource_url, e.resource_url))) as 'resource_url',
	fp.famous_id,
	m.media_id,
	w.work_id,
	e.event_id


FROM 
	Context_Index ci
	left outer join Famous_Person fp on fp.famous_id = ci.famous_id
	left outer join Media m on ci.media_id = m.media_id
	left outer join Works w on ci.work_id = w.work_id 
	left outer join Event e on ci.event_id = e.event_id
	join City cc on ci.city_id = cc.city_id
	join Person p
where p.person_id=4 and ci.year > YEAR(p.birthdate) AND ci.year < YEAR(p.deathdate) 
order by ci.distance asc;





---  indexing wongs

select 
	w.title,w.author,
	fd.textual_date, fd.exact_date, fd.decade,fd.year, 
	c.short_name
from Works w , Fuzzy_Date fd, Country c
where indexed = 0 
	and w.fuzzy_releasedate = fd.fuzzy_date_id
	and w.author_country_id = c.country_id;


insert into Context_Index (work_id,decade,year,distance,city_id,coordinates_trust,category)

select 
	w.work_id,
	fd.decade,
	fd.year,
	0,
	5906,
	1,
	'SONG'
from Works w , Fuzzy_Date fd, Country c
where indexed = 0 
	and w.fuzzy_releasedate = fd.fuzzy_date_id
	and w.author_country_id = c.country_id;


 