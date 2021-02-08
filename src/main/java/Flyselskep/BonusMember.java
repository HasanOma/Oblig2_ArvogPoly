package Flyselskep;

import java.time.LocalDate;

public class BonusMember {

    private final int memberNumber;
    private final LocalDate enrolledDate;
    private int bonusPointsBalance;
    private final String name;
    private final String eMailAddress;
    private String password;

    private static final int SILVER_LIMIT = 25000;
    private static final int GOLD_LIMIT = 75000;

    private Membership membership = new BasicMembership();

    /**
     * Constructer of the class
     * @param memberNumber number of the member
     * @param enrolledDate date of becoming a member
     * @param bonusPointsBalance bonus point balance of the member
     * @param name name of the member
     * @param eMailAddress email adress of the member
     */
    public BonusMember(int memberNumber, LocalDate enrolledDate, int bonusPointsBalance, String name, String eMailAddress) {
        this.memberNumber = memberNumber;
        this.enrolledDate = enrolledDate;
        this.bonusPointsBalance = bonusPointsBalance;
        this.name = name;
        this.eMailAddress = eMailAddress;
        checkAndSetMembership();
    }

    /**
     * second constructer of the class
     * @param bonusMember takes in an object as the parameter with all varialbles ass the first constructor
     */
    public BonusMember(BonusMember bonusMember) {
        this.memberNumber = bonusMember.getMemberNumber();
        this.enrolledDate = bonusMember.getEnrolledDate();
        this.bonusPointsBalance = bonusMember.getBonusPointsBalance();
        this.name = bonusMember.getName();
        this.eMailAddress = bonusMember.geteMailAddress();
        checkAndSetMembership();

    }

    public int getMemberNumber() {
        return memberNumber;
    }

    public String geteMailAddress() {
        return eMailAddress;
    }

    public LocalDate getEnrolledDate() {
        return enrolledDate;
    }

    public int getBonusPointsBalance() {
        return bonusPointsBalance;
    }

    public String getName() {
        return name;
    }

    /**
     * method that checks if password from parameter and object password is the same
     * @param passWord String that you want to check if it is your password
     * @return true if password is same
     */
    public boolean checkPassword(String passWord){
        return password.trim().equalsIgnoreCase(passWord.trim());
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BonusMember that = (BonusMember) o;
        return memberNumber == that.memberNumber;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    /**
     * this method registers bonuspoints of a member
     * @param newPoints new points that user has made
     * @return true if points were registered
     */
    public boolean registerBonusPoints(int newPoints){
        this.bonusPointsBalance = membership.registerPoints(bonusPointsBalance, newPoints);
        return true;
    }

    /**
     * this method gives us the membership name
     * @return membership name
     */
    public String getMembershipLevel(){
        return membership.getMembershipName();
    }

    /**
     * this method checks bonuspoints of the members and updates the membership status
     */
    public void checkAndSetMembership(){
        if(bonusPointsBalance>=GOLD_LIMIT && !(membership instanceof GoldMembership)) {
            membership = new GoldMembership();
        }
        else if ((bonusPointsBalance<GOLD_LIMIT && bonusPointsBalance>=SILVER_LIMIT) && !(membership instanceof SilverMembership)){
            membership = new SilverMembership();
        }
        else if(bonusPointsBalance<SILVER_LIMIT && !(membership instanceof BasicMembership)){
            membership = new BasicMembership();
        }
    }

    @Override
    public String toString() {
        return "Member number: " + memberNumber +
                ", Enrolled date: " + enrolledDate +
                ", Bonus points balance: " + bonusPointsBalance +
                "," + membership.getMembershipName() +
                ", Name: " + name  +
                ", eMail: " + eMailAddress;

        //Do not print out password because it is a password.

    }
}
