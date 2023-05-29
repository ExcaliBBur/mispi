package mbeans;

import javax.faces.bean.ManagedBean;
import javax.management.*;
import java.io.Serializable;


@ManagedBean(name = "counterBean")
public class Counter extends NotificationBroadcasterSupport implements Serializable, CounterMBean {
    private int missInARowCounter = 0;
    private int allCounter = 0;
    private int hitCounter = 0;
    private String missStreak = "";
    private int sequenceNumber = 0;

    public String getMissStreak() {
        return missStreak;
    }

    public int getAllCounter() {
        return allCounter;
    }

    public int getHitCounter() {
        return hitCounter;
    }
    public void setHitCounter(int hitCounter) {
        this.missInARowCounter = 0;
        this.hitCounter = hitCounter;
    }

    public int getMissInARowCounter() {
        return missInARowCounter;
    }

    public void hitsCounter(String isHit) {
        missStreak = "";

       ++allCounter;

        if (isHit.equals("Hit")) {
            missInARowCounter = 0;
            ++hitCounter;
        }
        else {
            ++missInARowCounter;
            if (missInARowCounter == 4) {
                Notification notification = new Notification("miss notification", this, sequenceNumber++,
                        "4 misses in a row");
                sendNotification(notification);
                missStreak = "Вы промахнулись 4 раза подряд!";
                System.out.println(missStreak);
            }
        }

        System.out.println("Общее число точек: " + allCounter);
        System.out.println("Число попавших точек: " + hitCounter);
        System.out.println("Число промахов подряд: " + missInARowCounter);
    }

    public void initHit(int size, int hitCounter) {
        this.allCounter = size;
        this.hitCounter = hitCounter;
    }
}
