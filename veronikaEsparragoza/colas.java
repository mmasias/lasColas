package pro1.lasColas.veronikaEsparragoza;

import java.util.ArrayList;

public class colas {
    final static int numeroCajas = 4;
    public static void main (String[] args){
        int personasAtendidas = 0;
        int itemGlobal = 0;
        int colaVacia = 0;
        ArrayList<Integer> colaDePersonas = new ArrayList<Integer>();
        ArrayList<Cajas> listaCajas = new ArrayList<Cajas>();
        Time reloj = new Time();

        // crear 4 cajas

        for (int i = 0; i < numeroCajas; i++){
            Cajas caja = new Cajas();
            listaCajas.add(caja);
         }

        for(int i = 0; i < 1440 ; i ++) {

            if(reloj.getHours() >= 9 && reloj.getHours() <= 20) {
                System.out.println(reloj.getHours() + " : " + reloj.getMinutes());

                float probabilidadDePersonaEnCola = (float) (Math.random());

                if (probabilidadDePersonaEnCola < 0.4) {
                    // crear una nueva persona con su numero de items con un rango entre 5 y 15
                    int itemPersona = (int) (Math.random() * (15 - 5) + 5);

                    itemGlobal += itemPersona;
                // meter a la persona a la cola
                colaDePersonas.add(itemPersona);
                System.out.println("ey se agrego una persona a la lista");
            }
            System.out.println("El numero de personas en la cola son: " + colaDePersonas.size());

                if(colaDePersonas.isEmpty()){
                    colaVacia += 1;
                }
            // si hay personas en la cola, la primera persona va a x caja libre,
            // se elimna la primera pesona de la cola
            // x caja pasa a ser ocupada
            // caja ocu-pada = - primera persona
            // la caja dura el numero de minutos que el numero de persona, ej: persona=15, caja dura 15min
            //si llega a cero el numero de items de la persona : cambia el estado de la caja que contiene esa persona a libre
            if(colaDePersonas != null && !colaDePersonas.isEmpty() && isCajaAvailable(listaCajas)){
                Cajas caja = getCajaLibre(listaCajas);

                caja.setPersona(colaDePersonas.get(0));
                colaDePersonas.remove(0);
                System.out.println("se elimino un elemento de la cola");
            }

            for(Cajas caja: listaCajas){
                caja.cambiarEstadoCaja();
                if(caja.getPersona() == 0){
                    personasAtendidas +=1;
                }
            }

                for(Cajas caja: listaCajas){
                    if(reloj.getHours() == 20 && reloj.getMinutes() == 59){
                        itemGlobal -= caja.getPersona();
                    }
                    if (caja.getOcupado() == false){
                        System.out.print("Libre: " + caja.getPersona() + " ");
                    } else {
                        System.out.print("Ocupado: " + caja.getPersona() + " ");
                    }
                }
                System.out.println("");
            System.out.println("---------------------------------");
            }

            reloj.subeTiempo();
        }

        System.out.println("Resumen del día:");
        System.out.println("El numero de minutos en que no hubo nadie en cola: " + colaVacia);
        System.out.println("El numero de personas en la cola son: " + colaDePersonas.size());
        System.out.println("El numero de personas atendidas durante el dia: " + personasAtendidas);
        System.out.println("El numero de items vendidos en el dia: " + itemGlobal);
    }

    public static Cajas getCajaLibre(ArrayList<Cajas> listaCajas){
        for (Cajas cajalibre : listaCajas){
          if(cajalibre.getOcupado() == false){
              return cajalibre;
          }
        }
        return null;
    }

    public static boolean isCajaAvailable(ArrayList<Cajas> listaCajas){
        //hay una caja libre?
        boolean availableCaja = false;
        for (Cajas elem : listaCajas){
            if(elem.getOcupado() == false){
                availableCaja = true;
            }
        }
        return availableCaja;
    }
}
