package Flyselskep;

public class GoldMembership extends Membership{

    private final float SCALING_POINT_FACTOR_LEVEL1 = 1.3f;
    private final float SCALING_POINT_FACTOR_LEVEL2 = 1.5f;

    @Override
    public int registerPoints(int bonusPointBalance, int newPoints) {
        if (bonusPointBalance <= 90000){
            bonusPointBalance += newPoints * SCALING_POINT_FACTOR_LEVEL1;
        }
        else {
            bonusPointBalance += newPoints * SCALING_POINT_FACTOR_LEVEL2;
        }
        return bonusPointBalance;
    }

    @Override
    public String getMembershipName() {
        return "Gold member";
    }
}
