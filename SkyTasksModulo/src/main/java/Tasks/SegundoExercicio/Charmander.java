package Tasks.SegundoExercicio;

import javax.swing.*;

class Charmander extends Pokemon {

    public Charmander() {
        super("Charmander", "Fogo", 50, 100);
    }

    @Override
    public void atacar() {
        JOptionPane.showMessageDialog(null, "Charmander usou o ataque Flamethrower!");
    }
}