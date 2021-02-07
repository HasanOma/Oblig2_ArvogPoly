package Flyselskep;

public class BasicMembership extends Membership{
    @Override
    public int registerPoints(int bonusPointBalance, int newPoints) {
        return newPoints;
    }

    @Override
    public String getMembershipName() {
        return "Basic member";
    }
}
