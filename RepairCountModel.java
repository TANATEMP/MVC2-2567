public class RepairCountModel {
    private int powerSuitRepairs;
    private int stealthSuitRepairs;
    private int identitySuitRepairs;

    public RepairCountModel() {
        this.powerSuitRepairs = 0;
        this.stealthSuitRepairs = 0;
        this.identitySuitRepairs = 0;
    }

    //นับจำนวนการซ่อมแยกตามประเภท
    public void increaseRepairCount(Suit suit) {
        if (suit == null) return;

        switch (suit.getType()) {
            case "Power":
                powerSuitRepairs++;
                break;
            case "Stealth":
                stealthSuitRepairs++;
                break;
            case "Identity":
                identitySuitRepairs++;
                break;
            default:
                break;
        }
    }

    public int getPowerSuitRepairs() {
        return powerSuitRepairs;
    }

    public int getStealthSuitRepairs() {
        return stealthSuitRepairs;
    }

    public int getIdentitySuitRepairs() {
        return identitySuitRepairs;
    }

    public void resetRepairCounts() {
        powerSuitRepairs = 0;
        stealthSuitRepairs = 0;
        identitySuitRepairs = 0;
    }

    public String getRepairCounts() {
        return "Repair Counts: Power: " + powerSuitRepairs + " Stealth: " + stealthSuitRepairs + " Identity: " + identitySuitRepairs;
    }
}
