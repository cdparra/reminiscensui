select p.firstname, p.lastname, le.headline, fd.exact_date, l.location_textual, l.*, fd.* 
from Person p, Participant pa, Life_Event le, Location l, Fuzzy_Date fd
where 
	p.person_id=pa.person_id
	and pa.life_event_id = le.life_event_id
	and pa.focus = true
	and le.fuzzy_startdate = fd.fuzzy_date_id
	and le.location_id = l.location_id