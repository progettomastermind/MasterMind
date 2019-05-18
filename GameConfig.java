class GameConfig{
    public int length;
    public int attempts;
    public int colors;

    GameConfig(int length, int attempts, int colors){
        this.length = length;
        this.attempts = attempts;
        this.colors = colors;
    }

    @Override
    public String toString(){
        String n = new String();
        return n + length + "\n" + attempts + "\n" + colors;
    }
}