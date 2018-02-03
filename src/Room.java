public abstract class Room {
    private char roomChar;

    public Room(char roomChar){
        this.roomChar = roomChar;
    }

    public abstract void search(Player player);

    public char getRoomChar() {
        return roomChar;
    }
}
