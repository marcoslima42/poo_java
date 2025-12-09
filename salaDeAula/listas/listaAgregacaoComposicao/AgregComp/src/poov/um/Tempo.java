package poov.um;

public class Tempo {
    private int horas;
    private int min;
    private int segs;


    public Tempo(){
        horas = 0;
        min = 0; 
        segs = 0;
    }

    public Tempo(int horas, int min, int segs) {
        this.horas = horas;
        this.min = min;
        this.segs = segs;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setSegs(int segs) {
        this.segs = segs;
    } 

    public void imprimir(){
        System.out.printf("%02d:%02d:%02d", horas, min, segs);
    }

    
}
