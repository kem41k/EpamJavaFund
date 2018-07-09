package Task3;

import java.sql.SQLOutput;
import java.util.Random;

public class UserResourceThread {
    public static void main(String[] args) throws InterruptedException {
        SharedResource res = new SharedResource();
        IntegerSetterGetter t1 = new IntegerSetterGetter("1", res);
        IntegerSetterGetter t2 = new IntegerSetterGetter("2", res);
        IntegerSetterGetter t3 = new IntegerSetterGetter("3", res);
        IntegerSetterGetter t4 = new IntegerSetterGetter("4", res);
        IntegerSetterGetter t5 = new IntegerSetterGetter("5", res);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        Thread.sleep(100);
        t1.stopThread();
        t2.stopThread();
        t3.stopThread();
        t4.stopThread();
        t5.stopThread();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();
        System.out.println("main");
    }
}

class IntegerSetterGetter extends Thread {
    private SharedResource resource;
    private boolean run;
    private Random rand = new Random();

    public IntegerSetterGetter(String name, SharedResource resource) {
        super(name);
        this.resource = resource;
        run = true;
    }

    public void stopThread() {
        run = false;
    }

    public void run() {
        int action;
        try {
            while (run) {
                action = rand.nextInt(1000);
                if (action % 2 == 0) {
                    getIntegersFromResource();
                } else {
                    setIntegersIntoResource();
                }
            }
            System.out.printf("Поток %s завершил работу.%n", getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void getIntegersFromResource() throws InterruptedException {
        Integer number;
        synchronized (resource) {
            System.out.printf("Поток %s хочет извлечь число.%n", getName());
            number = resource.getElement();
            if (number == null) {
                System.out.printf("Потоку %s нечего читать из очереди.%n", getName());
            } else {
                System.out.printf("Поток %s извлек число %d%n", getName(), number);
            }
            /*while (number == null) {
                System.out.printf("Поток %s ждет пока очередь заполнится.%n", getName());
                resource.wait();
                System.out.printf("Поток %sвозобновил работу.%n", getName());
                number = resource.getElement();
            }
            System.out.printf("Поток %s извлек число %d%n", getName(), number);*/
        }
    }

    private void setIntegersIntoResource() throws InterruptedException {
        Integer number = rand.nextInt(500);
        synchronized (resource) {
            resource.setElement(number);
            System.out.printf("Поток %s записал число %d%n", getName(), number);
            resource.notify();
        }
    }
}
