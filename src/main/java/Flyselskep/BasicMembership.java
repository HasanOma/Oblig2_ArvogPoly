package Flyselskep;

public class BasicMembership extends Membership{

    /**
     * method to register new points for a member and add on bonudpoints
     * @param bonusPointBalance bonus point balance for the user flights
     * @param newPoints new points that user has recieved
     * @return bonuspoints that that member has
     */
    @Override
    public int registerPoints(int bonusPointBalance, int newPoints) {
        return bonusPointBalance + newPoints;
    }

    /**
     * method that gives membershipname
     * @return membershipname
     */
    @Override
    public String getMembershipName() {
        return "Basic member";
    }
}
