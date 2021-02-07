package Flyselskep;

public class SilverMembership extends Membership{
    private final float SCALING_POINT_FACTOR = 1.2f;

    @Override
    public int registerPoints(int bonusPointBalance, int newPoints) {
        bonusPointBalance += SCALING_POINT_FACTOR*newPoints;
        return bonusPointBalance;
    }

    @Override
    public String getMembershipName() {
        return "Silver Member";
    }
}
