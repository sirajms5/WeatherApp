import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Gui implements ActionListener {

    private JPanel greetings = new JPanel();
    private JPanel details = new JPanel();
    private JPanel userInput = new JPanel();
    JTextField userInputField;
    private Transcript transcript;

    public Transcript getTranscript() {
        return transcript;
    }

    public void setTranscript(Transcript transcript) {
        this.transcript = transcript;
    }

    public void userInputField() {
        JPanel searchInputPanel = new JPanel();
        searchInputPanel.setLayout(new BoxLayout(searchInputPanel, BoxLayout.X_AXIS));
        JLabel cityInputTag = new JLabel("Enter City:");
        cityInputTag.setBorder(new EmptyBorder(0, 0, 0, 10)); // to have a margin between tag and input field
        searchInputPanel.add(cityInputTag);
        userInputField = new JTextField(20);
        searchInputPanel.add(userInputField);

        JPanel searchButtonPanel = new JPanel();
        searchButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton searchWeather = new JButton("Search");
        searchWeather.addActionListener(this);

        searchButtonPanel.add(searchWeather);
        userInput.add(searchInputPanel);
        userInput.add(searchButtonPanel);
    }

    public void getDetails() { // this should be in action listener
        details.setLayout(new GridLayout(0, 2));
        JLabel cityTag = new JLabel("City");
        JLabel cityName = new JLabel(transcript.getLocation().getName());

        details.add(cityTag);
        details.add(cityName);
    }

    public void getGreetings() {
        greetings.setLayout(new BoxLayout(greetings, BoxLayout.Y_AXIS));
        greetings.add(Box.createVerticalGlue());

        JLabel welcome = new JLabel("Welcome to Weather App");
        welcome.setAlignmentX(Component.CENTER_ALIGNMENT);
        greetings.add(welcome);
    }

    public void generateGui() {
        JFrame frame = new JFrame("Weather App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(greetings, BorderLayout.NORTH);
        frame.add(userInput, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String city = userInputField.getText().trim(); // Get the text from the input field        
        ApiKey apiKey = new ApiKey();
		final String key = apiKey.getApiKey();
		WeatherApiConnector weatherApiConnector = new WeatherApiConnector();
        weatherApiConnector.sendRequest(key, city);

        // details.setLayout(new GridLayout(0, 2));
        // JLabel cityTag = new JLabel("City");
        // JLabel cityName = new JLabel(transcript.getLocation().getName());

        // details.add(cityTag);
        // details.add(cityName);
    }

}
