/**
 * The {@code Transcript} class represents weather information coming from Weather API,
 * including location data and current weather data.
 * It is structured to meet the API response architecture.
 * 
 * @author Siraj Mohammed Saleem
 * @version 1.0
 * @since 1.0
 */
public class Transcript {

    private boolean isCreated = false; // Flag indicating whether the weather information has been created.
    private Location location; // Nested class representing location information.
    private CurrentWeatherData current; //Nested class representing current weather data.

    /**
     * Check if the weather information has been created.
     *
     * @return {@code true} if weather information is created, {@code false} otherwise.
     */
    public boolean isCreated() {
        return isCreated;
    }

    /**
     * Set the flag indicating whether the weather information has been created.
     *
     * @param isCreated {@code true} if weather information is created, {@code false} otherwise.
     */
    public void setCreated(boolean isCreated) {
        this.isCreated = isCreated;
    }

    /**
     * Get the location information.
     *
     * @return The location information.
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Set the location information.
     *
     * @param location The location information.
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * Get the current weather data.
     *
     * @return The current weather data.
     */
    public CurrentWeatherData getCurrent() {
        return current;
    }

    /**
     * Set the current weather data.
     *
     * @param current The current weather data.
     */
    public void setCurrent(CurrentWeatherData current) {
        this.current = current;
    }

    /**
     * The {@code Location} class represents location information, including city name,
     * region, country, latitude, longitude, timezone ID, and local time details.
     * It is a nested class used within the {@link Transcript} class to
     * structure weather information coming from the Weather API.
     */
    public static class Location {
    	
        private String name; //The name of the city.
        private String region; // The region or state associated with the location.
        private String country; // The country where the location is situated.
        private double lat; //The latitude coordinate of the location.
        private double lon; // The longitude coordinate of the location.
        private String tz_id; // The timezone identifier for the location.
        private long localtime_epoch; // The local time in epoch format for the location.
        private String localtime; // The local time in a human-readable format for the location.

        /**
         * Get the name of the city.
         *
         * @return The city name.
         */
        public String getName() {
            return name;
        }

        /**
         * Set the name of the city.
         *
         * @param name The city name to set.
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * Get the region or state associated with the location.
         *
         * @return The region or state.
         */
        public String getRegion() {
            return region;
        }

        /**
         * Set the region or state associated with the location.
         *
         * @param region The region or state to set.
         */
        public void setRegion(String region) {
            this.region = region;
        }

        /**
         * Get the country where the location is situated.
         *
         * @return The country.
         */
        public String getCountry() {
            return country;
        }

        /**
         * Set the country where the location is situated.
         *
         * @param country The country to set.
         */
        public void setCountry(String country) {
            this.country = country;
        }

        /**
         * Get the latitude coordinate of the location.
         *
         * @return The latitude.
         */
        public double getLat() {
            return lat;
        }

        /**
         * Set the latitude coordinate of the location.
         *
         * @param lat The latitude to set.
         */
        public void setLat(double lat) {
            this.lat = lat;
        }

        /**
         * Get the longitude coordinate of the location.
         *
         * @return The longitude.
         */
        public double getLon() {
            return lon;
        }

        /**
         * Set the longitude coordinate of the location.
         *
         * @param lon The longitude to set.
         */
        public void setLon(double lon) {
            this.lon = lon;
        }

        /**
         * Get the timezone identifier for the location.
         *
         * @return The timezone identifier.
         */
        public String getTz_id() {
            return tz_id;
        }

        /**
         * Set the timezone identifier for the location.
         *
         * @param tz_id The timezone identifier to set.
         */
        public void setTz_id(String tz_id) {
            this.tz_id = tz_id;
        }

        /**
         * Get the local time in epoch format for the location.
         *
         * @return The local time in epoch format.
         */
        public long getLocaltime_epoch() {
            return localtime_epoch;
        }

        /**
         * Set the local time in epoch format for the location.
         *
         * @param localtime_epoch The local time in epoch format to set.
         */
        public void setLocaltime_epoch(long localtime_epoch) {
            this.localtime_epoch = localtime_epoch;
        }

