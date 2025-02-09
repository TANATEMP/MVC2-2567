public class Controller {
    private SuitDatabase suitRepository;
    private DurabilityCheckModel durabilityCheckModel;
    private SuitRepaireModel suitRepaireModel;
    private SuitInputView suitInputView;
    private SuitResultView suitResultView;
    private SuitRepairView suitRepairView;

    public Controller(SuitDatabase suitRepository,DurabilityCheckModel durabilityCheckModel, SuitRepaireModel suitRepaireModel, SuitInputView suitInputView, SuitResultView suitResultView, SuitRepairView suitRepairView) {
        this.suitRepository = suitRepository;
        this.suitInputView = suitInputView;
        this.suitResultView = suitResultView;
        this.suitRepairView = suitRepairView;
        this.durabilityCheckModel = durabilityCheckModel;
        this.suitRepaireModel = suitRepaireModel;

        suitInputView.addCheckButtonListener(e -> handleSuitCheck());

        suitResultView.addRepairButtonListener(e -> handleRepairSuit());
    }

    private void handleSuitCheck() {
        String suitId = suitInputView.getSuitId();
    
        // เช็คformat input
        if (!isValidSuitId(suitId)) {
            suitInputView.setErrorMessage("Invalid Suit ID! It should be a 6-digit number, with the first digit not 0.");
            return;
        }
    
        suitInputView.clearErrorMessage();
    
        Suit suit = suitRepository.findSuit(suitId);
        if (suit == null) {
            suitResultView.showResult("Suit ID not found");
        } else {
            String message = "Suit ID: " + suit.getId() + "\nType: " + suit.getType();
            
            if (durabilityCheckModel.isDurabilityValid(suit)) {
                message += "\nDurability is valid."; 
                suitResultView.showResult(message, suit);
            } else {
                message += "\nDurability is not sufficient.";
                suitResultView.showResult(message, suit);
                suitResultView.showRepairButton(); //แสดงปุ่มrepair ถ้าพัง
            }
        }
    
        suitResultView.setVisible(true);
    }

    private void handleRepairSuit() {
        Suit suit = suitResultView.getSuitForRepair();
        if (suit != null) {
            suitRepaireModel.repair(suit); //เรียกใช้Repaire Model เพื่อซ่อม
            suitRepository.repairSuit(suit); // นับการซ่อมในdatabase

            String message = "Suit ID: " + suit.getId() + "\nType: " + suit.getType();
            
            if (durabilityCheckModel.isDurabilityValid(suit)) {
                message += "\nDurability is valid.";
                suitResultView.showResult(message, suit);
            } else {
                message += "\nDurability is not sufficient.";
                suitResultView.showResult(message, suit);
                suitResultView.showRepairButton();
            }
            
            //อัพเดตการแสดงจำนวนการซ่อม
            String repairCounts = String.format("Repair Counts: Power: %d, Stealth: %d, Identity: %d", 
                                            suitRepository.getPowerSuitRepairs(), 
                                            suitRepository.getStealthSuitRepairs(), 
                                            suitRepository.getIdentitySuitRepairs());
            suitInputView.setRepairCountText(repairCounts);

            suitResultView.showResult(message, suit);
            suitRepairView.showRepairResult(suit);
        }

        //แสดงผลการซ่อมจากRepairVeiw
        suitRepairView.setVisible(true);
    }

    // เช็คformat input
    private boolean isValidSuitId(String suitId) {
        return suitId.matches("[1-9]\\d{5}");
    }
}
