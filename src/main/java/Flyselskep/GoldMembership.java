package Flyselskep;

public class GoldMembership extends Membership{

    private final float SCALING_POINT_FACTOR_LEVEL1 = 1.3f;
    private final float SCALING_POINT_FACTOR_LEVEL2 = 1.5f;


    /**
     * method to register new points for a member and add on bonudpoints
     * @param bonusPointBalance bonus point balance for the user flights
     * @param newPoints new points that user has recieved
     * @return bonuspoints that that member has
     */
    @Override
    public int registerPoints(int bonusPointBalance, int newPoints) {
        int total;
        if (bonusPointBalance <= 90000){
            total = (bonusPointBalance += newPoints * SCALING_POINT_FACTOR_LEVEL1);
        }
        else {
            total = (bonusPointBalance += newPoints * SCALING_POINT_FACTOR_LEVEL2);
        }
        return total;
    }

    /**
     * method that gives membershipname
     * @return membershipname
     */
    @Override
    public String getMembershipName() {
        return "Gold member";
    }
}
