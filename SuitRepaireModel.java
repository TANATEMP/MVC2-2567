public class SuitRepaireModel {
    //ซ่อมโดยเพิ่มdurabilityของsuit
    public void repair(Suit suit) {
        int durability = suit.getDurability();
        if (durability + 25 <= 100) {
            suit.setDurability(durability + 25);
        } else {
            suit.setDurability(100);// ไม่ให้เกิน 100
        }
    }
}
