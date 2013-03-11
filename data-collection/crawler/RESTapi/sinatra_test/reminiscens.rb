require 'rubygems'
require 'sinatra'
require 'rabl'
require 'sass'
require 'mysql2'
require 'active_record'
require 'active_support/core_ext'
require 'active_support/inflector'
require 'builder'
require 'geocoder'

load 'config/settings.rb'
load 'db/models/models.rb'

#Geocoder.configure(:timeout => 10000000) # da cambiare!!! (la vm fa schifo come velocita')

def getGoogleCoordinates(loc)
  @place=City.new
  s = Geocoder.search(:loc)
  @place.lat=s[0].latitude
  @place.lon=s[0].longitude
  return @place
end

ActiveRecord::Base.logger = Logger.new(STDOUT)

Rabl.register!

get '/' do
  @response = "Wrong request: you need to specify a method"
  content_type :json
  @response.to_json
end

#Media
get '/media' do

  if params[:min_date]!=nil && params[:min_date].match(/^(19|20)\d\d([-])(0[1-9]|1[012])\2(0[1-9]|[12][0-9]|3[01])$/) &&
  params[:max_date]!=nil && params[:max_date].match(/^(19|20)\d\d([-])(0[1-9]|1[012])\2(0[1-9]|[12][0-9]|3[01])$/) &&
  params[:min_date] <= params[:max_date]

    if params[:lat]!=nil && params[:lon]!=nil

      if params[:radius]!=nil
        @radius=params[:radius]
      else
        @radius=0
      end

      @media=Media.joins(:fuzzyDate, :location).where("is_public = 1 AND exact_date >= ? AND exact_date <= ?
        AND (6378.7*sqrt(POW((0.0174 * (lat - ?)),2) +
        POW((0.0174 * (lon - ?) * COS(?)),2))) <= ?",
        params[:min_date], params[:max_date], params[:lat], params[:lon], params[:lat], @radius)

    elsif params[:place]!=nil

      if params[:radius]!=nil
        @radius=params[:radius]
      else
        @radius=0
      end

      @place=City.find(:first, :conditions => ["city_name = ? ", params[:place]])

      if @place==nil
        @place=getGoogleCoordinates(params[:place])
      end

      @media=Media.joins(:fuzzyDate, :location).where("is_public = 1 AND exact_date >= ? AND exact_date <= ?
        AND (6378.7*sqrt(POW((0.0174 * (lat - ?)),2) +
        POW((0.0174 * (lon - ?) * COS(?)),2))) <= ?",
        params[:min_date], params[:max_date], @place.lat, @place.lon, @place.lat, @radius)

    else

      @media=Media.joins(:fuzzyDate).where("is_public = 1 AND exact_date >= ? AND exact_date <= ? ", params[:min_date], params[:max_date])

    end

  elsif params[:lat]!=nil && params[:lon]!=nil

    if params[:radius]!=nil
      @radius=params[:radius]
    else
      @radius=0
    end

    @media=Media.joins(:location).where("is_public = 1 AND (6378.7*sqrt(POW((0.0174 * (lat - ?)),2) +
      POW((0.0174 * (lon - ?) * COS(?)),2))) <= ?",
      params[:lat], params[:lon], params[:lat], @radius)

  elsif params[:place]!=nil

    if params[:radius]!=nil
      @radius=params[:radius]
    else
      @radius=0
    end

    @place=City.find(:first, :conditions => ["city_name = ? ", params[:place]])

    if @place==nil
      @place=getGoogleCoordinates(params[:place])
    end

    @media=Media.joins(:location).where("is_public = 1 AND (6378.7*sqrt(POW((0.0174 * (lat - ?)),2) +
      POW((0.0174 * (lon - ?) * COS(?)),2))) <= ?",
      @place.lat, @place.lon, @place.lat, @radius)

  else

    @media="Usage: parameters \"min_date\" and \"max_date\" should be in the form \"yyyy-mm-dd\"
      \n Warning: you need to specify at least one parameter!"

  end

  content_type :json
  @media.to_json

end

#Events

