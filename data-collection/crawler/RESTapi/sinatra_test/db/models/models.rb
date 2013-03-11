class Participant < ActiveRecord::Base
  self.table_name = "Participant"
  has_one :person, :foreign_key => 'person_id', :primary_key => 'person_id'
  has_one :lifeEvent, :foreign_key => 'life_event_id', :primary_key => 'life_event_id'
end

class Person < ActiveRecord::Base
  self.table_name = "Person"
  belongs_to :participant
end

class LifeEvent < ActiveRecord::Base
  self.table_name = "Life_Event"
  self.inheritance_column = :ruby_type
  has_one :location, :foreign_key => 'location_id', :primary_key => 'location_id'
  has_one :fuzzyDate, :foreign_key => 'fuzzy_date_id', :primary_key => 'fuzzy_startdate'
  belongs_to :participant
end

class Media < ActiveRecord::Base
  self.table_name = "Media"
  has_one :location, :foreign_key => 'location_id', :primary_key => 'location_id'
  has_one :fuzzyDate, :foreign_key => 'fuzzy_date_id', :primary_key => 'fuzzy_startdate'
end

class City < ActiveRecord::Base
  self.table_name = "City"
end

class Event < ActiveRecord::Base
  self.table_name = "Event"
  self.inheritance_column = :ruby_type
  has_one :location, :foreign_key => 'location_id', :primary_key => 'location_id'
  has_one :fuzzyDate, :foreign_key => 'fuzzy_date_id', :primary_key => 'fuzzy_startdate'
end

class MediaMetadata < ActiveRecord::Base
  self.table_name = "Media_Metadata"
  self.inheritance_column = :ruby_type
  has_one :fuzzyDate, :foreign_key => 'fuzzy_date_id', :primary_key => 'fuzzy_releasedate'
end

class FuzzyDate < ActiveRecord::Base
  self.table_name = "Fuzzy_Date"
  belongs_to :media
  belongs_to :event
  belongs_to :lifeEvent
end

class Location < ActiveRecord::Base
  self.table_name = "Location"
  belongs_to :media
  belongs_to :event
  belongs_to :lifeEvent

end

