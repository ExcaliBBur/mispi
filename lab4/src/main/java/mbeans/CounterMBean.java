package mbeans;

public interface CounterMBean {
    public String getMissStreak();

    public int getAllCounter();

    public int getHitCounter();

    public int getMissInARowCounter();
    public void hitsCounter(String isHit);

    public void initHit(int size, int hitCounter);
}