get '/events' do

  if params[:min_date]!=nil && params[:min_date].match(/^(19|20)\d\d([-])(0[1-9]|1[012])\2(0[1-9]|[12][0-9]|3[01])$/) &&
  params[:max_date]!=nil && params[:max_date].match(/^(19|20)\d\d([-])(0[1-9]|1[012])\2(0[1-9]|[12][0-9]|3[01])$/) &&
  params[:min_date] <= params[:max_date]

    if params[:lat]!=nil && params[:lon]!=nil

      if params[:radius]!=nil
        @radius=params[:radius]
      else
        @radius=0
      end

      @events=Event.joins(:fuzzyDate, :location).where("AND exact_date >= ? AND exact_date <= ?
        AND (6378.7*sqrt(POW((0.0174 * (lat - ?)),2) +
        POW((0.0174 * (lon - ?) * COS(?)),2))) <= ?",
        params[:min_date], paarms[:max_date], params[:lat], params[:lon], params[:lat], @radius)

    elsif params[:place]!=nil

      if params[:radius]!=nil
        @radius=params[:radius]
      else
        @radius=0
      end

      @place=City.find(:first, :conditions => ["city_name = ? ", params[:place]])

      if @place==nil
        @place=getGoogleCoordinates(params[:place])
      end

      @events=Event.joins(:fuzzyDate, :location).where("exact_date >= ? AND exact_date <= ?
        AND (6378.7*sqrt(POW((0.0174 * (lat - ?)),2) +
        POW((0.0174 * (lon - ?) * COS(?)),2))) <= ?",
        params[:min_date], params[:max_date], @place.lat, @place.lon, @place.lat, @radius)

    else

      @events=Event.joins(:fuzzyDate).where("exact_date >= ? AND exact_date <= ? ", params[:min_date], params[:max_date])

    end

  elsif params[:lat]!=nil && params[:lon]!=nil

    if params[:radius]!=nil
      @radius=params[:radius]
    else
      @radius=0
    end

    @events=Event.joins(:location).where("(6378.7*sqrt(POW((0.0174 * (lat - ?)),2) +
      POW((0.0174 * (lon - ?) * COS(?)),2))) <= ?",
      params[:lat], params[:lon], params[:lat], @radius)

  elsif params[:place]!=nil

    if params[:radius]!=nil
      @radius=params[:radius]
    else
      @radius=0
    end

    @place=City.find(:first, :conditions => ["city_name = ? ", params[:place]])

    if @place==nil
      @place=getGoogleCoordinates(params[:place])
    end

    @events=Event.joins(:location).where("(6378.7*sqrt(POW((0.0174 * (lat - ?)),2) +
      POW((0.0174 * (lon - ?) * COS(?)),2))) <= ?",
      @place.lat, @place.lon, @place.lat, @radius)

  else

    @events="Usage: parameters 'min_date' and 'max_date' should be should follow the pattern 'yyyy-mm-dd'
      \n Warning: you need to specify at least one parameter!"

  end

  content_type :json
  @events.to_json

end

#Works
get '/works' do

  if params[:min_date]!=nil && params[:min_date].match(/^(19|20)\d\d([-])(0[1-9]|1[012])\2(0[1-9]|[12][0-9]|3[01])$/) &&
  params[:max_date]!=nil && params[:max_date].match(/^(19|20)\d\d([-])(0[1-9]|1[012])\2(0[1-9]|[12][0-9]|3[01])$/) &&
  params[:min_date] <= params[:max_date]

    @mediaMDs=MediaMetadata.joins(:fuzzyDate).where("exact_date <= ?  AND exact_date >= ? ", params[:min_date], params[:max_date])
  else

    @mediaMDs="Usage: parameters \"min_date\" and \"max_date\" should be in the form \"yyyy-mm-dd\"
      \n Warning: you need to specify at least one parameter!"

  end

  content_type :json
  @mediaMDs.to_json

end

