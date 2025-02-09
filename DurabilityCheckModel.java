public class DurabilityCheckModel {
    //ตรวจสอบความทนทาน
    public boolean isDurabilityValid(Suit suit) {
        String type = suit.getType();
        int durability = suit.getDurability();

        if ("Power".equals(type)) {
            return durability >= 70;
        } else if ("Stealth".equals(type)) {
            return durability >= 50;
        } else if ("Identity".equals(type)) {
            return durability % 10 != 3 && durability % 10 != 7;
        }

        return false;
    }
}