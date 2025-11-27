package main;

// Targer interface

interface projector{
    void turnOn();
    void turnOff();
    void changeSource();
}

// adaptee brand b

class BrandBProjector{
    public void powerUp(){
        System.out.println(" Brand B projector is powering up");
    }
    public void powerDown(){
        System.out.println(" Brand B projector is shutting down");
    }
    public void switchInput(){
        System.out.println(" Brand B projector is changing");
    }
}
// adaptee brand c

class BrandCProjector {
    public void startProjector(){
        System.out.println(" Brand C projector is starting");
    }
    public void stopProjector(){
        System.out.println(" Brand C projector is stopping");
    }
    public void setMode(){
        System.out.println(" Brand C projector is changing mode");
    }
}

// adapter for brand b

class BrandBAdapter implements projector{
    private BrandBProjector brandB;
    public BrandBAdapter(BrandBProjector brandB){
        this.brandB=brandB;
    }

    @Override
    public void turnOn(){
        brandB.powerUp();
    }
    @Override
    public void turnOff(){
        brandB.powerDown();
    }
    @Override
    public void changeSource(){
        brandB.switchInput();
    }
}
// adapter for brand c

class BrandCAdapter implements projector{
    private BrandCProjector brandC;

    public BrandCAdapter(BrandCProjector brandC){
        this.brandC=brandC;
    }
    @Override
    public void turnOn(){
        brandC.startProjector();
    }
    @Override
    public void turnOff(){
        brandC.stopProjector();
    }
    @Override
    public void changeSource(){
        brandC.setMode();
    }

}

// client

class universalRemote{
    private projector projector;
    public universalRemote(projector projector){
        this.projector=projector;
    }
    public void pressPowerOn(){
        projector.turnOn();
    }
    public void pressPowerOff(){
        projector.turnOff();
    }
    public void pressChangeSource(){
        projector.changeSource();
    }
}
public class Main {
    public static void main(String[] args) {

        BrandBProjector brandB= new BrandBProjector();
        projector badapter=new BrandBAdapter(brandB);

        universalRemote r1=new universalRemote(badapter);
        System.out.println("=== controlling Brand B ===");
        r1.pressPowerOn();
        r1.pressChangeSource();
        r1.pressPowerOff();



        BrandCProjector brandC= new BrandCProjector();
        projector cadapter=new BrandCAdapter(brandC);

        universalRemote r2=new universalRemote(cadapter);
        System.out.println("\n=== controlling Brand C ===");
        r2.pressPowerOn();
        r2.pressChangeSource();
        r2.pressPowerOff();

    }
}