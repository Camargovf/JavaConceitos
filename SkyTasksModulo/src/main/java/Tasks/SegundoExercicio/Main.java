package Tasks.SegundoExercicio;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {

    private static final Map<String, Pokemon> pokemonMap = new HashMap<>();

    static {
        pokemonMap.put("pikachu", new Pikachu());
        pokemonMap.put("charmander", new Charmander());
    }

    public static void main(String[] args) {

        String resposta = JOptionPane.showInputDialog("Qual Pokémon deseja? Pikachu ou Charmander?");
        Pokemon meuPokemon = pokemonMap.get(resposta.toLowerCase());

        try {
            if (meuPokemon != null) {
                JOptionPane.showMessageDialog(null,
                        "Você escolheu " + resposta + ". Confira as características");
            } else {
                throw new Exception("");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Você não escolheu nenhum Pokémon. Tente novamente.");
            return;
        }

        exibirPokemon(meuPokemon, "src/main/Resources/" + resposta.toLowerCase() + ".png");

        Pokemon oponente = getRandomPokemon();

        JOptionPane.showMessageDialog(null, "Seu oponente é um " + oponente.getNome() + "!");

        batalhar(meuPokemon, oponente);
    }

    public static void exibirPokemon(Pokemon pokemon, String caminhoImagem) {
        JPanel panel = new JPanel();
        ImageIcon icon = new ImageIcon(caminhoImagem);
        JLabel label = new JLabel();
        label.setIcon(icon);
        panel.add(label);

        String printPokemon = "Nome: " + pokemon.getNome() + "\n" +
                "Tipo: " + pokemon.getTipo() + "\n" +
                "Nível: " + pokemon.getNivel();

        JOptionPane.showMessageDialog(null, printPokemon, "Pokémon", JOptionPane.INFORMATION_MESSAGE, icon);
    }

    public static void batalhar(Pokemon meuPokemon, Pokemon oponente) {
        while (meuPokemon.getHP() > 0 && oponente.getHP() > 0) {
            String atacar = JOptionPane.showInputDialog("Deseja atacar? (sim/não)");

            try {
                if (atacar.equalsIgnoreCase("sim") || atacar.equalsIgnoreCase("s")) {
                    boolean critico = verificarSorteCritico();
                    if (critico) {
                        int danoMaximo = oponente.getHP();
                        oponente.receberDano(danoMaximo);
                        JOptionPane.showMessageDialog(null, "Ataque crítico! " + meuPokemon.getNome() + " causou dano máximo! O HP do inimigo: " + oponente.getHP());
                        JOptionPane.showMessageDialog(null, "Oponente derrotado! Você venceu a batalha!");
                    } else {
                        meuPokemon.atacar();
                        int dano = calcularDano();
                        oponente.receberDano(dano);
                        JOptionPane.showMessageDialog(null, meuPokemon.getNome() + " atacou o oponente!");
                        JOptionPane.showMessageDialog(null, "O oponente " + oponente.getNome() + " recebeu " + dano + " de dano!" + " O seu pokemon tem de HP: " + meuPokemon.getHP());

                        // Simulando o ataque do oponente
                        oponente.atacar();
                        int danoOponente = calcularDano();
                        meuPokemon.receberDano(danoOponente);
                        JOptionPane.showMessageDialog(null, "O oponente atacou você!");
                        JOptionPane.showMessageDialog(null, meuPokemon.getNome() + " recebeu " + danoOponente + " de dano!" + " Seu HP: " + meuPokemon.getHP());



                        if (meuPokemon.getHP() <= 0) {
                            JOptionPane.showMessageDialog(null, "Você perdeu a batalha!");
                        } else if (oponente.getHP() <= 0) {
                            JOptionPane.showMessageDialog(null, "Você venceu a batalha!");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Você fugiu da batalha!");
                    break; // Sair do loop de batalha se o jogador fugir
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao processar a opção.");
            }
        }
    }

    public static Pokemon getRandomPokemon() {
        Random random = new Random();
        int index = random.nextInt(pokemonMap.size());
        return (Pokemon) pokemonMap.values().toArray()[index];
    }

    public static boolean verificarSorteCritico() {
        Random random = new Random();
        int chance = random.nextInt(10); // 10% de chance de critico
        return chance == 0; // Retorna true se a chance for 0, ou seja, 10% de chance de critico
    }

    public static int calcularDano() {
        Random random = new Random();
        int danoBase = 20; // Dano base do ataque
        int variacao = random.nextInt(11) - 5; // Variação aleatória entre -5 e 5
        return danoBase + variacao;
    }
}
