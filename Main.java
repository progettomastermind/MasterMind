class Main{
    public static void main(String[] Args){
        ConfigHandler r = new ConfigHandler();
        GameConfig data = r.readConfigs();
        System.out.println(data);
        data.colors = 4;
        System.out.println(r.writeConfigs(data));
    }
}