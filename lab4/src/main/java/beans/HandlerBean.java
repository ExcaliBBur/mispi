package beans;

import mbeans.CounterMBean;
import mbeans.SquareMBean;
import mbeans.Counter;
import mbeans.Square;
import utils.DataBaseHandler;
import utils.Hit;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.io.Serializable;
import java.lang.management.ManagementFactory;
import java.time.LocalDateTime;
import java.util.*;


@ManagedBean(name = "handlerBean")
@SessionScoped
public class HandlerBean implements Serializable {
    private long startTime;
    public Hit hit = new Hit();
    public List<Hit> hits = new ArrayList<>();

    public CounterMBean counter;
    public SquareMBean square;

    public HandlerBean() {
        init();
        try {
            MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();

            ObjectName counterName = new ObjectName("MBeans:name=counter");
            ObjectName squareName = new ObjectName("MBeans:name=square");
            mbs.registerMBean(square, squareName);
            mbs.registerMBean(counter, counterName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void init() {
        counter = new Counter();
        square = new Square();
        List<Hit> hits = DataBaseHandler.getHits();
        int hitCounter = 0;
        for (Hit hit : hits) {
            if (hit.getHit().equals("Hit")) hitCounter++;
        }
        setHits(hits);

        counter.initHit(hits.size(), hitCounter);
        System.out.println("Общее число точек: " + counter.getAllCounter());
        System.out.println("Число попавших точек: " + counter.getHitCounter());
        System.out.println();
    }

    public void setHit(Hit hit) {
        this.hit = hit;
    }

    public Hit getHit() {
        return hit;
    }

    public void setHits(List<Hit> hits) {
        this.hits = hits;
    }

    public List<Hit> getHits() {
        List<Hit> outputHits = new ArrayList<>(hits);
        Collections.reverse(outputHits);
        return outputHits;
    }

    public CounterMBean getCounter() {
        return counter;
    }

    public void setCounter(CounterMBean counter) {
        this.counter = counter;
    }

    public SquareMBean getSquare() {
        return square;
    }

    public void setSquare(SquareMBean square) {
        this.square = square;
    }

    public void addHit() {
        startTime = System.currentTimeMillis();
        String isHit = checkHit();
        hit.setHit(isHit);
        hit.setCurrentTime(LocalDateTime.now());
        hit.setWorkTime((System.currentTimeMillis() - startTime));
        hits.add(hit);
        DataBaseHandler.addHit(hit);
        hit = new Hit(hit.getX(), hit.getY(), hit.getR());

        counter.hitsCounter(isHit);

        square.calculateSquare(hit.getR());
        square.printSquare();

    }

    public String checkHit() {
        float x = hit.getX();
        float y = hit.getY();
        float R = hit.getR();
        if (x >= 0 && y >= 0) {
            if (x <= R / 2 && y <= R) return "Hit";
        } else if (x < 0 && y >= 0) {
            if (Math.pow(x, 2) + Math.pow(y, 2) <= Math.pow(R, 2)) return "Hit";
        } else if (x <= 0 && y < 0) {
            if (y >= -2 * x - R) return "Hit";
        }
        return "Miss";
    }

}
