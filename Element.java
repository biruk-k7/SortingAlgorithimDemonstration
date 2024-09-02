public class Element {
    int value;
    double[] sound;
    public Element(int value){
        this.value=value;

    }
    public  int getValue(){

        return this.value;
    }
    public double[] getSound(){

        return this.sound;
    }
    public int compareTo(Element other) {

        if (this.value < other.value) {
            return -1;
        } else if (this.value > other.value) {
            return 1;
        } else {

                return 0;
            }
        }
    public void setSound(int hz) {
        int SAMPLING_RATE = 44100;
        double duration = 0.3;
        int n = (int) (SAMPLING_RATE * duration);
        this.sound = new double[n];
        for (int i = 0; i < n; i++) {
            this.sound[i] = Math.sin(2 * Math.PI * i * hz / SAMPLING_RATE);
        }
    }
    public void draw(double x, double y, double radius) {
        StdDraw.filledSquare(x, y, radius);

    }
    }

