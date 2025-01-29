public class Naloga1{

    static int[] x = new int[50];
    static int[] y = new int[50];
    static char[] barva = new char[50];

    public static void main(String[] args) {  

    }
    public static int kateriKvadrant(int i){
        if(x[i]==0|y[i]==0){
            return 0;
        }
        if(x[i]<0){
            if(y[i]<0){
                return 3;
            }
            else{
                return 2;
            }
        }
        else{
            if(y[i]<0){
                return 4;
            }
            else{
                return 1;
            }
        }
    }
    public static int kateriNajvec(){
        int[] st = new int[5];
        for(int i = 0; i<50;i++){
            st[kateriKvadrant(i)]++;
        }
        int max = 1;
        for(int i =2;i<5;i++){
            if(st[i]>st[max]){
                max=i;
            }
        }
        return max;
    }
    public static int najdaljVKvadrantu(int k){
        int max=0;
        for(int i=0; i<50;i++){
            if(kateriKvadrant(i)==k){
                if(razdaljaOdIzhodisca(i)>razdaljaOdIzhodisca(max)){
                    max=i;
                }
            }
        }
        return max;
    }
    public static double razdaljaOdIzhodisca(int i){
        return Math.sqrt((x[i]*x[i]+y[i]*y[i]));
    }
    public static int kateriZNajmanj(){
        int max = 1;
        for(int i = 2; i < 5;i++){
            if(najdaljVKvadrantu(i)>najdaljVKvadrantu(max)){
                max=i;
            }
        }
        return max;
    }
    public static void izpisiNajboljOddaljene(){
        System.out.println("I kvadrant - ("+x[najdaljVKvadrantu(1)]+", "+y[najdaljVKvadrantu(1)]+")   "+barva[najdaljVKvadrantu(1)]);
        System.out.println("II kvadrant - ("+x[najdaljVKvadrantu(2)]+", "+y[najdaljVKvadrantu(2)]+")   "+barva[najdaljVKvadrantu(2)]);
        System.out.println("III kvadrant - ("+x[najdaljVKvadrantu(3)]+", "+y[najdaljVKvadrantu(3)]+")   "+barva[najdaljVKvadrantu(3)]);
        System.out.println("IV kvadrant - ("+x[najdaljVKvadrantu(4)]+", "+y[najdaljVKvadrantu(4)]+")   "+barva[najdaljVKvadrantu(4)]);
    }
    public static int[] vrniNajboljOddaljene(){
        int[] rez = new int[4];
        for(int i =0;i<4;i++){
            rez[i]=najdaljVKvadrantu(i);
        }
        return rez;
    }
    public static double vrniDolzinoPoti(){
        double pot = 0;
        pot += Math.sqrt(((x[najdaljVKvadrantu(1)]-x[najdaljVKvadrantu(2)])*(x[najdaljVKvadrantu(1)]-x[najdaljVKvadrantu(2)])+(y[najdaljVKvadrantu(1)]-y[najdaljVKvadrantu(2)])*(y[najdaljVKvadrantu(1)]-y[najdaljVKvadrantu(2)])));
        pot += Math.sqrt(((x[najdaljVKvadrantu(3)]-x[najdaljVKvadrantu(2)])*(x[najdaljVKvadrantu(3)]-x[najdaljVKvadrantu(2)])+(y[najdaljVKvadrantu(3)]-y[najdaljVKvadrantu(2)])*(y[najdaljVKvadrantu(3)]-y[najdaljVKvadrantu(2)])));
        pot += Math.sqrt(((x[najdaljVKvadrantu(3)]-x[najdaljVKvadrantu(4)])*(x[najdaljVKvadrantu(3)]-x[najdaljVKvadrantu(4)])+(y[najdaljVKvadrantu(3)]-y[najdaljVKvadrantu(4)])*(y[najdaljVKvadrantu(3)]-y[najdaljVKvadrantu(4)])));
        pot += Math.sqrt(((x[najdaljVKvadrantu(1)]-x[najdaljVKvadrantu(4)])*(x[najdaljVKvadrantu(1)]-x[najdaljVKvadrantu(4)])+(y[najdaljVKvadrantu(1)]-y[najdaljVKvadrantu(4)])*(y[najdaljVKvadrantu(1)]-y[najdaljVKvadrantu(4)])));
        return pot;
    }
}