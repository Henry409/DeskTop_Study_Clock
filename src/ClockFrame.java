import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.time.*;

/**
 * Establishes a frame that displays the current time, current day and date,
 * study interval start time and counter, start/stop and reset buttons,
 * total time counter and a counter which increments the day from a starting
 * date.
 */
public class ClockFrame extends JFrame implements ActionListener{

//Global variable declarations
    int elapsedTime = 0;
    int eElapsedTime = 0;
    int seconds=0, minutes=0, hours=0;
    int eSeconds=0, eMinutes=0, eHours=0;
    boolean isStarted = false;

    String time, date;
    String seconds_string = String.format("%02d",seconds);
    String minutes_string = String.format("%02d",minutes);
    String hours_string = String.format("  %1d",hours);

    String eSeconds_string = String.format("%02d",seconds);
    String eMinutes_string = String.format("%02d",minutes);
    String eHours_string = String.format("  %1d",hours);

    JFrame frame;
    JPanel informationPanel;
    JLabel timeLabel, dateLabel, startTimeLabel, elapsedTimeLabel;
    JLabel timerLabel, counterLabel, startedLabel, elapsedCounterLabel;
    JButton startButton, resetButton;

    SimpleDateFormat timeFormat;

    SimpleDateFormat dateFormat;
//Change the date in the () to whatever date you want to start from
    LocalDate lastDay = LocalDate.of(2022, Month.JANUARY, 21);
    LocalDate today = LocalDate.now();

    Period stretch = Period.between(lastDay, today);
    int days = stretch.getDays(), months=stretch.getMonths();
    int years=stretch.getYears();
    String lastDayMessage = "   It has been " + months + " months and " + days +
            " days since we left PECO";
//Timer action event listeners for the elapsed time and total timers
    Timer timer = new Timer(1000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
    //The timer will do everything in here every second
        //Total timer
            elapsedTime += 1000;
            hours = (elapsedTime / 3_600_000);
            minutes = (elapsedTime / 60_000) % 60;
            seconds = (elapsedTime / 1000) % 60;
            seconds_string = String.format("%02d",seconds);
            minutes_string = String.format("%02d",minutes);
            hours_string = String.format("%1d",hours);
            timerLabel.setText("  " +hours_string+":"+minutes_string+":"+
                    seconds_string);
        //Elapsed time timer
            eElapsedTime +=1000;
            eHours = (eElapsedTime / 3_600_000);
            eMinutes = (eElapsedTime / 60_000) % 60;
            eSeconds = (eElapsedTime / 1000) % 60;
            eSeconds_string = String.format("%02d",eSeconds);
            eMinutes_string = String.format("%02d",eMinutes);
            eHours_string = String.format("%1d",eHours);
            elapsedCounterLabel.setText("  " +eHours_string+":"+eMinutes_string+
                    ":"+eSeconds_string);
        }
    });

    ClockFrame() {
        //Labels and Panels that function as containers for the components that
        //make up the DeskTop Study Clock
//Time
        timeLabel = new JLabel();
        timeLabel.setBounds(0,0,500,160);
        timeLabel.setBackground(Color.lightGray);
        timeLabel.setOpaque(true);
        timeLabel.setForeground(new Color(7, 227, 219));
        timeLabel.setFont(new Font("Poppins", Font.BOLD, 175));
        timeLabel.setHorizontalAlignment(JLabel.CENTER);
        timeLabel.setVerticalAlignment(JLabel.CENTER);

    //Sets the format on how the time will appear. Military time selected
    // change H to h for twelve hour time
        timeFormat = new SimpleDateFormat("H:mm");

//Date
        dateLabel = new JLabel();
        dateLabel.setBounds(0,160,500,30);
        dateLabel.setBackground(Color.lightGray);
        dateLabel.setOpaque(true);
        dateLabel.setForeground(Color.darkGray);
        dateLabel.setFont(new Font("Ink Free", Font.BOLD, 24));
        dateLabel.setHorizontalAlignment(JLabel.LEFT);
        dateLabel.setVerticalAlignment(JLabel.CENTER);
    //Displays the day as ex: Saturday   March 19, 2022
        dateFormat = new SimpleDateFormat("   EEEE            MMMMM d," +
                " yyyy");

//Information: StartTime, ElapsedTime, Timer, Start/StopButton, ResetButton
        informationPanel = new JPanel();
        informationPanel.setBounds(0,190,500,30);
        informationPanel.setLayout(null);
    //Start: label
        startTimeLabel = new JLabel();
        startTimeLabel.setBounds(0,0,60,30);
        startTimeLabel.setBackground(Color.lightGray);
        startTimeLabel.setOpaque(true);
        startTimeLabel.setForeground(Color.darkGray);
        startTimeLabel.setFont(new Font("Ink Free", Font.BOLD, 16));
        startTimeLabel.setHorizontalAlignment(JLabel.LEFT);
        startTimeLabel.setText(" Start: ");
    //Start time label, holds the start time of this session
        startedLabel = new JLabel();
        startedLabel.setBounds(60,0,80,30);
        startedLabel.setBackground(Color.lightGray);
        startedLabel.setOpaque(true);
        startedLabel.setForeground(Color.darkGray);
        startedLabel.setFont(new Font("Ink Free", Font.PLAIN, 22));
        startedLabel.setHorizontalAlignment(JLabel.LEFT);
    //Elapsed: label
        elapsedTimeLabel = new JLabel();
        elapsedTimeLabel.setBounds(140,0,65,30);
        elapsedTimeLabel.setBackground(Color.lightGray);
        elapsedTimeLabel.setOpaque(true);
        elapsedTimeLabel.setForeground(Color.darkGray);
        elapsedTimeLabel.setFont(new Font("Ink Free", Font.BOLD, 16));
        elapsedTimeLabel.setText("Elapsed: " );
    //Elapsed time label, holds the timer count since the start of this session
        elapsedCounterLabel = new JLabel();
        elapsedCounterLabel.setBounds(205,0,110,30);
        elapsedCounterLabel.setBorder(BorderFactory.createEtchedBorder(1));
        elapsedCounterLabel.setBackground(Color.lightGray);
        elapsedCounterLabel.setOpaque(true);
        elapsedCounterLabel.setForeground(Color.darkGray);
        elapsedCounterLabel.setFont(new Font("Ink Free", Font.PLAIN,
                22));
        //sets the timer count in the label
        elapsedCounterLabel.setText("" +eHours_string+":"+eMinutes_string+":"+
                eSeconds_string);
    //Start button- default starts with a green button
        startButton = new JButton();
        startButton.setFocusable(false);
        startButton.setText("");
        startButton.setBounds(315,0,30,30);
        startButton.setBackground(Color.green);
        startButton.addActionListener(this);
    //Timer label, holds the total count time until manually reset
        timerLabel = new JLabel();

        timerLabel.setBounds(343,0,130,30);
        timerLabel.setBackground(Color.lightGray);
        timerLabel.setOpaque(true);
        timerLabel.setForeground(Color.darkGray);
        timerLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
        timerLabel.setBorder(BorderFactory.createEtchedBorder(1));
        //sets the time in the total timer label
        timerLabel.setText("" +hours_string+":"+minutes_string+":"+
                seconds_string);
    //Reset button- activate to reset Start time, Elapsed time counter and
        //total time counter
        resetButton = new JButton();
        resetButton.setBounds(470,0,30,30);
        resetButton.setBackground(Color.cyan);
        resetButton.addActionListener(this);

//Counter from last day at Peco or beginning of project. Change lastDay message
        //and LocalDate lastDay variables to customize
        counterLabel = new JLabel();
        counterLabel.setLayout(null);
        counterLabel.setBounds(0,220,500,30);
        counterLabel.setBackground(new Color(169, 172, 176));
        counterLabel.setOpaque(true);
        counterLabel.setForeground(Color.white);
        counterLabel.setFont(new Font("Ink Free", Font.BOLD, 18));
        counterLabel.setHorizontalAlignment(JLabel.LEFT);
        counterLabel.setVerticalAlignment(JLabel.CENTER);
        counterLabel.setText(lastDayMessage);

//Frame main
        frame = new JFrame("Carpe Diem - Seize the Day!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(510, 285);
        frame.setBackground(Color.blue);

        frame.add(timeLabel);
        frame.add(dateLabel);
        frame.add(informationPanel);
            informationPanel.add(startTimeLabel);
            informationPanel.add(startedLabel);
            informationPanel.add(elapsedTimeLabel);
            informationPanel.add(startButton);
            informationPanel.add(timerLabel);
            informationPanel.add(resetButton);
            informationPanel.add(elapsedCounterLabel);

        frame.add(counterLabel);
        frame.setVisible(true);
//This displays the time and date in real time
    while (true){
        time = timeFormat.format(Calendar.getInstance().getTime());
        timeLabel.setText("" + time);

        date = dateFormat.format(Calendar.getInstance().getTime());
        dateLabel.setText("" + date);

        try{
                Thread.sleep(1000);}
    catch(InterruptedException e) {
        e.printStackTrace();
        }
    }
    }
//Begin Methods
    //Multi button start event
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==startButton) {
            if(isStarted==false){
                isStarted = true;
                startButton.setBackground(Color.red);
                //sets Start time to current time
                startedLabel.setText(" " +
                        timeFormat.format(Calendar.getInstance().getTime()));
            //resets Elapsed timer to zero and starts the count
                int eSeconds=0, eMinutes=0, eHours=0;
                eElapsedTime = 0;
                eSeconds_string = String.format("%02d",eSeconds);
                eMinutes_string = String.format("%02d",eMinutes);
                eHours_string = String.format("%1d",eHours);
                elapsedCounterLabel.setText("  "+eHours_string+":"+
                        eMinutes_string+":"+eSeconds_string);
            //calls method to start the timer
                start();
            }
            //if the timer is already started. Activating the button again will
            //stop the timers
            else {
                isStarted = false;
                startButton.setBackground(Color.green);
                stop();
            }
        }
        //resets both timers
        if(e.getSource()==resetButton) {
            isStarted=false;
            startButton.setBackground(Color.green);
            reset();
        }
    }
        void start() {
            timer.start();
        }

        void stop() {
            timer.stop();
        }

        void reset() {
            timer.stop();
            elapsedTime = 0;
            seconds = 0;
            minutes = 0;
            hours = 0;
            seconds_string = String.format("%02d",seconds);
            minutes_string = String.format("%02d",minutes);
            hours_string = String.format("%1d",hours);
            timerLabel.setText("  "+hours_string+":"+minutes_string+":"+
                    seconds_string);
            elapsedCounterLabel.setText("  "+hours_string+":"+minutes_string+
                    ":"+seconds_string);
        }
}
