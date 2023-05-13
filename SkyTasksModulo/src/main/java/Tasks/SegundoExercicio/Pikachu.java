package Tasks.SegundoExercicio;

import javax.swing.*;


class Pikachu extends Pokemon {

    public Pikachu() {
        super("Pikachu", "Elétrico", 50, 100);
    }

    @Override
    public void atacar() {
        JOptionPane.showMessageDialog(null, "Pikachu usou o ataque Thunderbolt!");
    }
}