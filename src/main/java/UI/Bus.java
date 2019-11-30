package UI;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

/**
 * Singleton wrapper for EventBus
 */
public class Bus {
    private static EventBus instance = null;

    /**
     *  static method to create instance of Singleton class
     * @return Singleton instance of EventBus
     */
    public static EventBus getInstance()
    {
        if (instance == null)
            instance = new EventBus();

        return instance;
    }
}
