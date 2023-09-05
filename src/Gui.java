import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.net.URI;
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

/**
 * The {@code Gui} class is used to generate the Graphical User Interface (GUI)
 * 
 * @author Siraj Mohammed Saleem
 * @version 1.0
 * @see ApiKey
 * @see Transcript
 * @see WeatherApiConnector
 * @see JFrame
 * @see JPanel
 * @see JTextField
 * @see JButton
 * @see JLabel
 * @see BoxLayout
 * @see BorderLayout
 * @see FlowLayout
 * @see GridLayout
 * @see ActionListener
 * @see MouseAdapter
 * @see Cursor
 * @see Color
 * @see Desktop
 * @see URI
 * @see URL
 * @see BufferedImage
 * @see ImageIO
 * @since 1.0
 */
public class Gui {
	
	 private JFrame frame = new JFrame("Weather App"); // The main frame of the GUI
	 private JPanel northPanel = new JPanel(); // The top panel for user input and search button
	 private JPanel centerPanel = new JPanel(); // The central panel for displaying weather details
	 private JPanel details = new JPanel(); // Panel for detailed weather information
	 private JPanel imagePanel = new JPanel(); // Panel for weather condition icons
	 private JPanel southPanel = new JPanel(); // The bottom panel for additional information
	 private JTextField userInputField; // The text input field for user queries
	 private Transcript transcript; // Transcript for displaying weather data
	 private final String DEGREE = "\u00B0"; // Degree symbol for temperature display

    /**
     * gets the transcript instance
     * 
     * @return Transcript transcript
     */
    public Transcript getTranscript() {
        return transcript;
    }

    /**
     * sets the transcript parameter to the instance variable transcript
     * 
     * @param transcript Transcript
     */
    public void setTranscript(Transcript transcript) {
        this.transcript = transcript;
    }

    /**
     * sets the north panel of the GUI
     */
    public void setNorthPanel() {
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
        northPanel.setBorder(new EmptyBorder(0, 10, 0, 10));
        northPanel.add(Box.createVerticalGlue());

        addWelcomeLabel();
        addSearchInputPanel();
        addSearchButtonPanel();

        frame.add(northPanel, BorderLayout.NORTH);
    }

    /**
     * creates a label and add it to the north panel
     */
    private void addWelcomeLabel() {
        JLabel welcome = new JLabel("Welcome to Weather App");
        welcome.setAlignmentX(Component.CENTER_ALIGNMENT);
        northPanel.add(welcome);
    }

    /**
     * adds the search panel to the north panel and assign a text field and label to it 
     */
    private void addSearchInputPanel() {
        JPanel searchInputPanel = new JPanel();
        searchInputPanel.setLayout(new BoxLayout(searchInputPanel, BoxLayout.X_AXIS));
        searchInputPanel.setBorder(new EmptyBorder(10, 0, 0, 0));

        JLabel cityInputTag = new JLabel("Enter City:");
        cityInputTag.setBorder(new EmptyBorder(0, 0, 0, 10));
        searchInputPanel.add(cityInputTag);
        userInputField = new JTextField(20);
        searchInputPanel.add(userInputField);

        northPanel.add(searchInputPanel);
    }

    /**
     * adds the search button to the north panel
     * as well as having an anonymous inner class method to handle the button click
     */
    private void addSearchButtonPanel() {
        JPanel searchButtonPanel = new JPanel();
        searchButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton searchWeather = new JButton("Search");
        searchWeather.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSearchButtonClicked();
            }
        });
        searchButtonPanel.add(searchWeather);
        northPanel.add(searchButtonPanel);
    }

    /**
     * takes user input and send it to the WeatherApiConnector
     * class, if result is true and transcript is created then it will generate
     * the API request output (saved in transcript instance) in the GUI
     */
    private void handleSearchButtonClicked() {
        String city = userInputField.getText().trim();
        ApiKey apiKey = new ApiKey();
        final String KEY = apiKey.getApiKey(); // make sure to provide your own API key
        WeatherApiConnector weatherApiConnector = new WeatherApiConnector();
        transcript = weatherApiConnector.sendRequest(KEY, city);

        if (transcript.isCreated()) {
            clearPreviousResults();
            setCenterPanel();
            updateSouthPanelMargin();
            frame.pack();
            frame.revalidate();
            frame.repaint();
        }
    }

    /**
     * clears previous results when user clicks the search button
     * and successful result
     */
    private void clearPreviousResults() {
        details.removeAll();
        imagePanel.removeAll();
        centerPanel.removeAll();
    }

    /**
     * generates the center panel that will hold the weather details
     * coming from Weather API and saved in transcript instance
     */
    private void setCenterPanel() {
        centerPanel.setLayout(new GridLayout(0, 1));
        addWeatherIcon();
        addWeatherDetails();
        frame.add(centerPanel, BorderLayout.CENTER);
    }

    /**
     * adds the weather icon to the center panel
     */
    private void addWeatherIcon() {
        JLabel weatherIcon = loadImage(transcript.getCurrent().getCondition().getIcon());
        imagePanel.setLayout(new GridLayout(0, 1, 0, 10));
        imagePanel.add(weatherIcon);
        centerPanel.add(imagePanel);
    }

    /**
     * adds labels to the center panel that shows the
     * details coming from the Weather API and saved in transcript instance
     */
    private void addWeatherDetails() {
        details.setLayout(new GridLayout(0, 2, 40, 10));
        details.setBorder(new EmptyBorder(0, 40, 10, 10));
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

        centerPanel.add(details);
    }

    /**
     * updates the south panel after clicking the
     * search button for better User Interface (UI)
     */
    private void updateSouthPanelMargin() {
        southPanel.setBorder(new EmptyBorder(20, 0, 0, 0));
        frame.add(southPanel, BorderLayout.SOUTH);
        frame.pack();
    }

    /**
     * generates the GUI
     */
    public void generateGui() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * generates the south panel of the GUI that holds
     * the developer name and link to developer portfolio
     */
    public void setSouthPanel() {
        southPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
        JLabel developerTag = new JLabel("Developed By:");
        southPanel.add(developerTag);

        JLabel developerName = new JLabel("Siraj");
        developerName.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        developerName.setForeground(Color.BLUE);
        developerName.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openWebpage("https://sirajsaleem.com");
            }
        });
        southPanel.add(developerName);
        frame.add(southPanel, BorderLayout.SOUTH);
    }

    /**
     * opens the browser using link provided
     * 
     * @param website String
     */
    private void openWebpage(String website) {
        try {
            Desktop.getDesktop().browse(new URI(website));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * fetches the image based on provided url
     * 
     * @param link String
     * @return JLabel
     */
    private JLabel loadImage(String link) {
        try {
            URL url = new URL("https:" + link);
            BufferedImage image = ImageIO.read(url);
            return new JLabel(new ImageIcon(image));
        } catch (Exception e) {
            return new JLabel("Icon not found");
        }
    }

}
