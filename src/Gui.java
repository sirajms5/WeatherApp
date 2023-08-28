import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Gui implements ActionListener {

    private JFrame frame = new JFrame("Weather App");
    private JPanel greetings = new JPanel();
    private JPanel searchResult = new JPanel();
    private JPanel details = new JPanel();
    private JPanel imagePanel = new JPanel();
    private JTextField userInputField;
    private Transcript transcript;
    private final String DEGREE = "\u00B0";

    public Transcript getTranscript() {
        return transcript;
    }

    public void setTranscript(Transcript transcript) {
        this.transcript = transcript;
    }

    public void userInputField() {
        JPanel searchInputPanel = new JPanel();
        searchInputPanel.setLayout(new BoxLayout(searchInputPanel, BoxLayout.X_AXIS));
        searchInputPanel.setBorder(new EmptyBorder(10, 0, 0, 0));

        JLabel cityInputTag = new JLabel("Enter City:");
        cityInputTag.setBorder(new EmptyBorder(0, 0, 0, 10));
        searchInputPanel.add(cityInputTag);
        userInputField = new JTextField(20);
        searchInputPanel.add(userInputField);

        JPanel searchButtonPanel = new JPanel();
        searchButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton searchWeather = new JButton("Search");
        searchWeather.addActionListener(this);
        searchButtonPanel.add(searchWeather);

        greetings.add(searchInputPanel);
        greetings.add(searchButtonPanel);
    }

    public void getGreetings() {
        greetings.setLayout(new BoxLayout(greetings, BoxLayout.Y_AXIS));
        greetings.setBorder(new EmptyBorder(0, 10, 0, 10));
        greetings.add(Box.createVerticalGlue());
        JLabel welcome = new JLabel("Welcome to Weather App");
        welcome.setAlignmentX(Component.CENTER_ALIGNMENT);

        greetings.add(welcome);
    }

    public void generateGui() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(greetings, BorderLayout.NORTH);
        frame.pack();
        frame.setVisible(true);
    }

    // loadImage will fetch the image based on provided url
    private JLabel loadImage(String link) {
        try {
            URL url = new URL("https:" + link);
            BufferedImage image = ImageIO.read(url);
            return new JLabel(new ImageIcon(image));
        } catch (Exception e) {
            return new JLabel("Icon not found");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String city = userInputField.getText().trim(); // Get the text from the input field
        ApiKey apiKey = new ApiKey();
        final String key = apiKey.getApiKey();
        WeatherApiConnector weatherApiConnector = new WeatherApiConnector();
        Transcript transcript = weatherApiConnector.sendRequest(key, city);

        if (transcript.isCreated()) {
            details.removeAll(); // to remove old result
            imagePanel.removeAll(); // to remove old result
            searchResult.removeAll(); // to remove old result

            searchResult.setLayout(new GridLayout(0, 1));

            JLabel weatherIcon = loadImage(transcript.getCurrent().getCondition().getIcon());
            imagePanel.setLayout(new GridLayout(0, 1, 0, 10));
            imagePanel.add(weatherIcon);
            searchResult.add(imagePanel);

            details.setLayout(new GridLayout(0, 2, 0, 10));
            details.setBorder(new EmptyBorder(0, 10, 10, 10));
            JLabel cityTag = new JLabel("City:");
            JLabel cityName = new JLabel(transcript.getLocation().getName());
            JLabel temparatureTag = new JLabel("Temprature C" + DEGREE + ":");
            JLabel temparature = new JLabel(transcript.getCurrent().getTemp_c() + DEGREE + "");
            JLabel feelsLikeTag = new JLabel("Feels like:");
            JLabel feelsLike = new JLabel(transcript.getCurrent().getFeelslike_c() + DEGREE + "");
            JLabel conditionTag = new JLabel("Condition:");
            JLabel condition = new JLabel(transcript.getCurrent().getCondition().getText());
            JLabel windSpeedTag = new JLabel("Wind Speed (km/h):");
            JLabel windSpeed = new JLabel(transcript.getCurrent().getWind_kph() + " km/h");
            JLabel windDirectionTag = new JLabel("Wind Direction:");
            JLabel windDirection;

            // switch method to choose wind direction based on wind direction code
            switch (transcript.getCurrent().getWind_dir()) {
                case "N":
                    windDirection = new JLabel("North (N)");
                    break;
                case "NNE":
                    windDirection = new JLabel("North-Northeast (NNE)");
                    break;
                case "NE":
                    windDirection = new JLabel("Northeast (NE)");
                    break;
                case "ENE":
                    windDirection = new JLabel("East-Northeast (ENE)");
                    break;
                case "E":
                    windDirection = new JLabel("East (E)");
                    break;
                case "ESE":
                    windDirection = new JLabel("East-Southeast (ESE)");
                    break;
                case "SE":
                    windDirection = new JLabel("Southeast (SE)");
                    break;
                case "SSE":
                    windDirection = new JLabel("South-Southeast (SSE)");
                    break;
                case "S":
                    windDirection = new JLabel("South (S)");
                    break;
                case "SSW":
                    windDirection = new JLabel("South-Southwest (SSW)");
                    break;
                case "SW":
                    windDirection = new JLabel("Southwest (SW)");
                    break;
                case "WSW":
                    windDirection = new JLabel("West-Southwest (WSW)");
                    break;
                case "W":
                    windDirection = new JLabel("West (W)");
                    break;
                case "WNW":
                    windDirection = new JLabel("West-Northwest (WNW)");
                    break;
                case "NW":
                    windDirection = new JLabel("Northwest (NW)");
                    break;
                case "NNW":
                    windDirection = new JLabel("North-Northwest (NNW)");
                    break;
                default:
                    windDirection = new JLabel("Unknown");
                    break;
            }

            details.add(cityTag);
            details.add(cityName);
            details.add(temparatureTag);
            details.add(temparature);
            details.add(feelsLikeTag);
            details.add(feelsLike);
            details.add(conditionTag);
            details.add(condition);
            details.add(windSpeedTag);
            details.add(windSpeed);
            details.add(windDirectionTag);
            details.add(windDirection);

            searchResult.add(details);
            frame.add(searchResult, BorderLayout.CENTER);
            frame.pack();
            frame.revalidate();
            frame.repaint();
        }
    }

}