        /**
         * Get the local time in a human-readable format for the location.
         *
         * @return The local time in a human-readable format.
         */
        public String getLocaltime() {
            return localtime;
        }

        /**
         * Set the local time in a human-readable format for the location.
         *
         * @param localtime The local time in a human-readable format to set.
         */
        public void setLocaltime(String localtime) {
            this.localtime = localtime;
        }
    }

    /**
     * The {@code CurrentWeatherData} class represents current weather data,
     * including temperature, wind, pressure, precipitation, humidity, cloud cover,
     * and other related information.
     * It is a nested class used within the {@link Transcript} class to structure
     * weather information coming from the Weather API.
     */
    public static class CurrentWeatherData {

        private long last_updated_epoch; // The epoch timestamp of the last update.
        private String last_updated; // The timestamp of the last update.
        private double temp_c; // The temperature in degrees Celsius.
        private double temp_f; // The temperature in degrees Fahrenheit.
        private int is_day; // An indicator of whether it is currently day or night.
        private Condition condition; // The weather condition at the current location.
        private double wind_mph; // The wind speed in miles per hour.
        private double wind_kph; // The wind speed in kilometers per hour.
        private int wind_degree; // The wind direction in degrees.
        private String wind_dir; // The wind direction as a compass direction.
        private double pressure_mb; // The atmospheric pressure in millibars.
        private double pressure_in; // The atmospheric pressure in inches of mercury.
        private double precip_mm; // The amount of precipitation in millimeters.
        private double precip_in; // The amount of precipitation in inches.
        private int humidity; // The relative humidity as a percentage.
        private int cloud; // The cloud cover as a percentage.
        private double feelslike_c; // The feels like temperature in degrees Celsius.
        private double feelslike_f; // The feels like temperature in degrees Fahrenheit.
        private double vis_km; // The visibility in kilometers.
        private double vis_miles; // The visibility in miles.
        private double uv; // The UV index.
        private double gust_mph; // The wind gust speed in miles per hour.
        private double gust_kph; // The wind gust speed in kilometers per hour.

        /**
         * Get the epoch timestamp of the last update.
         *
         * @return The epoch timestamp of the last update.
         */
        public long getLast_updated_epoch() {
            return last_updated_epoch;
        }

        /**
         * Set the epoch timestamp of the last update.
         *
         * @param last_updated_epoch The epoch timestamp of the last update to set.
         */
        public void setLast_updated_epoch(long last_updated_epoch) {
            this.last_updated_epoch = last_updated_epoch;
        }

        /**
         * Get the timestamp of the last update in a human-readable format.
         *
         * @return The timestamp of the last update in a human-readable format.
         */
        public String getLast_updated() {
            return last_updated;
        }

        /**
         * Set the timestamp of the last update in a human-readable format.
         *
         * @param last_updated The timestamp of the last update to set.
         */
        public void setLast_updated(String last_updated) {
            this.last_updated = last_updated;
        }

        /**
         * Get the temperature in degrees Celsius.
         *
         * @return The temperature in degrees Celsius.
         */
        public double getTemp_c() {
            return temp_c;
        }

        /**
         * Set the temperature in degrees Celsius.
         *
         * @param temp_c The temperature in degrees Celsius to set.
         */
        public void setTemp_c(double temp_c) {
            this.temp_c = temp_c;
        }

        /**
         * Get the temperature in degrees Fahrenheit.
         *
         * @return The temperature in degrees Fahrenheit.
         */
        public double getTemp_f() {
            return temp_f;
        }

        /**
         * Set the temperature in degrees Fahrenheit.
         *
         * @param temp_f The temperature in degrees Fahrenheit to set.
         */
        public void setTemp_f(double temp_f) {
            this.temp_f = temp_f;
        }

        /**
         * Get an indicator of whether it is currently day or night.
         *
         * @return {@code 1} if it is day, {@code 0} if it is night.
         */
        public int getIs_day() {
            return is_day;
        }

        /**
         * Set an indicator of whether it is currently day or night.
         *
         * @param is_day {@code 1} if it is day, {@code 0} if it is night.
         */
        public void setIs_day(int is_day) {
            this.is_day = is_day;
        }

