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






