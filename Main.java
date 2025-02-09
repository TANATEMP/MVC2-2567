public class Main {
    public static void main(String[] args) {
        // สร้าง Model, View, และ Controller
        SuitDatabase suitRepository = new SuitDatabase();
        DurabilityCheckModel durabilityCheckModel = new DurabilityCheckModel();
        SuitRepaireModel suitRepaireModel = new SuitRepaireModel();
        RepairCountModel repairCountModel = new RepairCountModel();
        SuitInputView suitInputView = new SuitInputView();
        SuitResultView suitResultView = new SuitResultView();
        SuitRepairView suitRepairView = new SuitRepairView();

        new Controller(suitRepository, durabilityCheckModel, suitRepaireModel,repairCountModel, suitInputView, suitResultView, suitRepairView);
    }
}
