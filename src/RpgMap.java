public class RpgMap {
    private Room[][] rooms;
    private int sizeX;
    private int sizeY;
    private Player player;

    public RpgMap(int sizeX, int sizeY, int nRooms, Player player) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.player = player;
        int maxCells = sizeX * sizeY;
        int expectedRooms = nRooms;
        if (nRooms > maxCells){
            System.err.println("Number of cells bigger than rooms. Putting rooms as number of cells.");
            expectedRooms = maxCells;
        }
        rooms = new Room[sizeX][sizeY];
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                rooms[i][j] = new Room(' ') {
                    @Override
                    public void search(Player player) {
                        System.out.println("Empty room.\n");
                    }
                };
            }
        }
        rooms[sizeX/2][sizeY/2] = new StartRoom('S');
        player.setPlayerPos(sizeX/2, sizeY/2);
    }

    public void printMap(){
        System.out.println("Checking map:");
        for (int i = 0; i < sizeX; i++) {
            System.out.print("\t|");
            for (int j = 0; j < sizeY; j++) {
                if (i == player.pos.x && j == player.pos.y){
                    System.out.printf("%c", player.playerChar);
                }else{
                    System.out.printf("%c", rooms[i][j].getRoomChar());
                }
            }
            System.out.print("|\n");
        }
    }

    public void searchAtPos(Position pos){
        rooms[pos.x][pos.y].search(player);
    }
}
