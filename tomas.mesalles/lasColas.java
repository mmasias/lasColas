public class lasColas {
    public static void main(String[] args) {

        //Minutos en una jornada = 720

        boolean caja_1 = true;
        boolean caja_2 = true;
        boolean caja_3 = true;
        boolean caja_4 = true;

        double caja_1_items = 0;
        double caja_2_items = 0;
        double caja_3_items = 0;
        double caja_4_items = 0;

        int minutos_jornada = 0;
        int personas_en_cola = 0;
        int cajas_disponible = 4;

        int minutos_cola_libre = 0;
        int personas_atendidas = 0;
        int items_vendidos = 0;

        while (minutos_jornada < 720){
            
            //double prob_cliente_nuevo = Math.random() * (40 - 0) + 0;

            double prob_llegada = Math.random() * (100 - 0) + 0;
            if (prob_llegada <= 40) {
                personas_en_cola = personas_en_cola + 1;
            }

            if (personas_en_cola == 0) {
                minutos_cola_libre = minutos_cola_libre + 1;
            }

            if (personas_en_cola > 0 && cajas_disponible > 0) {
                personas_en_cola = personas_en_cola - 1;
                cajas_disponible = cajas_disponible - 1;

                if (caja_1 == true){
                    caja_1 = false;
                    caja_1_items = (int) (Math.random() * (15 - 5) + 5);

                } else if (caja_2 == true){
                    caja_2 = false;
                    caja_2_items = (int) (Math.random() * (15 - 5) + 5);

                } else if (caja_3 == true){
                    caja_3 = false;
                    caja_3_items = (int) (Math.random() * (15 - 5) + 5);

                }else if (caja_4 == true){
                    caja_4 = false;
                    caja_4_items = (int) (Math.random() * (15 - 5) + 5);

                }
            }

            //System.out.println("caja_1_items: " + (int) caja_1_items);
            //System.out.println("caja_2_items: " + (int) caja_2_items);
            //System.out.println("caja_3_items: " + (int) caja_3_items);
            //System.out.println("caja_4_items: " + (int) caja_4_items);

            if (caja_1 == false){
                caja_1_items = caja_1_items - 1;
                items_vendidos = items_vendidos + 1;
                if (caja_1_items <= 0) {
                    personas_atendidas = personas_atendidas + 1;
                    cajas_disponible = cajas_disponible + 1;
                    caja_1 = true;
                }
            }
            if (caja_2 == false){
                caja_2_items = caja_2_items - 1;
                items_vendidos = items_vendidos + 1;
                if (caja_2_items <= 0) {
                    personas_atendidas = personas_atendidas + 1;
                    cajas_disponible = cajas_disponible + 1;
                    caja_2 = true;
                }
            }
            if (caja_3 == false){
                caja_3_items = caja_3_items - 1;
                items_vendidos = items_vendidos + 1;
                if (caja_3_items <= 0) {
                    personas_atendidas = personas_atendidas + 1;
                    cajas_disponible = cajas_disponible + 1;
                    caja_3 = true;
                }
            }
            if (caja_4 == false){
                caja_4_items = caja_4_items - 1;
                items_vendidos = items_vendidos + 1;
                if (caja_4_items <= 0) {
                    personas_atendidas = personas_atendidas + 1;
                    cajas_disponible = cajas_disponible + 1;
                    caja_4 = true;
                }
            }

            minutos_jornada = minutos_jornada + 1;

            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
                + "\nMinuto [" + minutos_jornada + "] de la jornada:");
                //+ "\nProbabilidad cliente nuevo: [" + (int) prob_cliente_nuevo + "%]");
            //System.out.println("Probabilidad de llegada: [" + prob_llegada + "]");
            if (prob_llegada <= 40) {
                System.out.println("<Una persona mas se ha unido a la cola.>");
            }
            System.out.println("Personas en la cola: [" + personas_en_cola + "]" + "\n");

            System.out.println("Caja 1:");
            if (caja_1 == false) {
                System.out.println("Items por pagar: [" + caja_1_items + "]\n");
            } else {System.out.println("Caja disponible" + "\n");}

            System.out.println("Caja 2:");
            if (caja_2 == false) {
                System.out.println("Items por pagar: [" + caja_2_items + "]\n");
            } else {System.out.println("Caja disponible" + "\n");}

            System.out.println("Caja 3:");
            if (caja_3 == false) {
                System.out.println("Items por pagar: [" + caja_3_items + "]\n");
            } else {System.out.println("Caja disponible" + "\n");}

            System.out.println("Caja 4:");
            if (caja_4 == false) {
                System.out.println("Items por pagar: [" + caja_4_items + "]\n");
            } else {System.out.println("Caja disponible" + "\n");}
        }
        System.out.println("================================================"
            + "\nResumen del dia:"
            + "\nMinutos de cola libre [" + minutos_cola_libre +"] "
            + "\nPersonas en la cola al final del dia [" + personas_en_cola +"] "
            + "\nTotal de personas atendidas: ["+ personas_atendidas +"] "
            + "\nTotal de items vendidos: ["+ items_vendidos +"]" + "\n");
    }
}