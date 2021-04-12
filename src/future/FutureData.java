package future;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class FutureData implements Data {

    private IData data;
    private boolean isReady = false;
    private final ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition(); //use it like await() and notify

    @Override
    public String fetch() {
        while(!isReady){
            try{
                lock.lock();
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
        return data.fetch();
    }

    public void setData(IData data) {
        lock.lock();
        if (isReady) {
            return;
        }
        this.data = data;
        isReady = true;
        condition.signal();
        lock.unlock();
    }
}