#People
get "/people" do
  if params[:type]!=nil
    if params[:min_date]!=nil && params[:min_date].match(/^(19|20)\d\d([-])(0[1-9]|1[012])\2(0[1-9]|[12][0-9]|3[01])$/) &&
    params[:max_date]!=nil && params[:max_date].match(/^(19|20)\d\d([-])(0[1-9]|1[012])\2(0[1-9]|[12][0-9]|3[01])$/) &&
    params[:min_date] <= params[:max_date]

      if params[:lat]!=nil && params[:lon]!=nil

        if params[:radius]!=nil
          @radius=params[:radius]
        else
          @radius=0
        end

        @part=Person.find_by_sql([
        "SELECT pe.*
        FROM Participant pa, Person pe
        WHERE pa.person_id=pe.person_id AND
        pe.famous = 1 AND pa.life_event_id IN (SELECT life_event_id FROM Life_Event l,
        Location lo, Fuzzy_Date f WHERE
        l.location_id=lo.location_id AND
        l.fuzzy_startdate=f.fuzzy_date_id AND
        exact_date <= ? AND exact_date >= ?
        (6378.7*sqrt(POW((0.0174 * (lat - ?)),2) +
        POW((0.0174 * (lon - ?) * COS(?)),2))) <= ? AND
        type = ? )",
        params[:min_date], params[:max_date], params[:lat], params[:lon], params[:lat], @radius, params[:type]
        ])

      elsif params[:place]!=nil

        if params[:radius]!=nil
          @radius=params[:radius]
        else
          @radius=0
        end

        @place=City.find(:first, :conditions => ["city_name = ? ", params[:place]])

        if @place==nil
          @place=getGoogleCoordinates(params[:place])
        end

        @part=Person.find_by_sql([
        "SELECT pe.*
        FROM Participant pa, Person pe
        WHERE pa.person_id=pe.person_id AND
        pe.famous = 1 AND pa.life_event_id IN (SELECT life_event_id FROM Life_Event l,
        Location lo, Fuzzy_Date f WHERE
        l.location_id=lo.location_id AND
        l.fuzzy_startdate=f.fuzzy_date_id AND
        exact_date <= ? AND exact_date >= ?
        (6378.7*sqrt(POW((0.0174 * (lat - ?)),2) +
        POW((0.0174 * (lon - ?) * COS(?)),2))) <= ? AND
        type = ? )",
        params[:min_date], params[:max_date], @place.lat, @place.lon, @place.lat, @radius, params[:type]
        ])

      else

        @part=Person.find_by_sql([
          "SELECT pe.*
          FROM Participant pa, Person pe
          WHERE pa.person_id=pe.person_id AND
          pe.famous = 1 AND pa.life_event_id IN
          (SELECT life_event_id FROM Life_Event l,
          Fuzzy_Date f WHERE l.fuzzy_startdate=f.fuzzy_date_id AND
          type = ? AND exact_date <= ?  AND exact_date >= ?)", params[:type], params[:min_date], params[:max_date]
        ])

      end

    elsif params[:lat]!=nil && params[:lon]!=nil

      if params[:radius]!=nil
        @radius=params[:radius]
      else
        @radius=0
      end

      @part=Person.find_by_sql([
        "SELECT pe.*
        FROM Participant pa, Person pe
        WHERE pa.person_id=pe.person_id AND
        pe.famous = 1 AND pa.life_event_id IN (SELECT life_event_id FROM Life_Event l,
        Location lo WHERE
        l.location_id=lo.location_id AND
        (6378.7*sqrt(POW((0.0174 * (lat - ?)),2) +
        POW((0.0174 * (lon - ?) * COS(?)),2))) <= ? AND
        type = ? )",
        params[:lat], params[:lon], params[:lat], @radius, params[:type]
        ])

    elsif params[:place]!=nil

      if params[:radius]!=nil
        @radius=params[:radius]
      else
        @radius=0
      end

      @place=City.find(:first, :conditions => ["city_name = ? ", params[:place]])

      if @place==nil
        @place=getGoogleCoordinates(params[:place])
      end

      @part=Person.find_by_sql([
        "SELECT pe.*
        FROM Participant pa, Person pe
        WHERE pa.person_id=pe.person_id AND
        pe.famous = 1 AND pa.life_event_id IN (SELECT life_event_id FROM Life_Event l,
        Location lo WHERE
        l.location_id=lo.location_id AND
        (6378.7*sqrt(POW((0.0174 * (lat - ?)),2) +
        POW((0.0174 * (lon - ?) * COS(?)),2))) <= ? AND
        type = ? )",
        @place.lat, @place.lon, @place.lat, @radius, params[:type]
        ])

    else

      @part="Usage: parameters \"min_date\" and \"max_date\" should be in the form \"yyyy-mm-dd\"
      \n Warning: you need to specify at least one parameter!"

    end
  else
    @part="You need to specify the 'type' parameters!"
  end

  content_type :json
  @part.to_json
end
