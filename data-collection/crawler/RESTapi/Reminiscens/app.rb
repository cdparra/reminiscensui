require 'flickraw'
require 'active_record'
require 'active_support/core_ext'
load 'db/models/media.rb'
load 'db/models/location.rb'
load 'db/models/fuzzy_date.rb'
load 'config/settings.rb'

flickrTag = "Trento"

def getGoogleGeoData(location)
end

def getFlickrGeoData(location,id)
	data = flickr.photos.geo.getLocation :photo_id => id

		location.name = data.location.locality
		location.city=data.location.county
		location.region = data.location.region
		location.country = data.location.country
	
end

def createPicture(data) 
	info = flickr.photos.getInfo :photo_id => data.id  

	photo = Media.new do |p|
		p.caption = info.title.gsub("'","\\\\'")
		p.media_url = "http://farm#{data.farm}.static.flickr.com/#{data.server}/#{data.id}_#{data.secret}_z.jpg"
		p.media_type = "photo"
		p.source = "flickr"
		p.source_url = info.urls[0]
		p.is_public = 1
		p.locale = "ita"
		p.build_fuzzyDate(:exact_date => info.dates.taken)
		if data.accuracy!=0
			p.build_location(:location_textual => :flickrTag, :lat => data.latitude, :lon => data.longitude, :accuracy => data.accuracy)
			#chiamo api flickr per beccarmi i dati specifici
			puts "FLICKR GEO per foto con id '#{data.id}'"
			getFlickrGeoData(p.location,data.id)
		else
			p.build_location(:location_textual => :flickrTag, :accuracy => 2)
			#chiamo google maps per sapere qualcosa dal tag
			puts "GOOGLE MAPS per foto con id '#{data.id}'"
			#getGoogleGeoData(p, #ciao)
		end
	end
	return photo
end


FlickRaw.api_key="b70a9e175b81d1e4cd19fd652f0af12a"
FlickRaw.shared_secret="77b1f598e7f67191"

list   = flickr.photos.search :tags => :flickrTag, :license => "1%2C2%2C4%2C5%2C7", :min_taken_date => "1900-01-01",
                              :max_taken_date => "2010-12-12"

count=1

list.each do |i|
		puts "siamo in #{list.inspect}"          
		photo = createPicture(i)
		puts count
		count=count+1
end
