public class Player {
    private String name;
    private int hp;
    private int baseDmg;
    public Position pos;
    public char playerChar;

    Player(String name, char playerChar, int hp, int baseDmg){
        this.name = name;
        this.playerChar = playerChar;
        this.hp = hp;
        this.baseDmg = baseDmg;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getBaseDmg() {
        return baseDmg;
    }
    public void setPlayerPos(int posX, int posY){
        this.pos = new Position(posX, posY);
    }

    public void setPlayerPos(Position pos){
        this.pos = new Position(pos);
    }

    @Override
    public String toString() {
        return "Player " + name + ": \n\t Health Points: " + getHp() + "\n\t Base Damage: " + getBaseDmg() + "\n\t Position: (x = " + pos.x + ", y = " + pos.y + ")";
    }
}
