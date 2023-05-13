package Tasks.SegundoExercicio;

public abstract class Pokemon {
    private String nome;
    private String tipo;
    private int nivel;
    private int HP;

    public Pokemon(String nome, String tipo, int nivel, int HP) {
        this.nome = nome;
        this.tipo = tipo;
        this.nivel = nivel;
        this.HP = HP;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public int getNivel() {
        return nivel;
    }

    public int getHP() {
        return HP;
    }

    public void receberDano(int dano) {
        HP -= dano;
        if (HP < 0) {
            HP = 0;
        }
    }

    public abstract void atacar();
}