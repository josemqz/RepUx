package t3;

public class Barbaro extends Clase {

    public Barbaro(){
        crearClase();
    }

    public void crearClase(){
        setArmadura(15);

    }

    public void ataque(Personaje j, Personaje e){   //puede atacar el jugador o el enemigo

        int dAt = 0;    //decide si se efectua el ataque
        int dDa = 0;    //daño efectuado

        dAt = Juego.rollDice(20);



        if (e.getEstado() == 'd'){  //enemigo en modo de defensa
            System.out.println("Enemigo está en modo de defensa!");

            int dAt2;
            dAt2 = Juego.rollDice(20);

            if (dAt2 < dAt) dAt = dAt2;
        }

        if (dAt >= e.getArmadura()){

            if (j.getHabilidad() == "Atacante" && dAt < 2){
                System.out.println("");
                return;
            }

            dDa = Juego.rollDice(8);
            dDa += j.getFuerza();

            if (dAt == 20){     //daño duplicado        WAIT, SE DUPLICA AL FINAL O AL PRINCIPIO?
                dDa *= 2;
            }
        }

        if (dDa >= 0) e.asignarVida(e.getVida() - dDa);
        else e.asignarVida(0);
    }

    public void defender(){
        setEstado('d'); //cambiar en otras clases
    }


}
