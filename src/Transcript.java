public class Transcript {

    private String city;
    private final String baseUrl = "http://api.weatherapi.com/v1";

    public String getCity() {
        return city;
    }
    public void setCity(String city){
        this.city = city;
    }

    public String getUrl(String key) {
        return baseUrl + "/current.json?key=" + key + "&q=" + city;
    }
}
