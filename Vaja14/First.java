/**
 *   razred First
 *     ovojni razred za demonstracijo delovanja Sklada
 *     Sklad je reliziran kot notanji razred razreda First,
 *     dejansko je njegov član, kot sta lahko poljubna razredna
 *     lastnost ali razredna metoda
 * 
 *     naj razredna lastnost 'stevilo' vsebuje število elementov v
 *     skladu
 * 
 *     naj razredna metoda 'main/1' služi demonstraciji delovanja sklada
 */
public class First {

    // stevilo NI del Sklad-a !
    static int stevilo = 0;

    /**
     *  razred Sklad 
     *    je razredna komponenta razreda First
     *    kot taka dosegljiva iz vse vsebine razreda First
     *    - private/public znotraj razreda ne igrajo vloge ....
     * 
     * Opis strukture in delovanja:
     *  sklad je struktura, ki:
     *   - ima definirana 2 kazalca : dno in vrh
     *   - ima dfinirani metodi dajNaSklad(push) in vzemiIzSklada(pop)
     *      - metodi sta izvedba algoritma LIFO (tist' k' zad'n pride, gre prv' v'n)
     * 
     * če kazalca dno in vrh kažeta na isto lokacijo, je skad prazen, vrh kaže
     * na lokacijo, kamor vstavimo nov element v postopku vstavljanja
     * dajNaSklad : na pozicijo kazalca vrh damo nov element, kazalec vrh ustrezno 
     * ažuriramo, da kaže na prvo naslednjo 'prazno' lokacijo
     * vzemiIzSklada : ažuriramo kazalec vrh, da kaže na zadnjo zasedeno lokacijo
     * in vrnemo vrednost s te lokacije
     * 
     * realizacija spodaj vsebuje 3 utility/covenience metode, za
     * simpatičnejše delo (empty,full-diagnostični ter show-ugodna) :
     *              
     * 
     */
    static class Sklad {
        private static Integer[] kontejner = new Integer[30];
        private static int vrh = 0;
        private static int dno = 0; 

        static boolean empty(){ return vrh==dno;}
        static boolean full(){ return vrh==kontejner.length;}

        /**
         *  izriše celoten sklad vrtikalno
         */
        static void show(){
            int lvrh=vrh;
            System.out.println(); 
            System.out.print("vrh--> "); if (vrh!=dno) System.out.println();
            while(--lvrh > dno){
                System.out.println();
                System.out.print("              ");    // 14 presledkov, neinteligentno
                System.out.println( kontejner[lvrh] );
            }
            
            if ( vrh != dno ){
              System.out.print("       dno--> ");
              System.out.println( kontejner[lvrh] );
            }
             else{
              System.out.println("dno--> "); 
             }
             System.out.println("------ ------ ------");
             System.out.println();
        }

        /**
         *  izriše vsebino celotnega sklada brez kazalcev
         */
        static void showSimple(){
            int lvrh=vrh;
            System.out.println();

            while(--lvrh >= dno){
                System.out.println( kontejner[lvrh] );
            }
            
        }

        /**
         *  prijazno ne naredi ničesar, če je sklad pred dodajanjem že poln
         * @param vrednost, ki jo dajemo na vrh sklada
         */
        static void push(Integer vrednost){
            if ( full() )  return;
            
             kontejner[vrh] = vrednost;
             vrh++;        
             
             stevilo++;
        }

        /**
         *  vrne vrednost  vrha slada
         *  če ni kaj vrniti, sklad prazen, vrne -1, ker pač nekaj mora vrniti
         * @return vrhnja vrednost s sklada
         */
        static Integer pop(){
            if ( Sklad.empty() ) return -1;
            vrh--;
            return kontejner[vrh];
        }

        static Integer peek(){
            if ( Sklad.empty() ) return -1;
            return kontejner[vrh-1];
        }
    }

    public static class kroznaVrsta{
        private static Integer[] kontejner = new Integer[30];
        private static int glava = 0;
        public static int size =0;
        private static int rep = 0; 

        static boolean empty(){ return glava==rep;}
        static boolean full(){ return glava==rep-1;}

