package observer;

import java.util.ArrayList;
import java.util.List;

public class GroupAdmin implements Sender {

    // the list of members
    private List<Member> subs = new ArrayList<>();
    private int last =0;
    // the message
    private UndoableStringBuilder usb = new UndoableStringBuilder();

    /**
     *  member to be added to the list of members
     *          to be notified when a message is sent
     *          by the group admin
     *          getting a member object and addes it to the list.
     */
    @Override
    public void register(Member obj) {
        subs.add(obj); last++;
    }

    /**
     *     member to be removed from the list of members
     *          to be notified when a message is sent
     *          by the group admin
     *          getting a member object and removes it from the list.
     */
    @Override
    public void unregister(Member obj) {
        subs.remove(obj);last--;
    }

    /**
     *
     * @param offset the index at which to insert the string
     * @param obj the string to be inserted
     *
     *            inserting a string to the message at a given index
     */
    @Override
    public void insert(int offset, String obj) {
        this.usb.insert(offset,obj);
    }

    /**
     * @param obj the string to be appended to the message
     *            appending a string to the message
     *            changimg the message that is sent to the members
     *            by the group admin undoStringBuilder.
     */
    @Override
    public void append(String obj) {
        this.usb.append(obj);
    }

    /**
     * @param start the beginning index, inclusive.
     *
     * @param end the ending index, exclusive.
     *            deleting a substring from the message
     *            changimg the message that is sent to the members
     *            by the group admin undoStringBuilder.
     */
    @Override
    public void delete(int start, int end) {
        this.usb.delete(start,end);
    }

    /**
     *
     *          undoing the last change to the message
     *          changimg the message that is sent to the members
     *          by the group admin undoStringBuilder.
     */
    @Override
    public void undo() {
        this.usb.undo();

    }
    /**
     *   notifying all the members in the list
     *   by update method.
     */


    public void notifyMembers() {
        for (Member m : subs)
            m.update(this.usb);
    }

    /**
     *
     * @return the last member that was added to the list.
     */
    public Member getLastMember(){
        if(this.subs.isEmpty()){
            return null;
        }
        return this.subs.get(last - 1);
    }

    /**
     *
     * @return the message that is sent to the members
     *        by the group admin undoStringBuilder.
     */
    public UndoableStringBuilder getStringBuilder(){
        return this.usb;
    }

    public List<Member> getSubs(){
        return this.subs;
    }

}
