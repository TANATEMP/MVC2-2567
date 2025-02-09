import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SuitDatabase {
    private Map<String, Suit> suits = new HashMap<>();
    private int powerSuitRepairs = 0;
    private int stealthSuitRepairs = 0;
    private int identitySuitRepairs = 0;

    public SuitDatabase() {
        Random random = new Random();
        
        // ชุดทรงพลังปกติ
        for (int i = 1; i <= 10; i++) {
            String id = String.format("%06d", 100000 + i);
            int durability = random.nextInt(31) + 70; //ความทนทานต่ำกว่า70-100
            suits.put(id, new Suit(id, "Power", durability));
        }
        // ชุดทรงพลังพัง
        for (int i = 11; i <= 20; i++) {
            String id = String.format("%06d", 100000 + i);
            int durability = random.nextInt(70); //ความทนทานต่ำกว่า70
            suits.put(id, new Suit(id, "Power", durability));
        }

        // ชุดชุดลอบเร้นปกติ
        for (int i = 1; i <= 10; i++) {
            String id = String.format("%06d", 200000 + i);
            int durability = random.nextInt(51) + 50; // ความทนทาน50-100
            suits.put(id, new Suit(id, "Stealth", durability));
        }

        // ชุดชุดลอบเร้นพัง
        for (int i = 11; i <= 20; i++) {
            String id = String.format("%06d", 200000 + i);
            int durability = random.nextInt(50); // ความทนทานต่ำกว่า50
            suits.put(id, new Suit(id, "Stealth", durability));
        }
        for (int i = 1; i <= 10; i++) {
            String id = String.format("%06d", 300000 + i);
            int durability = generateValidDurabilityForIdentity();// ความทนทานไม่ลงท้ายด้วย3หรือ7
            suits.put(id, new Suit(id, "Identity", durability));
        }

        // ชุดปกปิดตัวตนพัง
        for (int i = 11; i <= 20; i++) {
            String id = String.format("%06d", 300000 + i);
            int durability = generateDurabilityEndingWith3Or7();
            suits.put(id, new Suit(id, "Identity", durability));
        }

    }

    private int generateDurabilityEndingWith3Or7() {
        Random random = new Random();
        int durability;
        // สุ่มจนกว่าจะได้ค่าความทนทานที่ลงท้ายด้วย 3 หรือ 7
        do {
            durability = random.nextInt(101); // ความทนทาน 0-100
        } while (durability % 10 != 3 && durability % 10 != 7); // ตรวจสอบว่าเลขสุดท้ายเป็น 3 หรือ 7
        return durability;
    }

    private int generateValidDurabilityForIdentity() {
        Random random = new Random();
        int durability;
        do {
            durability = random.nextInt(51) + 50;
        } while (durability % 10 == 3 || durability % 10 == 7);
        return durability;
    }

    public Suit findSuit(String id) {
        return suits.get(id);
    }

    //นับจำนวนการซ่อมแต่ละประเภท
    public void repairSuit(Suit suit) {
        if ("Power".equals(suit.getType())) {
            powerSuitRepairs++;
        } else if ("Stealth".equals(suit.getType())) {
            stealthSuitRepairs++;
        } else if ("Identity".equals(suit.getType())) {
            identitySuitRepairs++;
        }
    }

    // Get repair counts for each suit type
    public int getPowerSuitRepairs() {
        return powerSuitRepairs;
    }

    public int getStealthSuitRepairs() {
        return stealthSuitRepairs;
    }

    public int getIdentitySuitRepairs() {
        return identitySuitRepairs;
    }
}
