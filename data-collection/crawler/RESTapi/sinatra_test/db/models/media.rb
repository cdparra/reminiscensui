class Media < ActiveRecord::Base
  self.table_name = "Media"
  has_one :location, :foreign_key => 'location_id', :primary_key => 'location_id'
  has_one :fuzzyDate, :foreign_key => 'fuzzy_date_id', :primary_key => 'fuzzy_startdate'
end
