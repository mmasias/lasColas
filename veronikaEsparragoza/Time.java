package pro1.lasColas.veronikaEsparragoza;

public class Time {
    private int hours;
    private int minutes;

    public Time(){
        this.hours = 0;
        this.minutes = 0;
    }

 //    public Time( int i, int minutes){
   //     this.hours = i;
   // }
    //Time reoj = new Time(7,59)

    public int getHours(){
        return hours;
    }
    public int getMinutes(){
        return minutes;
    }

    public void subeTiempo(){
        if(minutes == 59){
            minutes = 0;
            hours += 1;
            if(hours == 24) {
                minutes = 0;
                hours = 0;
            }
        } else{
            minutes += 1;
        }
    }
}
