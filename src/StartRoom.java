public class StartRoom extends Room{

    public StartRoom(char roomChar){
        super(roomChar);
    }

    @Override
    public void search(Player player) {
        System.out.println("\nHello, " + player.getName() + "\nThis is the start room, from now on check the map for where to move.\n");
    }
}
