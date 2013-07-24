UPDATE reminiscensdb.Context_Index ci, City cc, Famous_Person fp, Location fl, City fc 
	set ci.city_id = fc.city_id, ci.distance = 0
where ci.city_id = cc.city_id
	and ci.famous_id = fp.famous_id
	and fl.location_id = fp.birthplace_id
	and fl.location_textual = fc.city_name;

SELECT count(*)
FROM reminiscensdb.Context_Index ci, City cc, Famous_Person fp, Location fl, City fc
where ci.city_id = cc.city_id
	and ci.famous_id = fp.famous_id
	and fl.location_id = fp.birthplace_id
	and fl.location_textual = fc.city_name;


SELECT ci.decade,
	ci.year,
	cc.city_name,
	ci.distance,
	fp.fullname,
	fp.famous_for,
	fl.location_textual,
	fc.city_name
FROM reminiscensdb.Context_Index ci, City cc, Famous_Person fp, Location fl
	left outer join City fc on fl.location_textual = fc.city_name
where ci.city_id = cc.city_id
	and ci.famous_id = fp.famous_id
	and fl.location_id = fp.birthplace_id;