class Location < ActiveRecord::Base
  self.table_name = "Location"
  belongs_to :media
end
