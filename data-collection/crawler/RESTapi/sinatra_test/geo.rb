require 'geocoder'

Geocoder.configure(:lookup => :mapquest, :timeout => 10000000)

s = Geocoder.search('Trento')
puts s[0].latitude
puts s[0].longitudeThe Mapquest API requires a key to be configured: