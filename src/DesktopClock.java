/**
 * DeskTop Study Clock is a digital clock that upon implementation, resides on
 * your desktop.
 * <p>
 * While studying, it is easy to lose track of time, or to be unaware of time
 * that is actually spent during a study session. Interruptions take us away
 * from our focus and what feels like mere minutes may amount to considerably
 * more. Frequent interruptions can completely obliterate our schedules,
 * leaving us void of any reasonable estimation of value added time spent.
 * The DeskTop Study Clock is intended to facilitate awareness of study
 * intervals, to track progress, and help the user manage their time more
 * efficiently.
 * </p>
 * The current time is displayed on the interface, as well as the day of the
 * week, the date, a Start time, Elapsed time, Elapsed time counter, a
 * multi-use button, a total elapsed time counter and a reset button.
 * Along the bottom there is a date counter that records the starting date and
 * increments daily with a running count in months and days since beginning.
 * <ul>
 *     <li>The current time, day of the week and date draw on your system clock
 *     using SimpleDateFormat and Calendar</li>
 *     <li>The Month/Day counter utilizes java.time and LocalDate to track the
 *     time since starting the project.</li>
 * </ul>
 * <p>
 *     <b>Multi-button: </b>The button starts off green and is used to:
 * <ul>
 *     <li>Start the total timer located on the bottom right of the screen.
 *     This timer counts up from 0:00:00 until the program is terminated or the
 *     manual reset button to the right of the timer is activated.</li>
 *     <li>Sets the "Start: " time to the current time. This serves as a quick
 *     reference as to the beginning of this study session. (The "Start" time
 *     resets to the current time every time this button is activated.)</li>
 *     <li>Sets the "Elapsed: time to 0:00:00 and begins the elapsed time
 *     counter to record the current interval of study.</li>
 * </ul>
 *<p>
 * @author    Henry Pellowski
 * @version   v1.0
 * Date:  March 19, 2022
 * This project would not have been possible (at least for a long time)
 * without the tutorials from youTuber BroCode. He has a broad range of
 * helpful videos on a BUNCH of programming topics and languages.
 *
 */
public class DesktopClock {
    public static void main(String[] args){
        ClockFrame clock = new ClockFrame();


    }
}