        static void show(){
            System.out.println("Velikost: "+size);
            if(glava<rep){
                for(int i = glava; glava!=rep; i++){
                    if(i==kontejner.length)i=0;
                    if(i==glava)System.out.println("Glava --->  "+kontejner[i]);
                    else if(i==rep){System.out.println("Rep --->    "+kontejner[i]);break;}
                    else System.out.println("            "+kontejner[i]);
                }
            }
            if(glava>rep){
                for(int i = rep; glava!=rep; i++){
                    if(i==kontejner.length)i=0;
                    if(i==glava){System.out.println("Glava --->  "+kontejner[i]);break;}
                    else if(i==rep){System.out.println("Rep --->    "+kontejner[i]);}
                    else System.out.println("            "+kontejner[i]);
                }
            }
        }

        static void showSimple(){
            int lvrh=glava;
            System.out.println();

            while(--lvrh >= rep){
                System.out.println( kontejner[lvrh] );
            }
            
        }

        static void push(Integer vrednost){
            if ( full() )  return;
            
             kontejner[glava] = vrednost;
             glava++;        
             if(glava==kontejner.length)glava=0;
             size++;
             
        }

        static Integer pop(){
            if ( kroznaVrsta.empty() ) return -1;
            Integer temp = rep;
            rep++;
            if(rep==kontejner.length)rep=0;
            size--;
            return kontejner[temp];
        }

        static Integer peek(){
            if ( kroznaVrsta.empty() ) return -1;
            return kontejner[rep];
        }
    }

    public static class linearnaVrsta{
        private static Integer[] kontejner = new Integer[30];
        public static int size =0;
        private static int glava = 0;
        private static int rep = 0; 

        static boolean empty(){ return glava==rep;}
        static boolean full(){ return glava==kontejner.length;}

        static void show(){
            System.out.println("Velikost: "+size);
            int lvrh=glava;
            System.out.println(); 
            System.out.print("glava--> "); if (glava!=rep) System.out.println();
            while(--lvrh > rep){
                System.out.println();
                System.out.print("              ");
                System.out.println( kontejner[lvrh] );
            }
            
            if ( glava != rep ){
              System.out.print("       rep--> ");
              System.out.println( kontejner[lvrh] );
            }
             else{
              System.out.println("rep--> "); 
             }
             System.out.println("------ ------ ------");
             System.out.println();
        }

        static void showSimple(){
            int lvrh=glava;
            System.out.println();

            while(--lvrh >= rep){
                System.out.println( kontejner[lvrh] );
            }
            
        }

        static void push(Integer vrednost){
            if ( full() )  return;
            
             kontejner[glava] = vrednost;
             glava++;        
             size++;
        }

        static Integer pop(){
            if ( linearnaVrsta.empty() ) return -1;
            for(int i =1; i < glava;i++)kontejner[i-1]=kontejner[i];
            if(rep==kontejner.length)rep=0;
            size--;
            return kontejner[rep];
        }

        static Integer peek(){
            if ( linearnaVrsta.empty() ) return -1;
            return kontejner[rep];
        }
    }
    /** */
    public static void main(String[] args){
        //System.out.println(Sklad.dno);
        Sklad.push(32);
        Sklad.push(61);
        Sklad.show();

        System.out.println("size: "+stevilo);

        if ( !Sklad.empty() ){
            System.out.println( "  ---> pop-ing :" + Sklad.pop() );
            stevilo--;
        }

        Sklad.show();

        if ( !Sklad.empty() ){
            System.out.println( "  ---> pop-ing :" + Sklad.pop() );
            stevilo--;
        }

        Sklad.show();

        System.out.println("size: "+stevilo);
        for(int i = 0; i < 25; i++)linearnaVrsta.push(32);
        linearnaVrsta.push(1);

        linearnaVrsta.show();
        linearnaVrsta.pop();
        linearnaVrsta.show();

        for(int i = 0; i < 30; i++)kroznaVrsta.push(32);
        kroznaVrsta.show();
        for(int i = 0; i < 30; i++)kroznaVrsta.pop();
        kroznaVrsta.show();
        for(int i = 0; i < 25; i++)kroznaVrsta.push(1);
        kroznaVrsta.show();

    }
}