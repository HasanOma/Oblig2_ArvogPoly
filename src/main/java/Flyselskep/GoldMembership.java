package Flyselskep;

public class GoldMembership extends Membership{
    @Override
    public int registerPoints(int bonusPointBalance, int newPoints) {
        return 0;
    }

    @Override
    public String getMembershipName() {
        return null;
    }
}
