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

    private Membership membership;


    public BonusMember(int memberNumber, LocalDate enrolledDate, int bonusPointsBalance, String name, String eMailAddress) {
        this.memberNumber = memberNumber;
        this.enrolledDate = enrolledDate;
        this.bonusPointsBalance = bonusPointsBalance;
        this.name = name;
        this.eMailAddress = eMailAddress;
    }

    public BonusMember(BonusMember bonusMember) {
        this.memberNumber = bonusMember.getMemberNumber();
        this.enrolledDate = bonusMember.getEnrolledDate();
        this.bonusPointsBalance = bonusMember.getBonusPointsBalance();
        this.name = bonusMember.getName();
        this.eMailAddress = bonusMember.geteMailAddress();

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

    public boolean registerBonusPoints(int newPoints){
        this.bonusPointsBalance = membership.registerPoints(bonusPointsBalance, newPoints);
        return true;
    }

    public String getMembershipLevel(){
        return membership.getMembershipName();
    }

    private void checkAndSetMembership(){
        if(bonusPointsBalance>GOLD_LIMIT && !(membership instanceof GoldMembership)) {
            membership = new GoldMembership();
        }
        else if ((bonusPointsBalance<GOLD_LIMIT && bonusPointsBalance>SILVER_LIMIT) && !(membership instanceof SilverMembership)){
            membership = new SilverMembership();
        }
        else if(bonusPointsBalance<SILVER_LIMIT && !(membership instanceof BasicMembership)){
            membership = new BasicMembership();
        }
    }


    @Override
    public String toString() {
        return "BonusMember{" +
                "memberNumber=" + memberNumber +
                ", enrolledDate=" + enrolledDate +
                ", bonusPointsBalance=" + bonusPointsBalance +
                ", name='" + name + '\'' +
                ", eMailAddress='" + eMailAddress + '\'' +
                ", password='" + password + '\'' +
                ", membership=" + membership +
                '}';
    }
}
