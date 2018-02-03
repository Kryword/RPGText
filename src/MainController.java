import java.util.Scanner;

public class MainController {
    
    private RpgMap map;
    private int sizeX;
    private int sizeY;
    private char playerChar;
    Player player;
    private MainController(int x, int y, String playerName, int hp, int baseDmg){
        sizeX = x;
        sizeY = y;
        playerChar = '#';
        player = new Player(playerName, playerChar, hp, baseDmg);
        map = new RpgMap(x, y, 10, player);
    }

    private char printOptions(){
        System.out.println(player);
        System.out.print("Choose move(north n, south s, west w, east e, check-map c, investigate-room r, exit q): ");
        Scanner sc = new Scanner(System.in);
        return sc.next().charAt(0);
    }

    public static void main(String[] args) {
        int option;
        MainController mc = new MainController(10, 10, "Alduin", 10, 5);
        do {
            option = mc.printOptions();
            switch (option){
                case 'n':if(mc.player.pos.x > 0) mc.player.setPlayerPos(mc.player.pos.x - 1, mc.player.pos.y);
                    break;
                case 's':if(mc.player.pos.x < mc.sizeX - 1) mc.player.setPlayerPos(mc.player.pos.x + 1, mc.player.pos.y);
                    break;
                case 'w':if(mc.player.pos.y > 0) mc.player.setPlayerPos(mc.player.pos.x, mc.player.pos.y - 1);
                    break;
                case 'e':if(mc.player.pos.y < mc.sizeY - 1) mc.player.setPlayerPos(mc.player.pos.x, mc.player.pos.y + 1);
                    break;
                case 'c':mc.map.printMap();
                    break;
                case 'r':mc.map.searchAtPos(mc.player.pos);
                    break;
                case 'q':printExit();
                    break;
            }
        }while(option != 'q');
    }
    public static void printExit(){
        System.out.println("Bye, hope you come back soon!");
    }
}
