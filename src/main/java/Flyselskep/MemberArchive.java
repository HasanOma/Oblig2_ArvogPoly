package Flyselskep;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.time.LocalDate;

/**
 * The member archive holds all the bonus members. The archive provides
 * functionality for adding members to the register, looking up bonuspoints
 * of given members, registering new bonuspoints and listing all the members.
 *
 * @author arne
 */
public class MemberArchive {

    // Use a HashMap, since the members have a unique member number.
    private HashMap<Integer, BonusMember> members= new HashMap<>();
    private LocalDate now;

    /**
     * Creates a new instance of MemberArchive.
     */
    public MemberArchive() {
        this.fillRegisterWithTestdata();
    }

    /**
     * Adds a new member to the register. The new member must have a memebr number
     * different from exsisting members. If not, the new member will not be added.
     *
     * @return -1 if member allready exists
     *         1 if member is added
     */
    public int addMember(BonusMember bonusMember) {
        int memberInteger;
        BonusMember newMember = new BonusMember(bonusMember);
        if (members.containsKey(bonusMember.getMemberNumber())){
            memberInteger = -1;
        }
        else {
            BonusMember member = new BonusMember(newMember);
            members.put(member.getMemberNumber(), newMember);
            memberInteger = 1;
        }

        return memberInteger;
    }

    /**
     * Registers new bonuspoints to the member with the member number given
     * by the parameter {@code memberNumber}. If no member in the register
     * matches the provided member number, {@code false} is returned.
     *
     * @param memberNumber the member number to add the bonus points to
     * @param bonusPoints the bonus points to be added
     * @return {@code true} if bonuspoints were added successfully,
     *         {@code flase} if not.
     */
    public boolean registerPoints(int memberNumber, int bonusPoints) {
        boolean success = false;
        if (members.get(memberNumber).registerBonusPoints(bonusPoints)){
            members.get(memberNumber).checkAndSetMembership();
            return true;
        }
        return success;
    }

    /**
     * this method finds points that each member we are searching for has
     * @param memberNumber number of member you want to find
     * @param password checks if password corresponds with the member
     * @return returns actual ammount of bonuspoints if password checks out
     * returns -1 otherwise
     */
    public int findPoints(int memberNumber, String password) {
        BonusMember copySearch = members.get(memberNumber);
        if (copySearch.checkPassword(password)){
        return copySearch.getBonusPointsBalance();
        }
        return -1;
    }

    /**
     * Lists all members.
     */
    public List<BonusMember> allMembers() {
        List<BonusMember> res = new ArrayList<>();
        for (BonusMember member : members.values()) {
                res.add(member);
        }
        return res;
    }


    /**
     * Fills the register with some arbitrary members, for testing purposes.
     */
    public void fillRegisterWithTestdata() {
        BonusMember member = new BonusMember(1, LocalDate.now(), 10000, "Olsen, Ole", "ole@olsen.biz");
        members.put(member.getMemberNumber(), member);
        member = new BonusMember(2, LocalDate.now(), 15000, "Jensen, Jens", "jens@jensen.biz");
        members.put(member.getMemberNumber(), member);
        member = new BonusMember(3, LocalDate.now(), 5000, "Lie, Linda", "linda@lie.no");
        members.put(member.getMemberNumber(), member);
        member = new BonusMember(4, LocalDate.now(), 30000, "Paulsen, Paul", "paul@paulsen.org");
        members.put(member.getMemberNumber(), member);
        member = new BonusMember(5, LocalDate.now(), 75000, "FLo, Finn", "finn.flo@gmail.com");
        members.put(member.getMemberNumber(), member);

    }


}