        /**
         * Get the weather condition at the current location.
         *
         * @return The weather condition.
         */
        public Condition getCondition() {
            return condition;
        }

        /**
         * Set the weather condition at the current location.
         *
         * @param condition The weather condition to set.
         */
        public void setCondition(Condition condition) {
            this.condition = condition;
        }

        /**
         * Get the wind speed in miles per hour.
         *
         * @return The wind speed in miles per hour.
         */
        public double getWind_mph() {
            return wind_mph;
        }

        /**
         * Set the wind speed in miles per hour.
         *
         * @param wind_mph The wind speed in miles per hour to set.
         */
        public void setWind_mph(double wind_mph) {
            this.wind_mph = wind_mph;
        }

        /**
         * Get the wind speed in kilometers per hour.
         *
         * @return The wind speed in kilometers per hour.
         */
        public double getWind_kph() {
            return wind_kph;
        }

        /**
         * Set the wind speed in kilometers per hour.
         *
         * @param wind_kph The wind speed in kilometers per hour to set.
         */
        public void setWind_kph(double wind_kph) {
            this.wind_kph = wind_kph;
        }

        /**
         * Get the wind direction in degrees.
         *
         * @return The wind direction in degrees.
         */
        public int getWind_degree() {
            return wind_degree;
        }

        /**
         * Set the wind direction in degrees.
         *
         * @param wind_degree The wind direction in degrees to set.
         */
        public void setWind_degree(int wind_degree) {
            this.wind_degree = wind_degree;
        }

        /**
         * Get the wind direction as a compass direction.
         *
         * @return The wind direction as a compass direction.
         */
        public String getWind_dir() {
            return wind_dir;
        }

        /**
         * Set the wind direction as a compass direction.
         *
         * @param wind_dir The wind direction as a compass direction to set.
         */
        public void setWind_dir(String wind_dir) {
            this.wind_dir = wind_dir;
        }

        /**
         * Get the atmospheric pressure in millibars.
         *
         * @return The atmospheric pressure in millibars.
         */
        public double getPressure_mb() {
            return pressure_mb;
        }

        /**
         * Set the atmospheric pressure in millibars.
         *
         * @param pressure_mb The atmospheric pressure in millibars to set.
         */
        public void setPressure_mb(double pressure_mb) {
            this.pressure_mb = pressure_mb;
        }

        /**
         * Get the atmospheric pressure in inches of mercury.
         *
         * @return The atmospheric pressure in inches of mercury.
         */
        public double getPressure_in() {
            return pressure_in;
        }

        /**
         * Set the atmospheric pressure in inches of mercury.
         *
         * @param pressure_in The atmospheric pressure in inches of mercury to set.
         */
        public void setPressure_in(double pressure_in) {
            this.pressure_in = pressure_in;
        }

        /**
         * Get the amount of precipitation in millimeters.
         *
         * @return The amount of precipitation in millimeters.
         */
        public double getPrecip_mm() {
            return precip_mm;
        }

        /**
         * Set the amount of precipitation in millimeters.
         *
         * @param precip_mm The amount of precipitation in millimeters to set.
         */
        public void setPrecip_mm(double precip_mm) {
            this.precip_mm = precip_mm;
        }

        /**
         * Get the amount of precipitation in inches.
         *
         * @return The amount of precipitation in inches.
         */
        public double getPrecip_in() {
            return precip_in;
        }

        /**
         * Set the amount of precipitation in inches.
         *
         * @param precip_in The amount of precipitation in inches to set.
         */
        public void setPrecip_in(double precip_in) {
            this.precip_in = precip_in;
        }

        /**
         * Get the relative humidity as a percentage.
         *
         * @return The relative humidity as a percentage.
         */
        public int getHumidity() {
            return humidity;
        }

        /**
         * Set the relative humidity as a percentage.
         *
         * @param humidity The relative humidity as a percentage to set.
         */
        public void setHumidity(int humidity) {
            this.humidity = humidity;
        }

        /**
         * Get the cloud cover as a percentage.
         *
         * @return The cloud cover as a percentage.
         */
        public int getCloud() {
            return cloud;
        }

        /**
         * Set the cloud cover as a percentage.
         *
         * @param cloud The cloud cover as a percentage to set.
         */
        public void setCloud(int cloud) {
            this.cloud = cloud;
        }

