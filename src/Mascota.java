public class Mascota {
    private int energia;
    public int humor;
    private boolean dormido;
    private int saciedad;
    public boolean vivo;

    public Mascota(int energia, int humor) {
        if (validarEnergia(energia)) {
            this.energia = energia;
        }else {
            this.energia = 10;
        }
        if (validarHumor(humor)) {
            this.humor = humor;
        }else{
            this.humor = 0;
        }
        this.dormido = false;
        this.vivo = true;
    };

    private boolean validarEnergia(int energia){
        return energia > 0 && energia <= 100;
    };
    private boolean validarHumor(int humor){
        return humor > 0 && humor <= 5;
    };

    private void morir(){
        this.vivo=false;
    }

    //Metodos de ingesta
    public void comer(){
        if (this.energia == 0){
            morir();
        }

        if (!this.dormido && this.vivo) {
            int energiaAumentada = (int) (energia * 1.10);
            energia = Math.min(energiaAumentada, 100);
            saciedad++;
            if(saciedad >= 3 && humor != 0){
                this.humor--;
            }else {
                if (humor != 5) {
                    humor += 1;
                }
            }
            ;
        }
    };

    public void beber() {
        if (this.energia == 0){
            morir();
        }
        if (!this.dormido && this.vivo) {
            int energiaAumentada = (int) ((double) energia * 1.05);
            energia = Math.min(energiaAumentada, 100);
            saciedad++;
            if(saciedad >= 3 && humor != 0) {
                this.humor--;
            }
            if (humor != 5) {
                humor += 1;
        };
        }
    };

    //Metodos de actividades

    public void correr(){
        if (energia ==0){
            morir();
        }
        if (!this.dormido && this.vivo) {
            energia = (int) ((double) energia * 0.65);
            if (humor > 1) {
                humor -= 2;
            }else {
                humor = 0;
            }
            if (saciedad > 0){
                saciedad = 0;
            }
        }
    };
    public void atacar(){
         energia -= 1;
    };

    public void fatality(){
        vivo = false;
        energia -= 5;
    };


    public void saltar(){
        if (this.energia == 0){
            morir();
        }
        if (!this.dormido && this.vivo) {
            energia = (int) ((double) energia * 0.85);
            if (humor > 1) {
                humor -= 2;
            }else {
                humor = 0;
            }
            if (saciedad > 0){
                saciedad = 0;
            }
       }
    };

    //Metodos extra

    public void dormir(){
        if (this.vivo) {
            this.dormido = true;
            energia = Math.min((energia + 25), 100);
            if (humor != 5) {
                humor += 2;
            }

            if (saciedad > 0) {
                saciedad = 0;
            }
        }
    };

    public void despertar(){
        if (this.vivo) {
            this.dormido = false;
            this.humor -= 1;
        }
    };


    private String asignarHumor(){
        String[] humores = new String[5];
        humores[0] = "Muy enojado";
        humores[1] = "Enojado";
        humores[2] = "Neutral";
        humores[3] = "Contento";
        humores[4] = "Chocho";

        if (humor != 0){
            return humores[this.humor - 1];
        }else {
            return humores[0];
        }
    }

    public void presentacion(){
        String humor = asignarHumor();
        System.out.println("Hola, soy tu mascota, un gusto conocerte, tengo " + this.energia + " de energia y hoy estoy "
                + humor + "¿Estoy vivo? " + this.vivo );
    }

}
