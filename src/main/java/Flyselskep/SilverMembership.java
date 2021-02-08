package Flyselskep;

public class SilverMembership extends Membership{
    private final float SCALING_POINT_FACTOR = 1.2f;

    /**
     * method to register new points for a member and add on bonudpoints
     * @param bonusPointBalance bonus point balance for the user flights
     * @param newPoints new points that user has recieved
     * @return bonuspoints that that member has
     */
    @Override
    public int registerPoints(int bonusPointBalance, int newPoints) {
        int total = (bonusPointBalance += SCALING_POINT_FACTOR*newPoints);

        return total;
    }

    /**
     * method that gives membershipname
     * @return membershipname
     */
    @Override
    public String getMembershipName() {
        return "Silver Member";
    }
}
