class Main{
    public static void main(String[] Args){
        ConfigHandler r = new ConfigHandler();
        GameConfig data = r.readConfigs();
        System.out.println(data);
    }
}