        /**
         * Get the "feels like" temperature in degrees Celsius.
         *
         * @return The "feels like" temperature in degrees Celsius.
         */
        public double getFeelslike_c() {
            return feelslike_c;
        }

        /**
         * Set the "feels like" temperature in degrees Celsius.
         *
         * @param feelslike_c The "feels like" temperature in degrees Celsius to set.
         */
        public void setFeelslike_c(double feelslike_c) {
            this.feelslike_c = feelslike_c;
        }

        /**
         * Get the "feels like" temperature in degrees Fahrenheit.
         *
         * @return The "feels like" temperature in degrees Fahrenheit.
         */
        public double getFeelslike_f() {
            return feelslike_f;
        }

        /**
         * Set the "feels like" temperature in degrees Fahrenheit.
         *
         * @param feelslike_f The "feels like" temperature in degrees Fahrenheit to set.
         */
        public void setFeelslike_f(double feelslike_f) {
            this.feelslike_f = feelslike_f;
        }

        /**
         * Get the visibility in kilometers.
         *
         * @return The visibility in kilometers.
         */
        public double getVis_km() {
            return vis_km;
        }

        /**
         * Set the visibility in kilometers.
         *
         * @param vis_km The visibility in kilometers to set.
         */
        public void setVis_km(double vis_km) {
            this.vis_km = vis_km;
        }

        /**
         * Get the visibility in miles.
         *
         * @return The visibility in miles.
         */
        public double getVis_miles() {
            return vis_miles;
        }

        /**
         * Set the visibility in miles.
         *
         * @param vis_miles The visibility in miles to set.
         */
        public void setVis_miles(double vis_miles) {
            this.vis_miles = vis_miles;
        }

        /**
         * Get the UV index.
         *
         * @return The UV index.
         */
        public double getUv() {
            return uv;
        }

        /**
         * Set the UV index.
         *
         * @param uv The UV index to set.
         */
        public void setUv(double uv) {
            this.uv = uv;
        }

        /**
         * Get the wind gust speed in miles per hour.
         *
         * @return The wind gust speed in miles per hour.
         */
        public double getGust_mph() {
            return gust_mph;
        }

        /**
         * Set the wind gust speed in miles per hour.
         *
         * @param gust_mph The wind gust speed in miles per hour to set.
         */
        public void setGust_mph(double gust_mph) {
            this.gust_mph = gust_mph;
        }

        /**
         * Get the wind gust speed in kilometers per hour.
         *
         * @return The wind gust speed in kilometers per hour.
         */
        public double getGust_kph() {
            return gust_kph;
        }

        /**
         * Set the wind gust speed in kilometers per hour.
         *
         * @param gust_kph The wind gust speed in kilometers per hour to set.
         */
        public void setGust_kph(double gust_kph) {
            this.gust_kph = gust_kph;
        }
    }

    /**
     * The Condition class represents weather condition information.
     * It contains details about the weather condition text, icon, and code.
     */
    public static class Condition {

        private String text; // Description of the weather condition
        private String icon; // Icon representing the weather condition
        private int code; // Numeric code for the weather condition

        /**
         * Get the description of the weather condition.
         *
         * @return The description of the weather condition.
         */
        public String getText() {
            return text;
        }

        /**
         * Set the description of the weather condition.
         *
         * @param text The description of the weather condition to set.
         */
        public void setText(String text) {
            this.text = text;
        }

        /**
         * Get the icon representing the weather condition.
         *
         * @return The icon representing the weather condition.
         */
        public String getIcon() {
            return icon;
        }

        /**
         * Set the icon representing the weather condition.
         *
         * @param icon The icon representing the weather condition to set.
         */
        public void setIcon(String icon) {
            this.icon = icon;
        }

        /**
         * Get the numeric code for the weather condition.
         *
         * @return The numeric code for the weather condition.
         */
        public int getCode() {
            return code;
        }

        /**
         * Set the numeric code for the weather condition.
         *
         * @param code The numeric code for the weather condition to set.
         */
        public void setCode(int code) {
            this.code = code;
        }
    }

}
