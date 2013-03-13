class FuzzyDate < ActiveRecord::Base
  self.table_name = "Fuzzy_Date"
  belongs_to :media
end
