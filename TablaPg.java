

public class TablaPg{
    private int tabla[][];
    
    public TablaPg(){
        this.tabla[0][0] = 4;
        this.tabla[0][1] = 8;
        this.tabla[0][2] = 12;
        this.tabla[0][3] = 16;
        this.tabla[0][4] = 16;

        this.tabla[1][0] = 8;
        this.tabla[1][1] = 12;
        this.tabla[1][2] = 16;
        this.tabla[1][3] = 20;
        this.tabla[1][4] = 24;

        this.tabla[2][0] = 12;
        this.tabla[2][1] = 16;
        this.tabla[2][2] = 20;
        this.tabla[2][3] = 28;
        this.tabla[2][4] = 32;



    }
public int getPG(int NP,int NR){

    switch(NP){
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
            return this.tabla[0][NR];
        case 6:
        case 7:
        case 8:
        case 9:
        case 10:
            return this.tabla[1][NR];
           
        case 11:
        case 12:
        case 13:
        case 14:
        case 15:
            return this.tabla[2][NR];
           
        default:
        return 0;

    }

}

}